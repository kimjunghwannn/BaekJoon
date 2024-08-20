package algo;

import java.util.*;
import java.io.*;
public class back_1011 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader id = new BufferedReader (new InputStreamReader(System.in));
		int testCase=Integer.parseInt(id.readLine());
		
		while(testCase-->0)
		{
			String input[]=id.readLine().split(" ");
			int start=Integer.parseInt(input[0]);
			int end=Integer.parseInt(input[1]);
			long distance=end-start;
			long answer=1;
			int up=1;
			long sum=1;
			if(distance<=3)
			{
				System.out.println(distance);
				continue;
			}
			while(true)
			{
				if(distance-(sum+up+1)<(sum+up+1)-(up+1))
					 break;
				up++;
				sum+=up;
				answer++;
			}
			distance-=sum+(sum-up);
			answer+=answer-1;
			if(distance==0)
			{
				System.out.println(answer);
				
			}
			else
			{
				while(true)
				{
					answer+=distance/up;
					distance%=up;
					up--;
					if(distance==0)
						break;
				}
				System.out.println(answer);
			}
		}
	}
}
