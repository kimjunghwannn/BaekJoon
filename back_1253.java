package algo;

import java.io.*;
import java.util.Arrays;

public class back_1253 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		String []input=id.readLine().split(" ");
		long table[]=new long [N];
		for(int i=0;i<N;i++)
		{
		    table[i]=Long.parseLong(input[i]);
		}
		Arrays.sort(table);int count=0;
		for(int i=0;i<N;i++)
		{
			long targetNumber=table[i];
			int startIndex=0;
			int endIndex=N-1;
			while(startIndex<endIndex)
			if(table[startIndex]+table[endIndex]==targetNumber)
			{
				if(startIndex==i)
					startIndex++;
				else if(endIndex==i)
					endIndex--;
				else {
				count++;
				break;}
				
			}
			else if(table[startIndex]+table[endIndex]>targetNumber)
				endIndex--;
			else
				startIndex++;
		}
		
	
		System.out.println(count);
	}
}
