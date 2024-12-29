package algo;

import java.util.*;
import java.io.*;
public class back_2170 
{
	static class Line implements Comparable<Line>
	{
		public int x1;
		public int x2;
		
		public Line(int x1,int x2)
		{
			this.x1=x1;
			this.x2=x2;
		}
		
		  public int compareTo(Line other) {
		        if (this.x1 != other.x1) {
		            return Integer.compare(this.x1, other.x1);
		        }
		        return Integer.compare(this.x2, other.x2);
		    }
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Line lineArray[]=new Line [N];
		int totalLength=0;
		int nowX1=0;
		int nowX2=0;
		
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			int x1=Integer.parseInt(input[0]);
			int x2=Integer.parseInt(input[1]);
			lineArray[i]=new Line (x1,x2);
		}
		Arrays.sort(lineArray);
		
		nowX1=lineArray[0].x1;
		nowX2=lineArray[0].x2;
		
		if(N==1)
		{
			System.out.println(nowX2-nowX1);
			System.exit(0);
		}
		
		for(int i=1;i<N;i++)
		{
			if(lineArray[i].x1<nowX2)
			{
				if(lineArray[i].x2>nowX2)
				{
					nowX2=lineArray[i].x2;
				}
			}
			else if(lineArray[i].x1==nowX2)
			{
				nowX2=lineArray[i].x2;
			}
			else
			{
				
				totalLength+=nowX2-nowX1;
				nowX1=lineArray[i].x1;
				nowX2=lineArray[i].x2;
				
				
			}
			if(i==N-1)
				{
						totalLength+=nowX2-nowX1;
				}
		}
		System.out.println(totalLength);
	}
	
}
