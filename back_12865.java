package algo;

import java.io.*;
public class back_12865 
{
	static int K;
	static product products[];
	static int max=0;
	static int dp[][];
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
		products=new product[N+1];
		dp=new int [N+1][1000001];
		for(int i=1;i<=N;i++)
		{
			String input2[]=id.readLine().split(" ");
			int weight=Integer.parseInt(input2[0]);
			int value=Integer.parseInt(input2[1]);
			products[i]=new product(weight,value);
		}
		int answer=0;
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=K;j++)
			{
				if(products[i].weight<=j)
				{
					
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-products[i].weight]+products[i].value);
					answer=Math.max(answer,dp[i][j]);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
				
			}
		}
		System.out.println(answer);
	}

}
