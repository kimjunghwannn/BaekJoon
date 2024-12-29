package algo;

import java.io.*;
import java.util.*;
public class back_2281 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int dp[][]=new int [N+1][N+1];
		int nameArray[]=new int [N+1];
		for(int i=1;i<=N;i++)
			nameArray[i]=Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[0][0]=0;
		for(int i=1;i<=N;i++)
		{
			for(int j=i;j<=N;j++)
			{
				if(j==i)
					dp[i][j]=(M-nameArray[i])*(M-nameArray[i])+dp[i-1][j-1];
				else
				{
					int minLine=dp[i-1][j-1]+(M-nameArray[j])*(M-nameArray[j]);
					int maxLine=dp[i][j-1]+(M-nameArray[j])*(M-nameArray[j]);
					if(Math.sqrt(dp[i][j-1]-dp[i-1][j-2])-1>nameArray[j])
						maxLine=Integer.MAX_VALUE;
					
					
				}
			}
		}
	}
}
