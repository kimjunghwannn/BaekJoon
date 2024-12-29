package algo;

import java.io.*;
import java.util.*;
public class back_18405 
{
	static class Point
	{
		public int y;
		public int x;
		public int kind;
		public int time;
		public Point(int y, int x,int kind,int time)
		{
			this.y=y;
			this.x=x;
			this.kind=kind;
			this.time=time;
		}
	}
	static class Virus
	{
		LinkedList<Point> position =new LinkedList<>();	
	}
	static Virus virusArray[];
	static int map[][];
	static boolean visited[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		map=new int [N][N];
		visited=new boolean [N][N];
		initializeVirus(K);
		initializeMap(br,N);
		
		String input2[]=br.readLine().split(" ");
		int time=Integer.parseInt(input2[0]);
		Point targetPoint=new Point(Integer.parseInt(input2[1]),Integer.parseInt(input2[2]),0,0);
		
		if(map[targetPoint.y-1][targetPoint.x-1]!=0)
		{
			System.out.println(map[targetPoint.y-1][targetPoint.x-1]);
			System.exit(0);
		}
		
		Queue<Point> queue=new LinkedList<>();
		for(int i=1;i<=K;i++)
		{
			if(virusArray[i].position.isEmpty())
				continue;
			for(Point a : virusArray[i].position)
				queue.add(a);
		}
		while(!queue.isEmpty())
		{
			Point now=queue.poll();
			for(int i=0;i<4;i++)
			{
				if(now.time>=time)
				{
					System.out.println(0);
					System.exit(0);
				}
				int cx=now.x+dx[i];
				int cy=now.y+dy[i];
					
				if(cx<0||cx>=N||cy<0||cy>=N)
					continue;
				if(visited[cy][cx])
					continue;
				if(targetPoint.y-1==cy&&targetPoint.x-1==cx)
				{
					System.out.println(now.kind);
					System.exit(0);
				}
				Point newPoint=new Point(cy,cx,now.kind,now.time+1);
				visited[cy][cx]=true;
				virusArray[now.kind].position.add(newPoint);
				queue.add(newPoint);
			}
		}
	}
	private static void initializeMap(BufferedReader br,int N) throws IOException 
	{
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(input[j]);
				if(map[i][j]!=0)
				{	
					virusArray[map[i][j]].position.add(new Point(i,j,map[i][j],0));
					visited[i][j]=true;
				}
			}
		}
	}
	private static void initializeVirus(int K) 
	{
		virusArray=new Virus[K+1];		
		for(int i=1;i<K+1;i++)
			virusArray[i]= new Virus();
		
	}
}
