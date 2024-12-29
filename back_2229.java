package algo;

import java.io.*;
import java.util.*;
public class back_2229 
{
	static int map[];
	static int max=0;
	static int dp[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		map=new int [N+1];
		dp=new int [N+1];
		String input2[]=br.readLine().split(" ");
		for(int i=1;i<=N;i++)
			map[i]=Integer.parseInt(input2[i-1]);
		for(int i=1;i<=N;i++)
		{
			int max=0;
			int min=Integer.MAX_VALUE;
			for(int j=i;j>0;j--)
			{
				min=Math.min(map[j],min);
				max=Math.max(map[j], max);
				dp[i]=Math.max(dp[i],dp[j-1]+(max-min));
			}
		}
		System.out.println(dp[N]);
	}
	
}
