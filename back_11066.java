package algo;

import java.io.*;
import java.util.*;
public class back_11066 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
			int K=Integer.parseInt(br.readLine());
			String input2[]=br.readLine().split(" ");
			int array[]=new int [K];
			int sum[]=new int [K+1];
			int dp[][]=new int [K+1][K+1];
			for(int i=0;i<K;i++)
				array[i]=Integer.parseInt(input2[i]);
			for(int i=1;i<=K;i++)
				sum[i]+=sum[i-1]+array[i-1];
			for(int d=1;d<K;d++)
			{
				for(int x=1;x+d<=K;x++)
				{
					int y=x+d;
					dp[x][y]=Integer.MAX_VALUE;
					for(int mid=x;mid<y;mid++)
					{
						dp[x][y]=Math.min(dp[x][y], dp[x][mid]+dp[mid+1][y]+sum[y]-sum[x-1]);
					}
				}
			}
			System.out.println(dp[1][K]);
		}
	}

}
