package algo;

import java.io.*;
import java.util.*;
public class back_1976 {
	static LinkedList<Integer> root[];
	static boolean DP[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		int planCityN=Integer.parseInt(id.readLine());
		root=new LinkedList [N+1];
		for(int i=1;i<=N;i++)
			root[i]=new LinkedList<>();
		for(int i=1;i<=N;i++)
		{
			String input[]=id.readLine().split(" ");
			for(int j=1;j<=N;j++)
			{	
				if(input[j-1].equals("1"))
				{	
					root[i].add(j);
				}
			}
		}
		String planCities[]=id.readLine().split(" ");
		boolean visited[]=new boolean [N+1];
		int start=Integer.parseInt(planCities[0]);
		Map<Integer,Boolean> visitedCities=new HashMap<>();
		visitedCities.put(start,true);
		visited[start]=true;
		Queue<Integer> queue=new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty())
		{
			int now=queue.poll();
			for(int a: root[now])
			{
				if(visited[a]==true)
					continue;
				visitedCities.put(a, true);
				visited[a]=true;
				queue.add(a);
			}
		}
		for(int i=1;i<planCities.length;i++)
		{
			int now=Integer.parseInt(planCities[i]);
			if(visitedCities.get(now)==null)
			{
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	
}
