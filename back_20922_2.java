package algo;


import java.io.*;
import java.util.*;
public class back_20922_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		String inputArray[]=id.readLine().split(" ");
		int intArray[]=new int [N];
		int start=0;
		int end=0;
		int answer=0;
		Map <Integer,Integer> countMap=new HashMap<>();
		for(int i=0;i<N;i++)
			intArray[i]=Integer.parseInt(inputArray[i]);
		for(int i=0;i<N;i++)
		{
			if(countMap.get(intArray[i])==null)
				countMap.put(intArray[i], 1);
			else
			{
				countMap.put(intArray[i],countMap.get(intArray[i])+1);
				if(countMap.get(intArray[i])>K)
				{
					answer=Math.max(answer, end-start);
					for(int j=start;j<N;j++)
					{
						start++;
						countMap.put(intArray[j],countMap.get(intArray[j])-1);
						
						if(intArray[i]==intArray[j])
							break;	
					}
				}
			}
			end++;
		}
		System.out.println(Math.max(answer, end-start));
	}
}
