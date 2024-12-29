package algo;

import java.util.*;
import java.io.*;
public class back_11054 
{
	static int DP[];
	static int answer;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int numbers[]=new int [N+1];
		String input[]=br.readLine().split(" ");
		DP=new int [N+1];
		answer=0;
		int RDP[]=new int [N+1];
		
		for(int i=1;i<=N;i++)
			numbers[i]=Integer.parseInt(input[i-1]);
		Arrays.fill(DP, 1);
		Arrays.fill(RDP, 1);
		
		for(int i=2;i<=N;i++)
		{
			for(int j=i-1;j>=1;j--)
			{
				if(numbers[i]>numbers[j])
				{
					DP[i]=Math.max(DP[i],DP[j]+1);
				}
			}
		}
		for(int i=N-1;i>=1;i--)
		{
			for(int j=i+1;j<=N;j++)
			{
				if(numbers[i]>numbers[j])
				{
					RDP[i]=Math.max(RDP[i],RDP[j]+1);
				}
			}
		}
		for(int i=1;i<=N;i++)
			answer=Math.max(answer, DP[i]+RDP[i]);
		
		System.out.println(answer-1);
	}
	
}
