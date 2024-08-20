package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class back_13549 {
	static class hide {
		public int cm;
		public int time;
		public hide(int cm,int time) {
			this.time=time;
			this.cm=cm;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");	
		int start=Integer.parseInt(input[0]);
		int end=Integer.parseInt(input[1]);
		int distance[]=new int [1000000];
		if(start==end)
		{
			System.out.println(0);
			System.exit(0);
		}
		if(start>end) 
		{
			System.out.println(start-end);
			System.exit(0);
		}
		PriorityQueue<hide> a = new PriorityQueue<>((x, y) -> y.cm - x.cm);
		a.add(new hide(start,0));
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[end]=end-start;
		while(!a.isEmpty()) {
			hide now=a.poll();
			System.out.println(now.cm);
			
			if(now.cm-end>distance[end])
				continue;
			if(now.cm*2<100000)
			{
				if(distance[now.cm*2]>now.time)
				{	
					distance[now.cm*2]=now.time;
					a.add(new hide(now.cm*2,now.time));
				}
			}
			if(now.cm-1>0&&distance[now.cm-1]>now.time+1)
			{
				distance[now.cm-1]=now.time+1;
				a.add(new hide(now.cm-1,now.time+1));
			}
			if(distance[(now.cm+1)]>now.time+1)
			{
				distance[(now.cm+1)]=now.time+1;
				a.add(new hide((now.cm+1),now.time+1));
			}
		}
		System.out.println(distance[end]);
	}
}
