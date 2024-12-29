package algo;

import java.util.*;
import java.io.*;
public class back_3020 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int H=Integer.parseInt(input[1]);
		
		int blocker[][]=new int [2][500001];
		
		for(int i=0;i<N;i++)
		{
			String inputBlocker=br.readLine();
			blocker[i%2][Integer.parseInt(inputBlocker)]++;
		}
		int sum=0;
		int answer=Integer.MAX_VALUE;
		for(int i=H;i>=1;i--)
		{
			blocker[1][i-1]+=blocker[1][i];
		}
		for(int i=H;i>=1;i--)
		{
			blocker[0][i-1]+=blocker[0][i];
		}
		int count=0;
		for(int i=1;i<=H;i++)
		{
			sum=blocker[0][i]+blocker[1][H-i+1];
			if(answer>sum)
			{
				answer=sum;
				count=1;
			}
			else if(answer==sum)
				count++;
		}
		System.out.println(answer+" "+count);
	}

}
