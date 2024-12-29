package algo;

import java.io.*;
import java.util.*;
public class back_2225 
{
	static long DP[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		DP=new long [201][201];
		
		Arrays.fill(DP[1], 1);
		
			makeN(K,N);
		
	
		System.out.println(DP[K][N]%1000000000);
	}
	private static long makeN( int i,int n) 
	{
		if(i==1)
			return 1;
		if(DP[i][n]!=0)
			return DP[i][n];
		for(int j=0;j<=n;j++)
		{
			DP[i][n]+=(makeN(i-1,n-j))%1000000000;
		}
	
		return DP[i][n];
	}

}
