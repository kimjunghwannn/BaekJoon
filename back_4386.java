package algo;

import java.io.*;
import java.util.*;
public class back_4386 
{
	static int parents[];
	static class star
	{
		double y;
		double x;
		public star(double y,double x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static class road implements Comparable<road>
	{
		int aIndex;
		int bIndex;
		double distance;
		public road(int aIndex,int bIndex,double distance)
		{
			this.aIndex=aIndex;
			this.bIndex=bIndex;
			this.distance=distance;
		}
		public int compareTo(road other)
		{
			return Double.compare(this.distance,other.distance);
		}
	}
	static star array[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		PriorityQueue<road> queue=new PriorityQueue<>();
		array=new star [n];
		parents=new int [n];
		for(int i=0;i<n;i++)
		{
			String input[]=br.readLine().split(" ");
			double y=Double.parseDouble(input[1]);
			double x=Double.parseDouble(input[0]);
			array[i]=new star(y,x);
		}
		double answer=0;
		for(int i=0;i<n;i++)
			parents[i]=i;
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(parents[i]==parents[j])
					continue;
				double iX=array[i].x;
				double iY=array[i].y;
				double jX=array[j].x;
				double jY=array[j].y;
				double nowDistance=Math.sqrt((iX-jX)*(iX-jX)+(iY-jY)*(iY-jY));
				queue.add(new road(i,j,nowDistance));
			}
		}
		while(!queue.isEmpty())
		{
			road now=queue.poll();
			if(!union(now.aIndex,now.bIndex))
				continue;
			answer+=now.distance;
		}
		System.out.printf("%.2f%n", answer);
	}
	private static boolean union(int i, int j) 
	{
		i=find(i);
		j=find(j);
		
		if(i==j)
			return false;
		if(i>j)
			parents[i]=j;
		else
			parents[j]=i;
		return true;
			
		
	}
	private static int find(int index) {
		if(parents[index]==index)return index;
		return find(parents[index]);
	}

}
