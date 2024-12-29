package algo;

import java.io.*;
import java.util.*;
public class back_11559 
{
	static class Node
	{
		int y;
		int x;
		public Node(int y, int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static char map[][];
	static boolean visited[][];
	static ArrayList<Node> deleteList;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int answer=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		map=new char [12][6];
		for(int i=0;i<12;i++)
		{
			String input=br.readLine();
			for(int j=0;j<6;j++)
			{
				map[i][j]=input.charAt(j);
			}
		}
		
		while(true)
		{
			visited=new boolean [12][6];
			deleteList=new ArrayList<>();
			for(int i=0;i<12;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(map[i][j]!='.'&&!visited[i][j])
					{
						bfs(i,j,map[i][j]);
					}
				}
			}
			//System.out.println(deleteList.size());
			if(deleteList.isEmpty())
				break;
			for(Node a: deleteList)
			{
				map[a.y][a.x]='.';
			}
			for(int i=10;i>=0;i--)
			{
				for(int j=0;j<6;j++)
				{
					if(map[i][j]!='.')
					{
						drop(i,j,map[i][j]);
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
	private static void drop(int y, int x,char value) 
	{
		while(true)
		{
			if(y>=11)
				break;
			if(map[y+1][x]!='.')
				break;
			map[y][x]='.';
			map[++y][x]=value;	
		}
	}
	private static void bfs(int y, int x,int value) 
	{
		Queue<Node> queue=new LinkedList<>();
		queue.add(new Node(y,x));
		int count=1;
		ArrayList<Node>  temporaryDeleteList=new ArrayList<>();
		visited[y][x]=true;
		temporaryDeleteList.add(new Node(y,x));
		while(!queue.isEmpty())
		{
			Node now=queue.poll();
			for(int i=0;i<4;i++)
			{
				int cx=now.x+dx[i];
				int cy=now.y+dy[i];
				if(cx<0||cx>=6||cy<0||cy>=12)
					continue;
				if(visited[cy][cx]||map[cy][cx]!=value)
					continue;
				count++;
				visited[cy][cx]=true;
				Node newNode=new Node(cy,cx);
				queue.add(newNode);
				temporaryDeleteList.add(newNode);
				
			}
		}
		if(count>3)
		{
			for(Node a:temporaryDeleteList)
			{
				deleteList.add(a);
			}
		}
	}
}
