package algo;


import java.util.*;
import java.io.*;
public class back_2293 
{
	static int coinArray[];
	static int DP[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int k=Integer.parseInt(input[1]);
		coinArray=new int [n];
		DP=new int [k+1];
		
		
		DP[0]=1;
		for(int i=0;i<n;i++)
			coinArray[i]=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++)
		{
			for(int j=coinArray[i];j<=k;j++)
			{
				DP[j]+=DP[j-coinArray[i]];
			}
		}
		System.out.println(DP[k]);
		
	}
	
}
