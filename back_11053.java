package algo;

import java.util.*;
import java.io.*;


public class back_11053 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		String input[]=id.readLine().split(" ");
		int numArray[]=new int [N];
		for(int i=0;i<N;i++)
			numArray[i]=Integer.parseInt(input[i]);
		int DP[]=new int [N];
		Arrays.fill(DP, 1);
		int max=0;
		for(int i=1;i<N;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(numArray[i]>numArray[j])
				{	
					DP[i]=Math.max(DP[i], DP[j]+1);
					max=Math.max(max,DP[i]);
				}
			}
		}
		System.out.print(max);
	}
}
