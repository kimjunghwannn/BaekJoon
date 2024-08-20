package algo;

import java.io.*;
import java.util.*;

public class back_13144 {
	public static void main(String args[])throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		String input[]=id.readLine().split(" ");
		int intArray[]=new int[N+1];
		for(int i=1;i<=N;i++)
			intArray[i]=Integer.parseInt(input[i-1]);
		int answer=0;
		Map<Integer,Boolean> integerMap=new HashMap<>();
		long length=0;
		Queue<Integer> integerQueue=new LinkedList<>();
		for(int i=1;i<=N;i++)
		{
			if(integerMap.get(intArray[i])==null||integerMap.get(intArray[i])==false)
			{
				length++;
				answer+=length;
				integerMap.put(intArray[i], true);
				integerQueue.add(intArray[i]);
			}
			else
			{
					while(true)
					{
						int a=integerQueue.poll();
						if(a==intArray[i]||integerQueue.isEmpty())
							break;
						integerMap.put(a, false);
					}
					integerQueue.add(intArray[i]);
					length=integerQueue.size();
				
				answer+=length;
			}
		}
		
		System.out.println(answer);
		
	}
}
