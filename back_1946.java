package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class back_1946 
{
	static class person {
		public int a;
		public int b;
		public person(int a,int b) {
			this.a=a;
			this.b=b;
		}
	}
	public static void main(String []args) throws NumberFormatException, IOException 
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(id.readLine());
		StringBuilder result =new StringBuilder();
		
		while(testcase-->0)
		{
			int n=Integer.parseInt(id.readLine());
			person company[]=new person[n];
			for(int i=0;i<n;i++)
			{
				String input[]=id.readLine().split(" ");
				company[i]=new person(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			}
			Arrays.sort(company,Comparator.comparing(p->p.a));
			int answer=1;
			PriorityQueue <Integer>queue=new PriorityQueue<>();
			queue.add(company[0].b);
			for(int i=1;i<n;i++)
			{
				queue.add(company[i].b);
				if(queue.peek()==company[i].b)
					answer++;
			}
			result.append(answer).append('\n');
		}System.out.println(result);
	}
}
