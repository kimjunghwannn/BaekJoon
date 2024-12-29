package algo;

import java.io.*;
import java.util.*;
public class back_2410 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long DP[]=new long [10000001];
		DP[1]=1;
		DP[2]=2;
		for(int i=3;i<=N;i++)
		{
			DP[i]=(DP[i-2]+DP[i/2])%1000000000;
		}
		System.out.println(DP[N]%1000000000);
	}
}
