package algo;

import java.util.*;
import java.io.*;
public class back_20040 
{
	static int parent[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int pointCount=Integer.parseInt(input[0]);
		int turnCount=Integer.parseInt(input[1]);
		parent=new int [pointCount];
		for(int i=0;i<pointCount;i++)
			parent[i]=i;
		for(int i=0;i<turnCount;i++)
		{
			String input2[]=br.readLine().split(" ");
			int start=Integer.parseInt(input2[0]);
			int end=Integer.parseInt(input2[1]);
			
			if(union_find(start,end))
			{
				System.out.println(i+1);
				System.exit(0);
			}
		}
		System.out.println(0);
	
	}

	private static boolean union_find(int start, int end) {
		start=find(start);
		end=find(end);
		
		if(start==end)
			return true;
		else
		{	
			parent[start]=end;
			return false;
		}
	}

	private static int find(int point) {
		if(parent[point]==point)
			return point;
		else
			return parent[point]=find(parent[point]);
	}
}
