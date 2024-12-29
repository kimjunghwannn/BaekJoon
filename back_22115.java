package algo;

import java.io.*;
import java.util.*;
public class back_22115 
{
	static int dp[][];
	static int cafe[];
	static int K;
	static int result=Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		K=Integer.parseInt(input[1]);
		String input2[]=br.readLine().split(" ");
		cafe=new int [N+1];
		
		dp=new int [N+1][1000001];
		
		for(int i=1;i<=N;i++)
			cafe[i]=Integer.parseInt(input2[i-1]);
		for(int i=1;i<=K;i++)
			dp[0][i]=10000000;
		
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=K;j++)
			{
				if(cafe[i]<=j)
				{
					dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-cafe[i]]+1);
				}
				else
					dp[i][j]=dp[i-1][j];
				
			}
		}
		if(dp[N][K]==10000000)
			System.out.println(-1);
		else
			System.out.println(dp[N][K]);

			
	}
    

}
