package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2467 
{
	static long solutionArray[];
	static long solutionA=0;
	static long solutionB=0;
	static long answer=Long.MAX_VALUE;
	public static void main(String args[]) throws NumberFormatException, IOException 
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		String solutionInput[]=id.readLine().split(" ");
		solutionArray=new long [N];
		
		for(int i=0;i<N;i++)
			solutionArray[i]=Long.parseLong(solutionInput[i]);
		Arrays.sort(solutionArray);
		for(int i=0;i<N;i++)
			findClosestToZero(i);
		System.out.println(solutionA+" "+solutionB);
	}

	private static void findClosestToZero(int solutionIndex) 
	{
			int start=0;
			int end=solutionArray.length-1;
			while(start<=end)
			{
				int middle=(start+end)/2;
				if(solutionArray[middle]+solutionArray[solutionIndex]>0)
				{
					end=middle-1;
				}
				else
				{
					start=middle+1;
				}
				
				if(solutionIndex==middle)
					continue;
				
				
				if(Math.abs(solutionArray[middle]+solutionArray[solutionIndex])<Math.abs(answer))
				{
					answer=solutionArray[middle]+solutionArray[solutionIndex];
					if(solutionArray[solutionIndex]<solutionArray[middle])
					{	
						solutionA=solutionArray[solutionIndex];
						solutionB=solutionArray[middle];
					}
					else
					{
						solutionA=solutionArray[middle];
						solutionB=solutionArray[solutionIndex];
					}
				}
			}
	}
}