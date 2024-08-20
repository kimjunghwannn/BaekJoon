package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class back_2075 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<n;i++)
		{
			String input[]=br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				int a=Integer.parseInt(input[j]);
				if(q.size()==n)
				{
					if(q.peek()<a)
					{
						q.poll();
						q.add(a);
					}
				}
				else {
					q.add(a);
				}
			}
		}
		System.out.println(q.poll());
	}
}
