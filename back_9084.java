package algo;

import java.io.*;
import java.util.*;
public class back_9084 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		while(T-->0)
		{
			int N=Integer.parseInt(br.readLine());
			String input[]=br.readLine().split(" ");
			int coins[]=new int [N];
			for(int i=0;i<N;i++)
				coins[i]=Integer.parseInt(input[i]);
			int M=Integer.parseInt(br.readLine());
			int dp[]=new int [M+1];
			dp[0]=1;
			for(int i=0;i<N;i++)
			{
				for(int j=coins[i];j<=M;j++)
				{
					dp[j]+=dp[j-coins[i]];
				}
			}
			System.out.println(dp[M]);
		}
	}

}
