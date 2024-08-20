package algo;

import java.util.*;
import java.io.*;
public class back_1874 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader id = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		int numArray[]=new int [N];
		StringBuilder result = new StringBuilder();
		for(int i=0;i<N;i++)
			numArray[i]=Integer.parseInt(id.readLine());
		Stack<Integer> stack=new Stack<>();
		int index=0;
		for(int i=1;i<=N;i++)
		{	
			stack.add(i);
			result.append("+\n");
			if(stack.peek()==numArray[index])
			{
				while(!stack.isEmpty()&&stack.peek()==numArray[index])
				{
					stack.pop();
					result.append("-\n");
					index++;
				
				}
			}
		}
		if(stack.isEmpty())
			 System.out.println(result.toString());
		else
			System.out.println("NO");
	}
}
