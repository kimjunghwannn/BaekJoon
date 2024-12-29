package algo;

import java.io.*;
import java.util.*;
public class back_2458 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		boolean visited[]=new boolean [N+1];
		int count=0;
		ArrayList<Integer> tallIndex[]=new ArrayList [N+1];
		ArrayList<Integer> shortIndex[]=new ArrayList [N+1];
		for(int i=1;i<=N;i++)
		{
			tallIndex[i]=new ArrayList<>();
			shortIndex[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++)
		{
			String input2[]=br.readLine().split(" ");
			int start=Integer.parseInt(input2[0]);
			int end=Integer.parseInt(input2[1]);
			
			tallIndex[start].add(end);
			shortIndex[end].add(start);
		}
		
		for(int i=1;i<=N;i++)
		{
			Arrays.fill(visited,false);
			
			Queue<Integer> queue=new LinkedList<>();
			
			visited[i]=true;
			queue.add(i);
			
			while(!queue.isEmpty())
			{
				int now=queue.poll();
				for(int a : tallIndex[now])
				{
					if(visited[a])
						continue;
					queue.add(a);
					visited[a]=true;
				}
			}
			queue.add(i);
			while(!queue.isEmpty())
			{
				int now=queue.poll();
				for(int a : shortIndex[now])
				{
					if(visited[a])
						continue;
					queue.add(a);
					visited[a]=true;
				}
			}
			if(isAllTrue(visited))
				count++;
		}
		System.out.println(count);
	}

	private static boolean isAllTrue(boolean[] visited) 
	{
		for(int j=1;j<visited.length;j++)
		{
			if(!visited[j])
				return false;
		}
		return true;
	}
}
