package algo;

import java.io.*;
import java.util.*;
public class back_2109 
{
	static class lecture implements Comparable<lecture>
	{
		int value;
		int day;
		public lecture(int value,int day)
		{
			this.value=value;
			this.day=day;
		}
		public int compareTo(lecture other)
		{
				return Integer.compare(other.value,this.value);
		}	
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		PriorityQueue<lecture> queue=new PriorityQueue<>();
		ArrayList<lecture> list[]=new ArrayList [100001];
		for(int i=0;i<100001;i++)
			list[i]=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			String input[]=br.readLine().split(" ");
			int value=Integer.parseInt(input[0]);
			int day=Integer.parseInt(input[1]);
			list[day].add(new lecture(value,day));
		}
		int answer=0;
		for(int i=100000;i>0;i--)
		{
			for(lecture a : list[i])
				queue.add(a);
			if(!queue.isEmpty())
				answer+=queue.poll().value;
		}
		System.out.println(answer);
	}

}
