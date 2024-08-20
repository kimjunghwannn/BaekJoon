package algo;

import java.io.*;
import java.util.*;
public class back_159891_2 {
	static int DP[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int testCase=Integer.parseInt(id.readLine());
		while(testCase-->0)
		{
			int N=Integer.parseInt(id.readLine());
			DP=new int[N+1];
			System.out.println(find(0,N));
		}
	}
	static int find(int now,int target)
	{
		if(target<0)
			return 0;
		if(target==0)
		{	
			return 1;
		}
		if(DP[target]!=0&&now==1)
			return DP[target];
		int ret=0;
		for(int i=now;i<=3;i++)
		{
			if(i==0)
				continue;
			ret+=find(i,target-i);
		}
		DP[target]+=ret;
		return ret;
		
	}
}
