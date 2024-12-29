package algo;

import java.io.*;
import java.util.*;
public class back_10986 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		long sum[]=new long [n+1];
		Map<Long,Long> map=new HashMap<>();
		Long count=0L;
		String input2[]=br.readLine().split(" ");
		for(int i=1;i<sum.length;i++)
			sum[i]=Integer.parseInt(input2[i-1])+sum[i-1];
		System.out.println(sum[1]);
		map.put(0L, 1L);
		for(int i=1;i<sum.length;i++)
		{
			count+=map.getOrDefault(sum[i]%m,0L);
			map.put(sum[i]%m, map.getOrDefault(sum[i]%m,0L)+1);
		}
		
		System.out.println(count);
	}
}
