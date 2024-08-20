package algo;

import java.io.*;
public class back_12865 
{
	static int K;
	static product products[];
	static int max=0;
	static int dp[];
	static class product
	{
		public int weight;
		public int value;
		public product(int weight,int value)
		{
			this.weight=weight;
			this.value=value;
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		K=Integer.parseInt(input[1]);
		products=new product[N];
		dp=new int [100000];
		for(int i=0;i<N;i++)
		{
			String input2[]=id.readLine().split(" ");
			int weight=Integer.parseInt(input2[0]);
			int value=Integer.parseInt(input2[1]);
			products[i]=new product(weight,value);
		}
		doing(0,0,0);
		System.out.println(max);
	}
	private static void doing(int index, int totalWeight, int totalValue) 
	{
		if(totalWeight>K||dp[totalWeight]>totalValue)
			return;
		dp[totalWeight]=Math.max(dp[totalWeight], totalValue);
		max=Math.max(max,totalValue);
		if(index==products.length)
			return;
		for(int i=index;i<products.length;i++)
		{
			doing(i+1,totalWeight+products[i].weight,totalValue+products[i].value);
		}
	}

}
