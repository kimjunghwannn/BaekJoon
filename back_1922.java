package algo;
import java.io.*;
import java.util.*;
public class back_1922 {
	static class Edge implements Comparable<Edge>
	{
		public int w;
		public int cost;
		
		public Edge(int w,int cost)
		{
			this.w=w;
			this.cost=cost;
		}
		
		public int compareTo(Edge a2)
		{
			return this.cost - a2.cost;
		}
	}
	static LinkedList<Edge> edges[];
	static int total=0;
	static int N;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		edges=new LinkedList [N+1];
		for(int i=1;i<=N;i++)
			edges[i]=new LinkedList<>();
		for(int i=0;i<M;i++)
		{
			String input[]=br.readLine().split(" ");
			int start=Integer.parseInt(input[0]);
			int end=Integer.parseInt(input[1]);
			int cost=Integer.parseInt(input[2]);
			
			edges[start].add(new Edge(end,cost));
			edges[end].add(new Edge(start,cost));
		}
		
		prim();
		System.out.println(total);
	}
	private static void prim() 
	{
		boolean visited[]=new boolean [N+1];
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		pq.add(new Edge(1,0));
		while(!pq.isEmpty())
		{
			Edge now =pq.poll();
			
			if(visited[now.w])
				continue;
			
			visited[now.w]=true;
			total+=now.cost;
			
			for(Edge a :edges[now.w])
			{
				if(!visited[a.w])
					pq.add(a);
			}
		}
	}
}
