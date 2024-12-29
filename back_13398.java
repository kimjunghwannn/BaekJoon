package algo;

import java.io.*;
import java.util.*;

public class back_13398 
{
	public static void main(String args[]) throws IOException 
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));	
		int n=Integer.parseInt(br.readLine());
		int intArray[]=new int [n];
		String input[]=br.readLine().split(" ");
		
		for(int i=0;i<input.length;i++)
			intArray[i]=Integer.parseInt(input[i]);
		int start=0;
		int end=intArray.length-1;
		int sum=0;
		int exclusionInt=0;
		int answer=0;
		while(intArray[end]<0&&end>0)
				end--;
		while(start<intArray.length&&intArray[start]<0)
				start++;
		if(end==0)
		{
			Arrays.sort(intArray);
			System.out.println(intArray[intArray.length-1]);
			System.exit(0);
		}
		while(start<=end)
		{
			if(sum==0&&intArray[start]<0)
			{	
				start++;
				continue;
			}
			if(intArray[start]>0)
				sum+=intArray[start];
			else
			{
				if(exclusionInt==0)
					exclusionInt=intArray[start];
				else
				{
					if(exclusionInt>intArray[start])
					{
						sum+=exclusionInt;
						exclusionInt=intArray[start];
					}
					else
						sum+=intArray[start];
					
				}
				
				if(exclusionInt<0&&sum<=0)
				{
					exclusionInt=0;
					sum=0;
				}
			}
			answer=Math.max(sum, answer);
			start++;
		}
		System.out.println(answer);
	}

}
