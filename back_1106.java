package algo;

import java.io.*;
import java.util.*;
public class back_1106 
{
	static class City
	{
		public int value;
		public int n;
		
		public City(int value,int n)
		{
			this.value=value;
			this.n=n;
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int C=Integer.parseInt(input[0]);
		int N=Integer.parseInt(input[1]);
		int DP[]=new int [1101];
		City cityArray[]=new City[N];
		for(int i=0;i<N;i++)
		{
			String input2[]=br.readLine().split(" ");
			int value=Integer.parseInt(input2[0]);
			int n=Integer.parseInt(input2[1]);
			cityArray[i]=new City(value,n);
		}
		Arrays.fill(DP, 10000000);
		DP[0]=0;
		for(int i=0;i<N;i++)
		{
			for(int j=1;j<=1100;j++)
			{
				if(cityArray[i].n<=j)
				{
					DP[j]=Math.min(DP[j], DP[j-cityArray[i].n]+cityArray[i].value);
				}
			}
		}
		int answer=Integer.MAX_VALUE;
		for(int i=C;i<DP.length;i++)
			answer=Math.min(answer, DP[i]);
		System.out.println(answer);
	}

}
