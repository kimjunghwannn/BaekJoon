package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class back_1931 {
	static boolean visited[];
	static int times[][];
	static int high=0;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int i;
		times= new int [n][2];
		
		int now=0;
		for(i=0;i<n;i++)
		{
		
			String[] input=id.readLine().split(" ");
			times[i][0]=Integer.parseInt(input[0]);
			times[i][1]=Integer.parseInt(input[1]);
		}
		Arrays.sort(times, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		visited=new boolean [times[n-1][1]+1];		
		for(i=0;i<n;i++)
		{
			Dfs(i,times[i][1],1);
		}
		System.out.print(high);
	}
	private static void Dfs(int index, int now, int n) {
		if(visited.length-1==n)
		{
			high=Math.max(n,high);
		}
		for(int i=index+1;i<times.length;i++)
		{
			if(now>times[i][0])
				continue;
			if(visited[times[i][1]])
				continue;
			visited[times[i][1]]=true;
			Dfs(i,times[i][1],n+1);
		}
		high=Math.max(n, high);
	}
}
