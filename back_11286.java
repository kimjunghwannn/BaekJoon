package algo;

import java.util.*;
import java.io.*;
public class back_11286 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> positivePQ=new PriorityQueue<>();
		PriorityQueue<Integer> negativePQ=new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<N;i++)
		{
			int number=Integer.parseInt(br.readLine());
			if(number==0)
			{
				if(!positivePQ.isEmpty()&&!negativePQ.isEmpty())
				{
					if(positivePQ.peek()<Math.abs(negativePQ.peek()))
						System.out.println(positivePQ.poll());
					else
						System.out.println(negativePQ.poll());
				}
				else if(positivePQ.isEmpty()&&!negativePQ.isEmpty())
					System.out.println(negativePQ.poll());
				else if(negativePQ.isEmpty()&&!positivePQ.isEmpty())
					System.out.println(positivePQ.poll());
				else
					System.out.println(0);
				continue;
			}
			
			if(number>0)
				positivePQ.add(number);
			else
				negativePQ.add(number);
			
		}
	}

}
