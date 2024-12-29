package algo;

import java.io.*;
import java.util.*;
public class back_16724 
{
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int map[][];
	static int visited[][];
	static int index=0;
	static class Node
	{
		int y;
		int x;
		public Node(int y,int x)
		{
			this.x=x;
			this.y=y;
		}
	}
	static int answer=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		map = new int [N][M];
		visited = new int [N][M];
		Map<Character,Integer> direction=new HashMap<>();
		direction.put('U', 0);
		direction.put('D', 1);
		direction.put('L', 2);
		direction.put('R', 3);
		for(int i=0;i<N;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<input2.length();j++)
			{
				map[i][j]=direction.get(input2.charAt(j));
			}
		}
		for(int i=0;i<N;i++)
			Arrays.fill(visited[i], -1);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(visited[i][j]==-1)
				{	
					index++;
					answer++;
					bfs(i,j);
					
				}
			}
		}
		System.out.println(answer);
	}
	public static void bfs(int y,int x)
	{
		visited[y][x]=index;
		while(true)
		{
			int cy=y+dy[map[y][x]];
			int cx=x+dx[map[y][x]];
			if(visited[cy][cx]==index)
				break;
			if(visited[cy][cx]!=-1)
			{
				answer--;
				break;
			}
			visited[cy][cx]=index;
			y=cy;
			x=cx;
		}
	}

}
