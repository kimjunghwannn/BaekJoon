package algo;

import java.io.*;
import java.util.*;
public class back_1083 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String input[]=br.readLine().split(" ");
		ArrayList<Integer> array=new ArrayList<>();
		for(int i=0;i<N;i++)
			array.add(Integer.parseInt(input[i]));
		int S=Integer.parseInt(br.readLine());
		int start=0;
		while(true)
		{
			if(S==0||start>=array.size())
				break;
			start++;
			int index=-1;
			int maxValue=array.get(start-1);
			for(int i=start;i<array.size();i++)
			{
				if(S>=(i-start)+1)
				{
					int nowValue=array.get(i);
					if(maxValue<nowValue)
					{
						index=i;
						maxValue=nowValue;
					}
				}
			}
			if(index==-1)
				continue;
			
			array.remove(index);
			array.add(start-1, maxValue);
			S-=(index-start)+1;
			
			
		}
		for(int a:array)
			System.out.print(a+" ");
	}

}
