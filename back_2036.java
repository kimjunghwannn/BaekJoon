package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_2036 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int minus_n=0;
		int zero_n=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++)
		{
			int a=Integer.parseInt(id.readLine());
			pq.add(a);
			if(a<0)
				minus_n++;
			if(a==0)
				zero_n++;
		}
		long sum=0;
		while(minus_n>0) {
			if(minus_n==1&&zero_n==0)
			{
					int c=pq.poll();
					sum+=c;
					minus_n--;
					break;
			}
			long a=pq.poll();
			long b=pq.poll();
			minus_n-=2;
			long plus=a*b;
			sum+=plus;
		}
		while(!pq.isEmpty()&&  ( pq.peek()==0||pq.peek()==1))
		{
			sum+=pq.poll();		
		}
		while(!pq.isEmpty()) {
			if(pq.size()%2==1)
			{
				sum+=pq.poll();
				continue;
			}
			long a=pq.poll();
			long b=pq.poll();
			long plus=a*b;
			sum+=plus;
		}
		System.out.println(sum);
	}
}
