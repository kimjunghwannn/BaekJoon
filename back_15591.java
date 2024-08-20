package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class back_15591 {
	static class road {
		private int end;
		private int weight;
		road(int end,int weight){
			this.end=end;
			this.weight=weight;
		}
		public int get_end() {
			return this.end;
		}
		public int get_weight() {
			return this.weight;
		}
	}
	static boolean visited[];
	static LinkedList<road> a[]; 
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int q=Integer.parseInt(input[1]);
		a=new LinkedList[n+1];
		int i;
		visited=new boolean [n+1];
		for(i=1;i<=n;i++)
			a[i]=new LinkedList<>();
		for(i=0;i<n-1;i++)
		{
			
			String input2[]=id.readLine().split(" "); 
			a[Integer.parseInt(input2[0])].add(new road( Integer.parseInt(input2[1]),Integer.parseInt(input2[2]) ));
			a[Integer.parseInt(input2[1])].add(new road( Integer.parseInt(input2[0]),Integer.parseInt(input2[2]) ));
		}
		for(i=0;i<q;i++)
		{
			input=id.readLine().split(" ");
			do_bfs(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			Arrays.fill(visited, false);
		}
	}
	private static void do_bfs(int limit, int start) {
		Queue<Integer> q=new LinkedList<>();
		visited[start]=true;
		q.add(start);
		int count=0;
		while(!q.isEmpty()) {
			int nowstart=q.poll();
			for(road edge: a[nowstart])
			{
				int nextstart=edge.get_end();
				int nextweight=edge.get_weight();
				if(visited[nextstart]==true)
					continue;
				visited[nextstart]=true;
				if(nextweight>=limit)
				{
					count++;
					q.add(nextstart);
				}
				
			}
		}
		System.out.println(count);
	}
}
