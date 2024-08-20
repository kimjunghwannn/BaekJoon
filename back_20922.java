package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class back_20922 {


	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int k=Integer.parseInt(input[1]);
		String input2[]=id.readLine().split(" ");
		int su[]=new int[n];
		HashMap<Integer,Integer> a=new HashMap<>();
		int answer=0;
		int maxanwer=0;
		Queue<Integer> database=new LinkedList<>();
		for(int i=0;i<n;i++)
		{	
			su[i]=Integer.parseInt(input2[i]);
			if(a.get(su[i])==null)
			{
				a.put(su[i], 1);
				database.add(su[i]);
				answer++;
			}
			else {
				int checksu=a.get(su[i]);
				if(checksu==k)
				{

					maxanwer=Math.max(maxanwer, answer);
					while(database.peek()!=su[i]) {
						answer--;
						int datapop=database.poll();
						a.replace(datapop, a.get(datapop), a.get(datapop)-1);
					}
					database.poll();
					database.add(su[i]);
				}
				else {
					a.replace(su[i], a.get(su[i]), a.get(su[i])+1);
					database.add(su[i]);
					answer++;
				}
				
			}
		}
		maxanwer=Math.max(maxanwer, answer);
		System.out.println(maxanwer);
	}
}
