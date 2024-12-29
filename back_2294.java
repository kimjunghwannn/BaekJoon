package algo;

import java.util.*;
import java.io.*;
public class back_2294 {
	static Integer coinArray[];
	static int DP[]=new int [10001];
	static int K;
	static final int Max_Value=100000000;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		
		K=Integer.parseInt(input[1]);
		coinArray=new Integer [n];
		
		for(int i=0;i<n;i++)
			coinArray[i]=Integer.parseInt(br.readLine());
		Arrays.fill(DP,-1);
		findCoinsForK(0,0);
	if(DP[0]!=Max_Value)
		System.out.println(DP[0]);
	else
		System.out.println(-1);
	}
	private static int findCoinsForK(int sum,int n) 
	{
		if(sum>K)
			return Max_Value;
		if(DP[sum]!=-1)
			return DP[sum];
		if(sum==K)
			return 0;
	
		DP[sum] = Max_Value;
	
		for(int i=0;i<coinArray.length;i++)
			DP[sum]=Math.min(DP[sum], findCoinsForK(sum+coinArray[i],n+1)+1);
		return DP[sum];
	}
}
