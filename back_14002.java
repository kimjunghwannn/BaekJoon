package algo;

import java.io.*;
import java.util.*;

public class back_14002 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int array[]=new int [N];
		int DP[]=new int[N];
		String input[]=br.readLine().split(" ");
		ArrayList<Integer> answerList=new ArrayList<>();		
		
		for(int i=0;i<N;i++)
		{	
			array[i]=Integer.parseInt(input[i]);
		}
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(array[j]<array[i])
				{	
					DP[i]=Math.max(DP[i], DP[j]+1);
					
				}
			}
		}
		int maxIndex=0;
		int maxValue=0;
		for(int i=1;i<N;i++)
		{
			if(DP[i]>maxValue)
			{	
				maxIndex=i;
				maxValue=DP[i];
			}
		}
		int nextIndex=maxIndex;
		answerList.add(array[maxIndex]);
		for(int i=maxIndex-1;i>=0;i--)
		{
			//System.out.println(i+" "+DP[i]);
			if(DP[nextIndex]-1==DP[i]&&array[nextIndex]>array[i])
			{
				answerList.add(array[i]);
				nextIndex=i;
			}
		}
		System.out.println(maxValue+1);
		Collections.sort(answerList);
		for(int a :answerList)
			System.out.print(a+" ");
	}

}
