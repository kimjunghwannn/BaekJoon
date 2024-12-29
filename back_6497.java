package algo;

import java.io.*;
import java.util.*;
public class back_6497 
{
	static class Road implements Comparable<Road>
	{
		int start;
		int end;
		int value;
		public Road(int start,int end,int value)
		{
			this.start=start;
			this.end=end;
			this.value=value;
		}
		public int compareTo(Road other)
		{
			return this.value-other.value;
		}
	}
	static int parents [];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String input[]=br.readLine().split(" ");
			int m=Integer.parseInt(input[0]);
			int n=Integer.parseInt(input[1]);
			if(m==0&&n==0)
				break;
			ArrayList<Road> list=new ArrayList<>();
			int totalValue=0;
			int useValue=0;
			for(int i=0;i<n;i++)
			{
				String input2[]=br.readLine().split(" ");
				int start=Integer.parseInt(input2[0]);
				int end=Integer.parseInt(input2[1]);
				int value=Integer.parseInt(input2[2]);
				list.add(new Road(start,end,value));
				totalValue+=value;
			}
			parents=new int [m];
			for(int i=0;i<m;i++)
				parents[i]=i;
			int useRoad=0;
			Collections.sort(list);
			for(Road a: list)
			{
				if(union(a.start,a.end))
				{	
					useValue+=a.value;
					useRoad++;
				}
				if(useRoad-1==m)
					break;
			}
			System.out.println(totalValue-useValue);
		}
	}
	private static boolean union(int start, int end) 
	{	
		start=find(start);
		end=find(end);
		if(start==end)
			return false;
		
		if(start>end)
			parents[start]=end;
		else
			parents[end]=start;
		return true;
	}
	private static int find(int index) {
		if(parents[index]==index) return index;
		return find(parents[index]);
	}

}
