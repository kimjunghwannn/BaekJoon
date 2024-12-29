package algo;

import java.io.*;
import java.util.*;

public class back_1504 
{
	static class Node implements Comparable<Node>
	{
		public int index;
		public int distance;
		public Node(int index,int distance)
		{
			this.index=index;
			this.distance=distance;
		}
		
		public int compareTo(Node o)
		{
			return Integer.compare(this.distance, o.distance);
		}
	}
	static LinkedList<Node> graph[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String	graphInput[]=br.readLine().split(" ");
		int N=Integer.parseInt(graphInput[0]);
		int E=Integer.parseInt(graphInput[1]);
		graph=new LinkedList [N+1];
		
		
		for(int i=1;i<=N;i++)
			graph[i]=new LinkedList<>();
		for(int i=0;i<E;i++)
		{
			String lineInput[]=br.readLine().split(" ");
			int start=Integer.parseInt(lineInput[0]);
			int end=Integer.parseInt(lineInput[1]);
			int weight=Integer.parseInt(lineInput[2]);
			graph[start].add(new Node(end,weight));
			graph[end].add(new Node(start,weight));
		}
		String checkPointInput[]=br.readLine().split(" ");
		int checkPoint[]=new int [2];
		checkPoint[0]=Integer.parseInt(checkPointInput[0]);
		checkPoint[1]=Integer.parseInt(checkPointInput[1]);
		int rootA[]= {1,checkPoint[0],checkPoint[1],N};
		int rootB[]={1,checkPoint[1],checkPoint[0],N};
		int rootADistnace=0;
		int rootBDistnace=0;
		
		
		for(int i=0;i<3;i++)
		{	
			int distance=dijkstra(rootA[i],rootA[i+1]);
			if(distance==Integer.MAX_VALUE)
			{	
				rootADistnace=-1;
				break;
			}
			else
				rootADistnace+=distance;
		}
		for(int i=0;i<3;i++)
		{	int distance=dijkstra(rootB[i],rootB[i+1]);
			if(distance==Integer.MAX_VALUE)
			{	
				rootBDistnace=-1;
				break;
			}
			else
				rootBDistnace+=distance;
		}
		int minDistance=Math.min(rootADistnace, rootBDistnace);
		if(minDistance==-1)
		{
			if(rootADistnace==-1)
				minDistance=rootBDistnace;
			else
				minDistance=rootADistnace;
		}
		System.out.println(minDistance);
	}
	private static int dijkstra(int start, int end) 
	{
		int distance[]=new int [graph.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> queue=new PriorityQueue<>();
		queue.add(new Node(start,0));
		distance[start]=0;
		while(!queue.isEmpty())
		{
			Node node=queue.poll();
			int nodeIndex=node.index;
			int nodeDistance=node.distance;
			
			if(nodeDistance>distance[nodeIndex])
				continue;
			for(Node a: graph[nodeIndex])
			{
				if(nodeDistance+a.distance<distance[a.index])
				{
					distance[a.index]=nodeDistance+a.distance;
					queue.add(new Node(a.index,distance[a.index]));
				}
			}
		}
		return distance[end];
	}

}
