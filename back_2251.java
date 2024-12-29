package algo;

import java.io.*;
import java.util.*;
public class back_2251 
{
	static Set<Integer> answerList;
	static int A;
	static int B;
	static int C;
	static class Bucket
	{
		int limit;
		int amount;
		public Bucket(int limit,int amount)
		{
			this.amount=amount;
			this.limit=limit;
		}
	}
	static class Record
	{
		ArrayList<Bucket> bList =new ArrayList<>();
		public Record(Bucket a,Bucket b,Bucket c)
		{
			bList.add(a);
			bList.add(b);
			bList.add(c);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		A=Integer.parseInt(input[0]);
		B=Integer.parseInt(input[1]);
		C=Integer.parseInt(input[2]);
		answerList=new TreeSet<>();
		Queue<Record> queue=new LinkedList<>();
		queue.add(new Record(new Bucket(A,0),new Bucket(B,0),new Bucket(C,C)));
		boolean visited[][][]=new boolean [A+1][B+1][C+1];
		while(!queue.isEmpty())
		{
			Record now=queue.poll();
			if(now.bList.get(0).amount==0)
				answerList.add(now.bList.get(2).amount);
			
			for(int i=0;i<3;i++)
			{
				for(int k=0;k<3;k++)
				{
					if(i==k)
						continue;
					ArrayList<Bucket> newBucket=new ArrayList<>();
					newBucket.add(new Bucket(now.bList.get(0).limit,now.bList.get(0).amount));
					newBucket.add(new Bucket(now.bList.get(1).limit,now.bList.get(1).amount));
					newBucket.add(new Bucket(now.bList.get(2).limit,now.bList.get(2).amount));
				if(now.bList.get(i).amount>now.bList.get(k).limit-now.bList.get(k).amount)
				{
					int iDeliverAmount=now.bList.get(k).limit-now.bList.get(k).amount;
					newBucket.get(k).amount=newBucket.get(k).limit;
					newBucket.get(i).amount-=iDeliverAmount;
				}
				else
				{
					newBucket.get(i).amount=0;
					newBucket.get(k).amount+=now.bList.get(i).amount;
				}
				if(visited[newBucket.get(0).amount][newBucket.get(1).amount][newBucket.get(2).amount])
					continue;
				queue.add(new Record(newBucket.get(0),newBucket.get(1),newBucket.get(2)));
				visited[newBucket.get(0).amount][newBucket.get(1).amount][newBucket.get(2).amount]=true;
				}
			}
		}
		for(int a : answerList)
			System.out.print(a+" ");
	}


}
