package algo;

import java.util.*;
import java.io.*;
public class back_1149 {
	static final int Red=0;
	static final int Green=1;
	static final int Blue=2;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());	
		int map[][]=new int [N][3];
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			for(int j=0;j<3;j++)
			{
				map[i][j]=Integer.parseInt(input[j]);
			}
		}
		
		int firstColor;
		int prevColor;
		int answer=Integer.MAX_VALUE;
		for(int i=0;i<3;i++)
		{
			firstColor=i;
			int dp[][]=new int [N][3];
			for(int j=0;j<3;j++)
			{
				if(j==firstColor)
					dp[1][j]=100000;
				else
					dp[1][j]=map[0][firstColor]+map[1][j];
				
			}
			for(int j=2;j<N-1;j++)
			{
				dp[j][0]=Math.min(dp[j-1][1], dp[j-1][2])+map[j][0];
				dp[j][1]=Math.min(dp[j-1][0], dp[j-1][2])+map[j][1];
				dp[j][2]=Math.min(dp[j-1][1], dp[j-1][0])+map[j][2];
			}
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					if(j==k||firstColor==k)
						continue;
					answer=Math.min(answer, dp[N-2][j]+map[N-1][k]);
				}
			}
		}
		System.out.println(answer);
	}
}
