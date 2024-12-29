package algo;

import java.io.*;
import java.util.*;
public class back_1261 
{
	static class Node implements Comparable<Node>
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
		
		public int compareTo(Node n1)
		{
			return Integer.compare(this.n, n1.n);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int map[][]=new int [M][N];
		int dx[]= {0,0,1,-1};
		int dy[]= {1,-1,0,0};
		boolean visited[][]=new boolean [M][N];
		
		for(int i=0;i<M;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<input2.length();j++)
			{
				map[i][j]=input2.charAt(j)-'0';
			}
		}
		if(M==1&&N==1)
		{
			System.out.println(0);
			System.exit(0);
		}
		PriorityQueue<Node> queue= new PriorityQueue<>();
		
		queue.add(new Node(0,0,0));
		visited[0][0]=true;
		while(!queue.isEmpty())
		{
			Node nowNode=queue.poll();
			
			for(int i=0;i<4;i++)
			{
				int cy=nowNode.y+dy[i];
				int cx=nowNode.x+dx[i];
				int nowNodeN=nowNode.n;
				if(cy<0||cy>=M||cx<0||cx>=N)
					continue;
				if(map[cy][cx]==1)
					nowNodeN++;
				if(visited[cy][cx])
					continue;
				if(cy==M-1&&cx==N-1)
				{
					System.out.println(nowNodeN);
					System.exit(0);
				}
				visited[cy][cx]=true;
				queue.add(new Node(cy,cx,nowNodeN));
			}
		}
	}

}
