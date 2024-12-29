package algo;

import java.io.*;
import java.util.*;
public class back_2343 
{
	static int courseLength[];
	static int M;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		String input2[]=br.readLine().split(" ");
		courseLength=new int [N];
		int start=0;
		int end=0;
		int answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{	
			courseLength[i]=Integer.parseInt(input2[i]);
			end+=courseLength[i];
		}
		while(start<=end)
		{
			int middle=(end+start)/2;
			if(setValue(middle))
			{
				answer=Math.min(answer, middle);
				end=middle-1;
			}
			else
				start=middle+1;
		}
		System.out.println(answer);
	}
	private static boolean setValue(int value) {
		int sum=0;
		LinkedList<Integer> totalMinute=new LinkedList<>();
		for(int i=0;i<courseLength.length;i++)
		{
			if(courseLength[i]>value)
				return false;
		}
		for(int i=0;i<courseLength.length;i++)
		{
			sum+=courseLength[i];
			if(sum>value)
			{	
				totalMinute.add(sum-courseLength[i]);
				sum=courseLength[i];
			}
		}
		totalMinute.add(sum);
		if(totalMinute.size()>M)
			return false;
		else
			return true;
	}

}
