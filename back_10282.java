package algo;

import java.io.*;
import java.util.*;
public class back_10282 
{
	static class Node implements Comparable<Node>
	{
		int index;
		int n;
		public Node(int index,int n)
		{
			this.index=index;
			this.n=n;
		}
		public int compareTo(Node other)
		{
			return Integer.compare(this.n, other.n);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
			String input[]=br.readLine().split(" ");
			int n=Integer.parseInt(input[0]);
			int d=Integer.parseInt(input[1]);
			int startCom=Integer.parseInt(input[2]);
			
			int distance[]=new int [n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			ArrayList<Node> list[]=new ArrayList [n+1];
			for(int i=0;i<n+1;i++)
				list[i]=new ArrayList<>();
			for(int i=0;i<d;i++)
			{
				String input2[]=br.readLine().split(" ");
				int end=Integer.parseInt(input2[0]);
				int start=Integer.parseInt(input2[1]);
				int time=Integer.parseInt(input2[2]);
				list[start].add(new Node(end,time));
			}
			PriorityQueue<Node> queue=new PriorityQueue<>();
			queue.add(new Node(startCom,0));
			while(!queue.isEmpty())
			{
				Node now=queue.poll();
				
				if(distance[now.index]<=now.n)
					continue;
				distance[now.index]=now.n;
				for(Node a : list[now.index])
				{
					a.n+=now.n;
					queue.add(a);
				}
					
			}
			Arrays.sort(distance);
			for(int i=0;i<distance.length;i++)
			{
				if(distance[i]==Integer.MAX_VALUE)
				{
					System.out.println(i+" "+distance[i-1]);
					break;
				}
			}
		}
	}
}
