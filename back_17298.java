package algo;

import java.util.*;
import java.io.*;
public class back_17298 
{
	static class Integers implements Comparable<Integers>
	{
		public int value;
		public int index;
		public int greaterValue;
		public Integers(int value,int index)
		{
			this.index=index;
			this.value=value;
		}
		public int compareTo(Integers other)
		{
			return Integer.compare(this.value, other.value);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Integers array[]=new Integers [N];
		String inputIntegers[]= br.readLine().split(" ");
		StringBuffer sb=new StringBuffer();
		PriorityQueue<Integers> pq=new PriorityQueue<>();
		
		for(int i=0;i<N;i++)
			array[i]=new Integers(Integer.parseInt(inputIntegers[i]),i);
		
		pq.add(array[0]);
		for(int i=1;i<N;i++)
		{
			if(pq.isEmpty())
			{	
				pq.add(array[i]);
				continue;
			}
			
			if(pq.peek().value<array[i].value)
			{
				while(!pq.isEmpty()&&pq.peek().value<array[i].value)
				{
					array[pq.poll().index].greaterValue=array[i].value;
				}
				
			}
			
			pq.add(array[i]);
		}
		while(!pq.isEmpty())
		{
			array[pq.poll().index].greaterValue=-1;
		}
		array[N-1].greaterValue=-1;
		
		
		
		for(int i=0;i<N;i++)
			sb.append(array[i].greaterValue+" ");
		System.out.println(sb.toString());
	}

}
