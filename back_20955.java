package algo;

import java.io.*;
import java.util.*;
public class back_20955 
{
	static int parent[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int answer=0;
		parent=new int [N+1];
		for(int i=1;i<=N;i++)
			parent[i]=i;
		for(int i=0;i<M;i++)
		{
			String input2[]=br.readLine().split(" ");
			int start=Integer.parseInt(input2[0]);
			int end=Integer.parseInt(input2[1]);
			if(!union(start,end))
			{	
				answer++;
			}
		}
		Map<Integer,Boolean> map=new HashMap<>();
		for(int i=1;i<=N;i++)
		{
			int root=find(i);
			if(root!=1&&map.get(root)==null)
			{	
				map.put(root, true);
				answer++;
			}
		}
		System.out.println(answer);
	}
	static boolean union(int y,int x)
	{
		y=find(y);
		x=find(x);
		if(y==x) 
		{	
			return false;
		}
		if(x<=y)
		{	
			parent[y]=x;
			return true;
		}
		else 
		{
			parent[x]=y;
			return true;
		}
		
	}
	static int find(int x)
	{
		if(parent[x]==x) return x;
		return find(parent[x]);
	}
}
