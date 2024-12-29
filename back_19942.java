package algo;

import java.io.*;
import java.util.*;
public class back_19942 
{
	static int mAmount[]=new int [4];
	static int min=Integer.MAX_VALUE;
	static int amount[][];
	static ArrayList<Integer> answerList=new ArrayList<>();
	static ArrayList<Integer> list=new ArrayList<>(); 
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String input[]=br.readLine().split(" ");
		amount= new int [N][5];
		for(int i=0;i<4;i++)
		{	
			mAmount[i]=Integer.parseInt(input[i]);
		}
		for(int i=0;i<N;i++)
		{
			String input2[]=br.readLine().split(" ");
			for(int j=0;j<5;j++)
				amount[i][j]=Integer.parseInt(input2[j]);
		}
		backTraking(0,new int [4],0);
		if(min==Integer.MAX_VALUE)
			System.out.println(-1);
		else
		{
			System.out.println(min);
			Collections.sort(list);
			for(int a:list)
				System.out.print(a+" ");
		}
	}
	private static void backTraking(int index, int sum[],int money) 
	{
		if(index>amount.length)
			return;
		if(isSame(sum))
		{
			if(money<min)
			{	
				min=money;
			}
			else if(money==min)
			{
				int size=Math.min(list.size(), answerList.size());
				
				boolean pass=false;
				for(int i=0;i<size;i++)
				{
					if(answerList.get(i)<list.get(i))
					{	
						pass=true;
						break;
					}
					if(answerList.get(i)>list.get(i))
						return;
				}
				if(!pass&&list.size()<answerList.size())
					return;

			}
			else
				return;
			list.clear();
			for(int a : answerList)
				list.add(a);
			return;
		}
		
		for(int i=index;i<amount.length;i++)
		{
			for(int j=0;j<4;j++)
				sum[j]+=amount[i][j];
			answerList.add(i+1);
			backTraking(i+1,sum,money+amount[i][4]);
			answerList.remove(answerList.size()-1);
			for(int j=0;j<4;j++)
				sum[j]-=amount[i][j];
		}
		
	}
	private static boolean isSame(int[] sum) {
		for(int i=0;i<4;i++)
		{
			if(mAmount[i]>sum[i])
				return false;
		}
		return true;
	}

}
