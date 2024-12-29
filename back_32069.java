package algo;

import java.io.*;
import java.util.*;
public class back_32069 {
	static class Node
	{
		Long index;
		boolean left;
		public Node(Long index,boolean left)
		{
			this.index=index;
			this.left=left;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		Long L=Long.parseLong(input[0]);
		int N=Integer.parseInt(input[1]);
		int K=Integer.parseInt(input[2]);
		Queue<Node>  queue=new LinkedList<>();
		Map<Long,Boolean> map=new HashMap<>();
		String input2[]=br.readLine().split(" ");
		Long sLamp[]=new Long[N];
		for(int i=0;i<N;i++)
		{	
			sLamp[i]=Long.parseLong(input2[i]);
			map.put(sLamp[i],true);
			System.out.println(0);
			K--;
		}
		for(int i=0;i<N;i++)
		{
			if(sLamp[i]-1>=0&&map.get(sLamp[i]-1)==null)
				queue.add(new Node(sLamp[i],true));
			if(sLamp[i]+1<=L&&map.get(sLamp[i]+1)==null)
				queue.add(new Node(sLamp[i],false));
		}
		int len=1;
		while(K>0)
		{
			int queueSize=queue.size();
			for(int i=0;i<queueSize;i++)
			{
				if(K==0)
					break;
				
				Node position=queue.poll();
				Long leftMin=position.index-len;
				Long rightMin=position.index+len;
				
				if(position.left&&leftMin>=0&&map.get(leftMin)==null)
				{
					Long left=leftMin-1;
					boolean pass=true;
					//System.out.println(position.index+" "+len);

					for(int j=0;j<len-1;j++)
					{
						if(left==0)
							break;
						if(map.get(left)!=null)
						{	
							pass=false;
							break;
						}
						left--;
					}
					if(!pass)
						continue;
					K--;
					queue.add(position);
					System.out.println(len);
					
				}
				if(!position.left&&rightMin<=L&&map.get(rightMin)==null)
				{
					Long right=rightMin+1;
					//System.out.println(position.index+" "+len);
					boolean pass=true;
					for(int j=0;j<len-1;j++)
					{
						if(right==L)
							break;
						if(map.get(right)!=null)
						{	
							pass=false;
							break;
						}
						right++;
					}
					if(!pass)
						continue;
					K--;
					queue.add(position);
					System.out.println(len);
				
				}
				
				
				
			}
			len++;
		}
	}
}
