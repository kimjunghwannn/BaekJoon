package algo;

import java.io.*;
import java.util.*;

public class back_32347 
{
	static int powerSource[];
	static int N;
	static int K;
	static public void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		K=Integer.parseInt(input[1]);
		String input2[]=br.readLine().split(" ");
		powerSource=new int [N];
		for(int i=0;i<N;i++)
			powerSource[i]=Integer.parseInt(input2[i]);
		
		int left=0;
		int right=200000;
		int answer=Integer.MAX_VALUE;
		while(left<=right)
		{
			int mid=(left+right)/2;
			
			if(canReturnOneDay(mid))
			{	
				right=mid-1;
				answer=Math.min(answer, mid);
			}
			else
				left=mid+1;
		}
		System.out.println(answer);
	}
	private static boolean canReturnOneDay(int T) 
	{
		boolean visited[]=new boolean [N];
		int nowDay=N-1;
		int usageCount=0;
		if(T+1>=N)
			return true;
		while(true)
		{
			if(nowDay<=0)
				return true;
			if(usageCount>=K)
				return false;
			if(visited[nowDay])
				return false;
			if(powerSource[nowDay]==1)
			{	
				
				visited[nowDay]=true;
				nowDay-=T;
				usageCount++;	
				
			}
			else
				nowDay++;
			
		}
		
	}
}
