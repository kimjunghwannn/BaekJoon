package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_10819 {
	static int su_box[];
	static boolean visited[];
	static int n;
	static int max=0;
	public static void main(String args[]) throws NumberFormatException, IOException 
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(id.readLine());
		String box[]=id.readLine().split(" ");
		su_box=new int [n];
		for(int i=0;i<n;i++)
			su_box[i]=Integer.parseInt(box[i]);
		visited=new boolean [n];
		dfs(0,0,0);
		System.out.println(max);
	}
	private static void dfs(int gesu, int now, int sum) 
	{
		if(n==gesu) 
		{
			if(max<sum)
				max=sum;
			return;
		}
		for(int i=0;i<n;i++)
		{
			if(visited[i])
				continue;
			visited[i]=true;
			dfs(gesu+1,su_box[i],gesu==0?0:sum+Math.abs(now-su_box[i]));
			visited[i]=false;
		}
	}
}