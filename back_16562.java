package algo;


import java.io.*;
import java.util.*;
public class back_16562 
{
	static class Friend implements Comparable<Friend>
	{
		int n;
		int money;
		public Friend(int n,int money)
		{
			this.n=n;
			this.money=money;
		}
		public int compareTo(Friend other)
		{
			return Integer.compare(this.money, other.money);
		}
	}
	
	static int unionFind[];
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int K=Integer.parseInt(input[2]);
		unionFind=new int [N];
		boolean visited[]=new boolean [N];
		PriorityQueue<Friend> queue=new PriorityQueue<>();

		String input2[]=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{	
			int money=Integer.parseInt(input2[i]);
			queue.add(new Friend(i,money));
			unionFind[i]=i;
		}
		for(int i=0;i<M;i++)
		{
			String input3[]=br.readLine().split(" ");
			int start=Integer.parseInt(input3[0])-1;
			int end=Integer.parseInt(input3[1])-1;
			if(start>end)
			{
				int tmp=start;
				start=end;
				end=tmp;
			}
			union(start,end);
		}
		
		int usedMoney=0;
		while(!queue.isEmpty())
		{
			
			if(isAllVisited(visited))
			{
				System.out.println(usedMoney);
				System.exit(0);
			}
			if(usedMoney>K)
			{
				System.out.println("Oh no");
				System.exit(0);
			}
			Friend now=queue.poll();
			if(visited[find(now.n)])
			{	
				visited[now.n]=true;
				continue;
			}
			visited[find(now.n)]=true;
			visited[now.n]=true;
			usedMoney+=now.money;
		}
		if(isAllVisited(visited))
			System.out.println(usedMoney);
		else
			System.out.println("Oh no");
		
	}
	private static boolean isAllVisited(boolean[] visited) {
		for(int i=0;i<visited.length;i++)
			if(!visited[i])
				return false;
		return true;
	}
	private static void union(int start, int end) 
	{
		start=find(start);
		end=find(end);
		
		if(start==end)
			return;
		if(end>start)
			unionFind[end]=start;
		else 
			unionFind[start]=end;

	}
	private static int find(int index) 
	{
		if(index==unionFind[index]) return index;
		else return find(unionFind[index]);
	}
}
