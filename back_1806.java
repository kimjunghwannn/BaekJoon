package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class back_1806 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String []input2=id.readLine().split(" ");
		int N=Integer.parseInt(input2[0]);
		int targetNumber=Integer.parseInt(input2[1]);
		String []input=id.readLine().split(" ");
		long sum=0;
		int table[]=new int [N];
		for(int i=0;i<N;i++)
		{    
			table[i]=Integer.parseInt(input[i]);
			sum+=table[i];
		}
		int start=0;
		int end=0;
		if(sum<targetNumber)
		{
			System.out.println(0);
			System.exit(0);
		}
		sum=0;
		int length=0;
		int answer=100000;
		while(end<=N&&start<N)
		{
			if(end==N)
			{
				if(sum<targetNumber)
					break;
			}
			if(sum<targetNumber)
			{	
				sum+=table[end++];
				length++;
			}
			else
			{
				answer=Math.min(answer, length);
				sum-=table[start++];
				length--;
			}
			
		}
		System.out.println(answer);
	
	}
}
