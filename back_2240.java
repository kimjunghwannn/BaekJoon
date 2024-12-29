package algo;

import java.io.*;
import java.util.*;
public class back_2240 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int t=Integer.parseInt(input[0]);
		int w=Integer.parseInt(input[1]);
		int plums[]=new int [t+1];
		int dp[][]=new int [t+1][w+1];
		int answer=0;
		for(int i=1;i<=t;i++)
		{
			plums[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=t;i++)
		{
			if(plums[i]==1)
				dp[i][0]=dp[i-1][0]+1;
			else
				dp[i][0]=dp[i-1][0];
			answer=Math.max(answer, dp[i][0]);
			for(int j=1;j<=w;j++)
			{
				if(j>i)
					break;
				if(plums[i]==1&&j%2==0)
				{
					dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+1;
				}
				else if(plums[i]==2&&j%2==1)
				{
					dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+1;
				}
				else
					dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j]);
				answer=Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}
}
