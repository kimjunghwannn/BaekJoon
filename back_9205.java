package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class back_9205 {
	static class market{
		public int y;
		public int x;
		public market(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(id.readLine());
		while(testcase-->0)
		{
			int market_n=Integer.parseInt(id.readLine());
			String input[]=id.readLine().split(" ");
			int now_y=Integer.parseInt(input[0]);
		 	int now_x=Integer.parseInt(input[1]);
		 	List<market> a=new ArrayList<>();
		 	a.add(new market(now_y,now_x));
			for(int i=0;i<market_n;i++)
			{
				String input2[]=id.readLine().split(" ");
				market presnt=new market(Integer.parseInt(input2[0]),Integer.parseInt(input2[1]));
				a.add(presnt);			
			}
			String input3[]=id.readLine().split(" ");
			int end_y=Integer.parseInt(input3[0]);
			int end_x=Integer.parseInt(input3[1]);
			a.add(new market(end_y,end_x));
			List<Integer>[]edges=new ArrayList [a.size()];
			for (int i = 0; i < a.size(); i++) {
	            edges[i] = new ArrayList<>();
	        }
			for(int i=0;i<a.size();i++)
			{
				for(int j=i+1;j<a.size();j++)
				{
					market q=a.get(i);
					market w=a.get(j);
					if(Math.abs(q.x-w.x)+Math.abs(q.y-w.y) > 1000) continue;
					edges[i].add(j);
					edges[j].add(i);
				}
			}
			Queue<Integer> queue=new LinkedList<>();
			queue.add(0);
			boolean check[]=new boolean[a.size()];
			check[0]=true;
			boolean sucess=false;
			while(!queue.isEmpty()) {
				int index=queue.poll();
				for(int i: edges[index])
				{
					if(check[i]==true)
						continue;
					market now=a.get(i);
					if(now.x==end_x&&now.y==end_y)
					{	
						System.out.println("happy");
						sucess=true;
					}
					queue.add(i);
					check[i]=true;				}
			}
			if(!sucess)
			System.out.println("sad");
		}
	}
}
