package algo;

import java.io.*;
public class back_1915 
{
	static int map[][];
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		map=new int[n][m];
		int answer=0;
		int DP[][]=new int [n][m];
		if(n==1||m==1)
		{
			System.out.println(1);
			System.exit(0);
		}
		for(int i=0;i<n;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<m;j++)
			{
				map[i][j]=input2.charAt(j)-'0';
				if(map[i][j]==1)
				{
					if(i==0||j==0)
						DP[i][j]=1;
					else
						DP[i][j]=Math.min(Math.min(DP[i-1][j],DP[i][j-1]),DP[i-1][j-1])+1;
						
					answer=Math.max(answer,DP[i][j]);
				}
			}
		}
		System.out.println(answer*answer);
	}
	
}
