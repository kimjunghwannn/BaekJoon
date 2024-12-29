package algo;

import java.io.*;
import java.util.*;
public class back_15164
{
	static class Node
	{
		int time;
		ArrayList<Integer> indexArray=new ArrayList<>();
		public Node(int time)
		{
			this.time=time;
		}
	}
	static int DP[];
	static boolean visited[];
	static int maxTime=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Node> nodeList=new ArrayList<>();
		DP=new int [N+1];
		visited=new boolean [N+1];
		int checksu=0;
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			Node newNode=new Node(Integer.parseInt(input[0]));
			for(int j=1;j<input.length;j++)
			{
				int index=Integer.parseInt(input[j]);
				if(index==-1)
					break;
				newNode.indexArray.add(index);
			}
			nodeList.add(newNode);
		}
		while(checksu!=N)
		{
			for(int i=0;i<nodeList.size();i++)
			{
				maxTime=0;
				if(visited[i+1])
					continue;
				if(nodeList.get(i).indexArray.size()==0||check(nodeList.get(i).indexArray))
				{
					DP[i+1]=maxTime+nodeList.get(i).time;
					visited[i+1]=true;
					checksu++;
				}
			
			}
		}
		for(int i=1;i<=N;i++)
			System.out.println(DP[i]);
		
	}
	static boolean check(ArrayList<Integer> now)
	{
		
		for(int a:now)
		{	
			if(!visited[a])
				return false;
			maxTime=Math.max(maxTime,DP[a]);
		}
		return true;
	}
}
