package algo;


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class back_6198 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int buildingArray[]=new int [N];
		int ans[]=new int [N];
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for(int i=0;i<N;i++)
			buildingArray[i]=Integer.parseInt(br.readLine());
		for(int i=N-1;i>=0;i--)
		{
			while(!queue.isEmpty()&&buildingArray[queue.peek()]<buildingArray[i])
			{
				int idx=queue.poll();
				ans[i]+=ans[idx]+1;
			}
			queue.add(i);
		}
		long answer=0;
		for(int i=0;i<N;i++)
			answer+=ans[i];
		System.out.println(answer);
	}
}
