package algo;

import java.io.*;
import java.util.*;
public class back_1722 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long k;
		String input[]=br.readLine().split(" ");
		ArrayList<Integer> intArray=new ArrayList<>();
		if(Integer.parseInt(input[0])==1)
		{
			k=Long.parseLong(input[1]);
			long DP[]=new long [21];
			DP[1]=1;
			for(int i=2;i<=20;i++)
			{	
				DP[i]=DP[i-1]*i;
			}
			int digitCount=0;
			for(int i=1;i<=20;i++)
			{
				if(k<=DP[i])
					digitCount=i;
			}
			while(true)
			{
				
			}
		}
		else
		{
			for(int i=1;i<input.length;i++)
			{
				intArray.add(Integer.parseInt(input[i]));
			}
		}
	}
		
		
}


