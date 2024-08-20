package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class back_2668 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		LinkedList<Integer> road[]=new LinkedList[n+1];
		boolean visited[]=new boolean [n+1];
		ArrayList<Integer> answer=new ArrayList<>(); 
		for(int i=1;i<=n;i++)
		{
			road[i]=new LinkedList<>();
			road[i].add(Integer.parseInt(id.readLine()));
		}
		for(int i=1;i<=n;i++)
		{
			Queue<Integer> queue=new LinkedList<>();
			if(visited[i])
				continue;
			queue.add(i);
			boolean Dfs_visited[]=new boolean[n+1];Dfs_visited[i]=true;
			while(!queue.isEmpty())
			{
				int now=queue.poll();
				
				if(road[now].getFirst()==i)
				{
					for(int j=1;j<=n;j++)
					{
						if(Dfs_visited[j])
						{	
							answer.add(j);
							visited[j]=true;
						}
						
					}
					break;
				}
				if(Dfs_visited[road[now].getFirst()])
					break;
				Dfs_visited[road[now].getFirst()]=true;
				queue.add(road[now].getFirst());
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int a: answer)
			System.out.println(a);		
	}
}
