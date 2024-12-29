package algo;

import java.io.*;
import java.util.*;
public class back_1374 
{
	static class Class implements Comparable<Class>
	{
		int start;
		int end;
		public Class(int start,int end)
		{
			this.start=start;
			this.end=end;
		}
		public int compareTo(Class other)
		{
			if(this.start==other.start)
				return Integer.compare(this.end, other.end);
			return Integer.compare(this.start, other.start);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Class> classArray=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			classArray.add(new Class(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
		}
		Collections.sort(classArray);
		PriorityQueue<Integer> endTime=new PriorityQueue<>();
		endTime.add(0);
		for(Class a : classArray)
		{
			if(endTime.peek()<=a.start)
				endTime.poll();
			endTime.add(a.end);
		}
		System.out.println(endTime.size());
	}
}
