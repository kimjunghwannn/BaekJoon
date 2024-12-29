package algo;

import java.util.*;
import java.io.*;
public class back_10844 
{
	static long DP[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		DP=new long [10][N+1];
		long sum=0;
		if(N==1)
		{
			System.out.println(9);
			System.exit(0);
		}
		for(int i=1;i<=9;i++)
			sum+=doDP(i,N-1)% 1000000000;
		System.out.println(sum%1000000000);
	}
	static long doDP(int now,int remainingLength)
	{
		if(remainingLength==0)
			return 1;
		if(DP[now][remainingLength]!=0)
			return DP[now][remainingLength];
		if(now==0)
		{
			DP[now][remainingLength]+= doDP(now+1,remainingLength-1)% 1000000000;
			return DP[now][remainingLength];
		}
		else if(now==9)
		{
			DP[now][remainingLength]+= doDP(now-1,remainingLength-1)% 1000000000;
			return DP[now][remainingLength];
		}
		else
		{
			DP[now][remainingLength]+= doDP(now+1,remainingLength-1)% 1000000000;
			DP[now][remainingLength]+= doDP(now-1,remainingLength-1)% 1000000000;
			return DP[now][remainingLength];
		}
	}
}
