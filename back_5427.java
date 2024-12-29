package algo;

import java.io.*;
import java.util.*;
public class back_5427 
{
	static class Node
	{
		public int y;
		public int x;
		public int n;
		public Node(int y,int x,int n)
		{
			this.y=y;
			this.x=x;
			this.n=n;
		}
		
	}
	static class Fire
	{
		public int y;
		public int x;
	
		public Fire(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
		
	}
	static char map[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int answer=Integer.MAX_VALUE;
	static Queue<Fire> fire;
	static int time;
	static boolean fireVisited[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		while(testCase-->0)
		{
			String input[]=br.readLine().split(" ");
			int w=Integer.parseInt(input[0]);
			int h=Integer.parseInt(input[1]);
			map=new char [h][w];
			Node start = null;
			answer=Integer.MAX_VALUE;
			fire=new LinkedList<>();
			fireVisited = new boolean[h][w];
			time=0;
			for(int i=0;i<h;i++)
			{
				String inputLine=br.readLine();
				for(int j=0;j<w;j++)
				{
					map[i][j]=inputLine.charAt(j);
					if(map[i][j]=='@')
						start=new Node(i,j,0);
					if(map[i][j]=='*')
					{	
						fire.add(new Fire(i,j));
						fireVisited[i][j]=true;
					}
				}	
				
			}
			BFS(start);
			sb.append(answer==Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	private static void BFS(Node start) 
	{
		Queue<Node> queue=new LinkedList<>();
		queue.add(start);
		boolean visited[][]=new boolean [map.length][map[0].length];
		visited[start.y][start.x]=true;
		while(!queue.isEmpty())
		{
			Node now=queue.poll();
			if(now.n==time)
				fireDo();
			for(int i=0;i<4;i++)
			{
				int cy=now.y+dy[i];
				int cx=now.x+dx[i];
				
				if(cy<0||cy>=map.length||cx<0||cx>=map[0].length)
				{
					answer=now.n+1;
					return;
				}
				if(visited[cy][cx])
					continue;
				if(map[cy][cx]=='#')
					continue;
				if(checkFire(cy,cx))
					continue;
				
				queue.add(new Node(cy,cx,now.n+1));
				
			}
		}
	}
	static public void fireDo()
	{
		LinkedList<Fire> newFire=new LinkedList<>();
	
		for(Fire a : fire)
		{
			for(int i=0;i<4;i++)
			{
				int cy=a.y+dy[i];
				int cx=a.x+dx[i];
				
				if(cy<0||cy>=map.length||cx<0||cx>=map[0].length)
				{
					continue;
				}
				 if (map[cy][cx] == '#' || fireVisited[cy][cx])
	                    continue;
				if(checkFire(cy,cx))
					continue;
				fireVisited[cy][cx]=true;
				newFire.add(new Fire(cy,cx));
			}
		}
		for(Fire a: newFire)
			fire.add(a);
		time++;
		
	}
	static public boolean checkFire(int cy,int cx)
	{
		for(Fire a :fire)
		{			
			if(a.y==cy&&a.x==cx)
				return true;
		}
		return false;
	}
}
