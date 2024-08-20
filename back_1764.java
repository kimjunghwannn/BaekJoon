package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class back_1764 {
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String input2=id.readLine();
			map.put(input2, 1);
		}
		
		PriorityQueue<String> queue=new PriorityQueue<>();
		for(int i=0;i<m;i++)
		{
			String input2=id.readLine();
			if(map.get(input2)!=null)
			{
				queue.add(input2);
			}
		}
		System.out.println(queue.size());
		
		while(!queue.isEmpty()) 
		{
			System.out.println(queue.poll());
		}
		
	}
}
