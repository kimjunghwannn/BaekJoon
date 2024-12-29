package algo;

import java.io.*;
import java.util.*;
public class back_1461 
{
	static int sum;
	static int M;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		int bookPosition[]=new int [N];
		String input2[]=br.readLine().split(" ");
		boolean isNegativeHigher=true;
		PriorityQueue<Integer> nQueue =new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pQueue =new PriorityQueue<>();
		int maxABS=0;
		sum=0;
		for(int i=0;i<N;i++)
		{	
			bookPosition[i]=Integer.parseInt(input2[i]);
			if(bookPosition[i]>0)
				pQueue.add(bookPosition[i]);
			else if(bookPosition[i]==0)
				continue;
			else
				nQueue.add(bookPosition[i]);
			
			if(maxABS<Math.abs(bookPosition[i]))
			{
				maxABS=Math.abs(bookPosition[i]);
				if(bookPosition[i]>0)
					isNegativeHigher=false;
				else
					isNegativeHigher=true;
			}
		}
		int negativeLimit=0;
		int postiveLimit=0;
		if(isNegativeHigher)
			negativeLimit=M;
		else
			postiveLimit=M;
		delivery(nQueue,negativeLimit);
		delivery(pQueue,postiveLimit);
	
		System.out.println(sum);
	}

	private static void delivery(PriorityQueue<Integer> Queue, int limit) 
	{
		if(Queue.size()%M!=0&&Queue.size()>M)
		{
			int queueSize=Queue.size();
			for(int i=0;i<(queueSize%M)-1;i++)
			{
				Queue.poll();
			}
			sum+=Math.abs(Queue.poll())*2;
		}
		while(Queue.size()>limit)
		{
			for(int i=0;i<M-1;i++)
			{
				if(Queue.size()==1)
					break;
				Queue.poll();
			}
			sum+=Math.abs(Queue.poll())*2;
		}
		
		if(Queue.size()>0)
		{
			while(Queue.size()>1)
				Queue.poll();
			sum+=Math.abs(Queue.poll());
		}
		
	}

}
