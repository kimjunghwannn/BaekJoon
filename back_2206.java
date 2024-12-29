package algo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class back_2206 
{
	static class Node
	{
		public int y;
		public int x;
		public int n;
		public boolean useDrill;
		
		public Node(int y, int x,int n,boolean useDrill)
		{
			this.y=y;
			this.x=x;
			this.n=n;
			this.useDrill=useDrill;
		}
	}
	static int map[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int answer=Integer.MAX_VALUE;
	static boolean visited[][][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		map=new int [N][M];
		visited=new boolean [2][N][M];
		
		for(int i=0;i<N;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j]=input2.charAt(j)-'0';
			}
		}
		
		BFS();
		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer+1);
	}
	private static void BFS() 
	{	
		Queue<Node> queue=new LinkedList<>();	
		queue.add(new Node(0,0,0,false));
		
		while(!queue.isEmpty())
		{
			Node now=queue.poll();
			if(now.y==map.length-1&&now.x==map[0].length-1)
			{
				answer=Math.min(answer, now.n);
				continue;
			}
			for(int i=0;i<4;i++)
			{
				int cy=now.y+dy[i];
				int cx=now.x+dx[i];
				if(cy<0||cy>=map.length||cx<0||cx>=map[0].length)
					continue;
				if(visited[now.useDrill==true ? 1 :0][cy][cx])
					continue;
				if(map[cy][cx]==1)
				{
					if(now.useDrill)
						continue;
					else
					{
						queue.add(new Node(cy,cx,now.n+1,true));
						visited[1][cy][cx]=true;
						continue;
					}
				}
				
				visited[now.useDrill==true ? 1 :0][cy][cx]=true;
				queue.add(new Node(cy,cx,now.n+1,now.useDrill));
			}
		}
	}

}
