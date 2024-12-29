package algo;

import java.io.*;
import java.util.*;
public class back_11000 {
 
	static class lecture implements Comparable<lecture>
	{
		public int start;
		public int end;
		public lecture(int start,int end)
		{
			this.start=start;
			this.end=end;
		}
		public int compareTo(lecture other)
		{
			if(this.start!=other.start)
			{
				return this.start-other.start;
			}
			else
			{
				return this.end-other.end;
			}
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<lecture> lecturePQ=new PriorityQueue<>();
		PriorityQueue<Integer> endTime=new PriorityQueue<>();
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			int start=Integer.parseInt(input[0]);
			int end=Integer.parseInt(input[1]);
			lecturePQ.add(new lecture(start,end));
		}
		lecture firstLect =lecturePQ.poll();
		endTime.add(firstLect.end);
		while(!lecturePQ.isEmpty())
		{
			lecture now =lecturePQ.poll();
			if(now.start>=endTime.peek())
				endTime.poll();
			endTime.add(now.end);
		}
		System.out.println(endTime.size());
	}
}
