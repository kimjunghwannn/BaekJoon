package algo;

import java.util.*;
import java.io.*;
public class back_15486 
{
	static public class WorkSchedule
	{
		public int startDate;
		public int endDate;
		public int wage;
		public WorkSchedule()
		{
			
		}
		public WorkSchedule(int startDate,int endDate,int wage)
		{
			this.startDate=startDate;
			this.endDate=endDate;
			this.wage=wage;
		}
	}
	static public void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int dp[]=new int[N+2];
		WorkSchedule baekSchedule[]=new WorkSchedule[N];
		
		for(int i=1;i<=N;i++)
		{
			String input[]=br.readLine().split(" ");
			int end=Integer.parseInt(input[0]);
			int wage=Integer.parseInt(input[1]);

			baekSchedule[i-1]=new WorkSchedule(i,end+i,wage);
		}
		int max=0;
		for(int i=0;i<N;i++)
		{
			max=Math.max(max,dp[i+1]);
			if(baekSchedule[i].endDate>N+1)
				continue;
			dp[baekSchedule[i].endDate]=Math.max(max+baekSchedule[i].wage,dp[baekSchedule[i].endDate]);
		}
		Arrays.sort(dp);
		System.out.println(dp[N+1]);
	}
}
