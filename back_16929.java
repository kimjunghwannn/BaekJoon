package algo;

import java.io.*;
import java.util.*;
public class back_16929 
{
	static class Node
	{
		public int y;
		public int x;
		public Node(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static int map[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int firstX;
	static int firstY;
	static boolean visited[][];
	static int N;
	static int M;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		map=new int [N][M];
		visited=new boolean [N][M];
		for(int i=0;i<N;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j]=input2.charAt(j)-65;
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				
				visited=new boolean [N][M];
				firstY=i;
				firstX=j;
				//visited[i][j]=true;
				dfs(i,j,0);
			}
		}
		System.out.println("No");
	}
	private static void dfs(int y, int x, int count) 
	{
		
		for(int i=0;i<4;i++)
		{
			int cy=y+dy[i];
			int cx=x+dx[i];
			if(cy==firstY&&cx==firstX&&count>=3)
			{
				System.out.println("Yes");
				System.exit(0);
			}
			if(cy>=0&&cy<N&&cx>=0&&cx<M&&map[cy][cx]==map[firstY][firstX])
			{
				if(visited[cy][cx])
					continue;
				else
				{
					visited[cy][cx]=true;
					dfs(cy,cx,count+1);
				}
			}
		}
		
	}
}
