package algo;

import java.io.*;
import java.util.*;
public class back_2636 
{
	static class node
	{
		public int y;
		public int x;
		public node(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int map[][];
	static LinkedList<node> cheeseHoles=new LinkedList<>();
	static LinkedList<node> nodeList=new LinkedList<>();
	static LinkedList<node> meltingCheeses=new LinkedList<>();
	static int height;
	static int width;
	static public void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String sizeInput[]=br.readLine().split(" ");
		height=Integer.parseInt(sizeInput[0]);
		width=Integer.parseInt(sizeInput[1]);
		map=new int [height][width];
		
		int meltedCheeseCount=0;
		int hour=0;
		for(int i=0;i<height;i++)
		{
			String inputWidth[]=br.readLine().split(" ");
			for(int j=0;j<width;j++)
			{
				map[i][j]=Integer.parseInt(inputWidth[j]);
			}
		}
		while(isCheesePresent())
		{
			meltedCheeseCount=0;
			cheeseHoles.clear();
			meltingCheeses.clear();
			findCheeseHole();
	
			for(int i=0;i<height;i++)
				for(int j=0;j<width;j++)
				{
					if(map[i][j]==1)
					{
						if(isAirContacted(i,j))
						{	
							meltingCheeses.add(new node(i,j));
							meltedCheeseCount++;
						}
					}
				}
			for(node a : meltingCheeses)
			{
				//System.out.println(a.y+" "+a.x);
				map[a.y][a.x]=0;
			}
			hour++;
			//System.out.println(meltedCheeseCount);
			
		}
		System.out.println(hour);
		System.out.println(meltedCheeseCount);
	}
	private static boolean isAirContacted(int y, int x) 
	{
		for(int i=0;i<4;i++)
		{
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cx>=width||cy<0||cy>=height)
				continue;
			if(map[cy][cx]==0)
			{
				boolean isCheesHole=false;
	            for(node a: cheeseHoles)
	            {
	               if(a.x==cx&&a.y==cy)
	               {
	                  isCheesHole=true;
	                  break;
	               }   
	            }
	            if(!isCheesHole)
					return true;
			}
		}
		return false;
	}
	
	private static void findCheeseHole() 
	{
		
		boolean visited[][]=new boolean [height][width];
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
			{	
				if(map[i][j]==0&&visited[i][j]==false)
				{	
					if(findCheeseHoleBFS(i,j,visited))
					{
						for(node a : nodeList)
							cheeseHoles.add(a);
					}
					nodeList.clear();
				}
			}
	}
	private static boolean findCheeseHoleBFS(int y, int x, boolean[][] visited) 
	{
		visited[y][x]=true;
		Queue<node> queue=new LinkedList<>();
		queue.add(new  node(y,x));
		nodeList.add(new node(y,x));
		boolean isCheeseHole=true;
		while(!queue.isEmpty())
		{
			node nowNode=queue.poll();
			for(int i=0;i<4;i++)
			{
				int cx=nowNode.x+dx[i];
				int cy=nowNode.y+dy[i];
				if(cx<0||cx>=width||cy<0||cy>=height)
				{
					isCheeseHole=false;
					continue;
				}
					
				if(visited[cy][cx]||map[cy][cx]==1)
					continue;
				node newNode=new node(cy,cx);
				queue.add(newNode);
				nodeList.add(newNode);
				visited[cy][cx]=true;
			}
		}
		return isCheeseHole;
	}
	private static boolean isCheesePresent() {
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				if(map[i][j]==1)
					return true;
		return false;
	}
	 public static void printMapEntries(Map<Integer, Integer> cheeseHoles2) {
	        cheeseHoles2.forEach((key, value) -> 
	            System.out.println("Key: " + key+ ", Value: " + value)
	        );
	    }
}
