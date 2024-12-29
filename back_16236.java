package algo;

import java.io.*;
import java.util.*;
public class back_16236 
{
	static class Point
	{
		public int y;
		public int x;
		public int n;
		public Point(int y,int x,int n)
		{
			this.y=y;
			this.x=x;
			this.n=n;
		}
	}
	static int map[][];
	static int time=0;
	static int dx[]= {0,-1,1,0};
	static int dy[]= {-1,0,0,1};
	static int sharkSize=2;
	static int eatenCount=0;
	static Point sharkPoint;
	static final int sharkFirstPoint=100000;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		map=new int [N][N];
		for(int i=0;i<N;i++)
		{
			String inputLine[]=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(inputLine[j]);
				if(map[i][j]==9)
				{	
					sharkPoint=new Point(i,j,0);
					map[i][j]=sharkFirstPoint;
				}
			}
		}
		while(true)
		{
			if(!findEatableFishBFS())
				break;
			eatenCount++;
			if(eatenCount==sharkSize)
			{	
				sharkSize++;
				eatenCount=0;
			}
		}
		System.out.println(time);
	}
	private static boolean findEatableFishBFS() 
	{
		Queue<Point> queue=new LinkedList<>();
		queue.add(sharkPoint);
		boolean visited[][]=new boolean [map.length][map.length];
		visited[sharkPoint.y][sharkPoint.x]=true;
		while(!queue.isEmpty())
		{
			Point now=queue.poll();
			for(int i=0;i<4;i++)
			{
				int cx=now.x+dx[i];
				int cy=now.y+dy[i];
				if(cx<0||cx>=map.length||cy<0||cy>=map.length)
					continue;
				if(map[cy][cx]!=sharkFirstPoint&&map[cy][cx]>sharkSize)
					continue;
				if(visited[cy][cx])
					continue;
				if(map[cy][cx]!=0&&map[cy][cx]<sharkSize)
				{
					Queue<Point> newQueue=new LinkedList<>();
					newQueue.add(now);
					while(!queue.isEmpty())
					{
						
						if(queue.peek().n==now.n)
							newQueue.add(queue.poll());
						else
							queue.poll();
					}
					Point choicePoint=findTopAndLeft(newQueue);
					time+=now.n+1;
					sharkPoint.y=choicePoint.y;
					sharkPoint.x=choicePoint.x;
					map[choicePoint.y][choicePoint.x]=0;
					return true;
				}
				visited[cy][cx]=true;
				queue.add(new Point(cy,cx,now.n+1));
			}
		}
		return false;
	}
	static Point findTopAndLeft(Queue<Point> newQueue)
	{
		Point choicePoint=new Point(50,50,0);
		while(!newQueue.isEmpty())
		{
			Point now=newQueue.poll();
			for(int i=0;i<4;i++)
			{
				
				int cx=now.x+dx[i];
				int cy=now.y+dy[i];
				if(cx<0||cx>=map.length||cy<0||cy>=map.length)
					continue;
				if(map[cy][cx]!=sharkFirstPoint&&map[cy][cx]>sharkSize)
					continue;
				if(map[cy][cx]!=0&&map[cy][cx]<sharkSize)
				{
					if(choicePoint.y>cy||choicePoint.y==cy&&choicePoint.x>cx)
					{
						choicePoint.y=cy;
						choicePoint.x=cx;
					}
				}
				
			}
		}
		return choicePoint;
	}
}
