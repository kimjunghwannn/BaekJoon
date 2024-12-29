package algo;

import java.io.*;
import java.util.*;
public class back_2253 
{
	static class Node implements Comparable<Node>
	{
		int n;
		int index;
		int speed;
		public Node(int n,int index,int speed)
		{
			this.n=n;
			this.index=index;
			this.speed=speed;
		}
		public int compareTo(Node other)
		{
			if(this.n==other.n)
				return Integer.compare(other.index, this.index);
			else
				return Integer.compare(this.n,other.n);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int dx[]= {-1,0,1};
		boolean visited[][]=new boolean [201][N+1];
		PriorityQueue<Node> queue=new PriorityQueue<>();
		for(int i=0;i<M;i++)
		{
			int block=Integer.parseInt(br.readLine());
			for(int j=0;j<201;j++)
				visited[j][block]=true;
		}
		queue.add(new Node(0,1,0));
		while(!queue.isEmpty())
		{
			Node now=queue.poll();
			for(int i=0;i<3;i++)
			{
				int newIndex=now.index+now.speed+dx[i];
				
				if(N<newIndex||now.speed+dx[i]<=0)
					continue;
				if(visited[now.speed+dx[i]][newIndex])
					continue;
				
				
				if(newIndex==N)
				{
					System.out.println(now.n+1);
					System.exit(0);
				}
				//System.out.println(newIndex+" "+(now.n+1));
				
				visited[now.speed+dx[i]][newIndex]=true;
				queue.add(new Node(now.n+1,newIndex,now.speed+dx[i]));
			}
		}
		System.out.println(-1);
	}
}
