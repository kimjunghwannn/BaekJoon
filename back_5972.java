package algo;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Node
	{
		private int end;
		private int weight;
		public Node(int end, int weight)
		{
			this.end=end;
			this.weight=weight;
		}
		public int getEnd()
		{
			return end;
		}
		public int getWeight()
		{
			return weight;
		}
	}
public class back_5972 {
	static BufferedReader id;
	static int N;
	static int M;
	static ArrayList<Node>[]nodeLinked;
	static PriorityQueue<Integer>oneMatrix;
	static int []table;
	public static void main(String args[]) throws IOException
	{
		id = new BufferedReader(new InputStreamReader(System.in));
		String mapData =id.readLine();
		N=Integer.parseInt(mapData.split(" ")[0]);
		M=Integer.parseInt(mapData.split(" ")[1]);
		nodeLinked=new ArrayList[N+1];
		for(int i=0;i<N+1;i++)
			nodeLinked[i]=new ArrayList<>();
		oneMatrix=new PriorityQueue<>();
		table=new int [N+1];
		Arrays.fill(table,Integer.MAX_VALUE);
		setNodeLinkde();
		while(!oneMatrix.isEmpty())
		{
			int now=oneMatrix.poll();
				for(Node a : nodeLinked[now])
				{
					if(a.getWeight()+table[now]<table[a.getEnd()])
					{	
						table[a.getEnd()]=a.getWeight()+table[now];
						oneMatrix.add(a.getEnd());
					}
				}
		}
		System.out.println(table[N]);
	}
	private static void setNodeLinkde() throws IOException {
		for(int i=0;i<M;i++)
		{
			String input=id.readLine();
			int start=Integer.parseInt(input.split(" ")[0]);
			int end=Integer.parseInt(input.split(" ")[1]);
			int weight=Integer.parseInt(input.split(" ")[2]);
			int tmp=0;
			if(start>end)
			{	
				tmp=start;
				start=end;
				end=tmp;
			}
			if(start==1)
			{	
				oneMatrix.add(end);
				table[end]=weight;
			}
			nodeLinked[start].add(new Node(end,weight));
			nodeLinked[end].add(new Node(start,weight));
		}
		
	}
}
