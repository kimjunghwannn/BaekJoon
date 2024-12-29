package algo;

import java.io.*;
import java.util.*;
public class back_30805 
{
	static class Node implements Comparable<Node>
	{
		int index;
		int value;
		public Node(int index,int value)
		{
			this.index=index;
			this.value=value;
		}
		@Override
		public int compareTo(Node o) {
			if(this.value==o.value)
				return Integer.compare(this.index,o.index);
			return Integer.compare(o.value, this.value);
		}
		
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PriorityQueue<Node> aQueue=new PriorityQueue<Node>();
		PriorityQueue<Node> bQueue=new PriorityQueue<Node>();

		int aArrayN=Integer.parseInt(br.readLine());
		int aArray[]=new int [aArrayN];
		String input[]=br.readLine().split(" ");
		Map<Integer,ArrayList<Node>> aMap=new HashMap<>();
		
		for(int i=0;i<aArrayN;i++)
		{	
			aArray[i]=Integer.parseInt(input[i]);
			aQueue.add(new Node(i,aArray[i]));
		}
		
		
		int bArrayN=Integer.parseInt(br.readLine());
		int bArray[]=new int [bArrayN];
		String input2[]=br.readLine().split(" ");
		
		for(int i=0;i<bArrayN;i++)
		{	
			bArray[i]=Integer.parseInt(input2[i]);
			bQueue.add(new Node(i,bArray[i]));
		}
	
		ArrayList<Integer> answer=new ArrayList<>();
		int nowAIndex=0;
		int nowBIndex=0;
		//System.out.println(bQueue.size());
		while(!aQueue.isEmpty()&&!bQueue.isEmpty())
		{
			Node nowA=aQueue.poll();
			Node nowB=bQueue.poll();
			
			do 
			{
				if(nowA.value>nowB.value||nowA.index<nowAIndex)
					nowA=aQueue.poll();
				if(nowB.value>nowA.value||nowB.index<nowBIndex)
					nowB=bQueue.poll();
			}
			while((!aQueue.isEmpty()&&!bQueue.isEmpty())&&(nowA.value!=nowB.value||
					nowA.index<nowAIndex||nowB.index<nowBIndex));
				
			
			
			
			if(nowB.value==nowA.value)
			{
				answer.add(nowA.value);
				nowAIndex=nowA.index;
				nowBIndex=nowB.index;
			}
			while((!aQueue.isEmpty()&&aQueue.peek().index<nowAIndex))
				{	
					aQueue.poll();
					
				}
			while((!bQueue.isEmpty()&&bQueue.peek().index<nowBIndex))
			{	
				bQueue.poll();
			}
		}
		System.out.println(answer.size());
		for(int a :answer )
			System.out.print(a+" ");
		
	}

}

