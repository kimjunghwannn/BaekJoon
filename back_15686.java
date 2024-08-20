package algo;

import java.util.*;
import java.io.*;
public class back_15686 {
	static class chickenRes
	{
		point chickenPoint;
		LinkedList<point> res;
		
		public chickenRes(int y,int x)
		{
			chickenPoint =new point(y,x,0);
			this.res=new LinkedList<>();
		}
		
	}
	static class point
	{
		public int y;
		public int x;
		public int distance;
		public point(int y,int x,int distance)
		{
			this.y=y;
			this.x=x;
			this.distance=distance;
		}
	}
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int mapSize;
	static int map[][];
	static int chickenN;
	static chickenRes chickenResArray[];
	static int minSum=Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String mapsizeAndchikenN=br.readLine();
		
		mapSize=Integer.parseInt(mapsizeAndchikenN.split(" ")[0]);
		chickenN=Integer.parseInt(mapsizeAndchikenN.split(" ")[1]);
		
		map=new int [mapSize][mapSize];
		Queue<chickenRes> queue=new LinkedList<>();
		
		for(int i=0;i<mapSize;i++)
		{
			String rowInput[]=br.readLine().split(" ");
			for(int j=0;j<mapSize;j++)
			{
				if(Integer.parseInt(rowInput[j])==2)
					queue.add(new chickenRes(i,j));				
				map[i][j]=Integer.parseInt(rowInput[j]);
			}	
		}
		
		chickenResArray=new chickenRes[queue.size()];
		int index=0;
		while(!queue.isEmpty())
		{
			chickenResArray[index++]=bfs(queue.poll());
			
		}
		doCombination(new LinkedList<>(),0);
		System.out.println(minSum);
	}
	private static void doCombination(LinkedList<chickenRes> linkedList, int index) 
	{
		if(linkedList.size()==chickenN)
		{
			int minDistance[][]=new int [mapSize][mapSize];
			for(chickenRes a :linkedList)
			{
				for(point now: a.res)
				{
					if(minDistance[now.y][now.x]==0||minDistance[now.y][now.x]>now.distance)
						minDistance[now.y][now.x]=now.distance;
				}
			}
			int sum=0;
			for(int i=0;i<mapSize;i++)
			{
				for(int j=0;j<mapSize;j++)
				{
					if(minDistance[i][j]!=0)
						sum+=minDistance[i][j];
				}
			}
			minSum=Math.min(minSum, sum);
		}
		for(int i=index;i<chickenResArray.length;i++)
		{
			linkedList.add(chickenResArray[i]);
			doCombination(linkedList,i+1);
			linkedList.remove(linkedList.size()-1);
		}
	}
	static public chickenRes bfs(chickenRes nowChickenRes)
	{
		boolean visited[][]=new boolean [mapSize][mapSize];
		Queue<point> queue=new LinkedList<>();
		queue.add(new point(nowChickenRes.chickenPoint.y,nowChickenRes.chickenPoint.x,0));
		visited[nowChickenRes.chickenPoint.y][nowChickenRes.chickenPoint.x]=true;
		while(!queue.isEmpty())
		{
			point now=queue.poll();
			for(int i=0;i<4;i++)
			{
				int cx=now.x+dx[i];
				int cy=now.y+dy[i];
				if(cx<0||cy<0||cx>=mapSize||cy>=mapSize)
					continue;
				if(visited[cy][cx])
					continue;
				
				point newPoint=new point(cy,cx,now.distance+1);
				if(map[cy][cx]==1)
				{
					nowChickenRes.res.add(newPoint);
				}
				visited[cy][cx]=true;
				queue.add(newPoint);
			}
			
		}
		return nowChickenRes;
	}
}
