package algo;

import java.util.*;
import java.io.*;
public class back_2230 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int sequence[]=new int [N];
		
		for(int i=0;i<N;i++)
			sequence[i]=Integer.parseInt(br.readLine());
		Arrays.sort(sequence);
		int start=0;
		int end=1;
		int answer=Integer.MAX_VALUE;
		while(start<N&&end<N)
		{
			if(sequence[end]-sequence[start]==M)
			{
				System.out.println(M);
				System.exit(0);
			}
			
		
			if((sequence[end]-sequence[start])>M)
			{	
				
				answer=Math.min(sequence[end]-sequence[start], answer);
				start++;
				continue;
			}
			
			if((sequence[end]-sequence[start])<M)
				end++;
		}
		System.out.println(answer);
	}

}
