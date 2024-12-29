package algo;

import java.io.*;
import java.util.*;
public class back_2228 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int num[]=new int [N+1];
		int DP[][]=new int [M+1][N+1];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++)
			num[i]=Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++)
		{
			
			DP[1][i]=num[i];
			if(DP[1][i-1]>0)
				DP[1][i]+=DP[1][i-1];
			for(int j=2;j<=M;j++)
			{
				if((i/2)+(i%2)<j)
					break;
				
			}
		}
	}
}
