package algo;

import java.io.*;
import java.util.*;
public class back_2159 
{
	static class Node
	{
		int y;
		int x;
		long min[]=new long [5];
		public Node(int y,int x)
		{
			this.y=y;
			this.x=x;
			for(int i=0;i<5;i++)
				min[i]=Long.MAX_VALUE;
		}
	}
	static int dy[]= {1,-1,0,0,0};
	static int dx[]= {0,0,-1,1,0};//상하좌우
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Node> list=new ArrayList<>();
		for(int i=0;i<=N;i++)
		{
			String input[]=br.readLine().split(" ");
			int x=Integer.parseInt(input[0]);
			int y=Integer.parseInt(input[1]);
			list.add(new Node(y,x));
		}
		for(int i=0;i<5;i++)
		{	
			list.get(1).min[i]=Math.abs(list.get(0).y-(list.get(1).y+dy[i]))+Math.abs(list.get(0).x-(list.get(1).x+dx[i]));
		}
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<5;j++)
			{
				int nx=list.get(i).x+dx[j];
				int ny=list.get(i).y+dy[j];
				long distance=list.get(i).min[j];
				for(int k=0;k<5;k++)
				{
					int cx=list.get(i+1).x+dx[k];
					int cy=list.get(i+1).y+dy[k];
					long cDistance=list.get(i+1).min[k];
					long bDistance=Math.abs(nx-cx)+Math.abs(ny-cy);
					if(distance+bDistance<cDistance)
						list.get(i+1).min[k]=distance+bDistance;
				}
			}
		}
		long answer=Long.MAX_VALUE;
		for(int i=0;i<5;i++)
		{
			answer=Math.min(answer,list.get(N).min[i]);
		}
		System.out.println(answer);
	}
}
