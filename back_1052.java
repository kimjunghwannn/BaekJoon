package algo;
import java.io.*;
import java.util.*;
public class back_1052 
{
	static class glass implements Comparable<glass>
	{
		int hight;
		public glass(int hight)
		{
			this.hight=hight;
		}
		
		public int compareTo(glass other)
		{
			return this.hight-other.hight;
		}
	}
	static int answer=0;
	static int N;
	static PriorityQueue<Integer> queue= new PriorityQueue<>(); 
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		
		doCompress(N,1);
		if(K>=queue.size())
		{
			System.out.println(answer);
			System.exit(0);
		}
		while(true)
		{
			if(K>=queue.size())
			{
				System.out.println(answer);
				System.exit(0);
			}
			int now=queue.poll();
			if(!queue.isEmpty())
			{
				if(now!=queue.peek())
				{
					answer+=now;
				}
				else
				{
					queue.poll();
				}
				queue.add(now*2);
			}
		}
	}
	private static void doCompress(int n, int height) 
	{
			if(n==1)
			{
				queue.add(height);
				return;
			}
			if(n%2!=0)
				queue.add(height);
			doCompress(n/2,height*2);
	}
}
