package algo;

import java.util.*;
import java.io.*;
public class back_11660 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		int map[][]=new int [n][n];
		int DP[][]=new int [n][n];
		for(int i=0;i<n;i++)
		{
			String input2[]=br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				map[i][j]=Integer.parseInt(input2[j]);
			}
		}
		
		DP[0][0]=map[0][0];
		for(int i=1;i<n;i++)
		{
			DP[0][i]=DP[0][i-1]+map[0][i];
		}
		for(int i=1;i<n;i++)
		{
			DP[i][0]+=DP[i-1][0]+map[i][0];
		}
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				DP[i][j]=((DP[i][j-1]+DP[i-1][j])-DP[i-1][j-1])+map[i][j];
			}
		}
	
		for(int i=0;i<m;i++)
		{
			String input3[]=br.readLine().split(" ");
			int startY=Integer.parseInt(input3[0])-1;
			int startX=Integer.parseInt(input3[1])-1;
			
			int endY=Integer.parseInt(input3[2])-1;
			int endX=Integer.parseInt(input3[3])-1;
			int sum=0;
			if(startX==0&&startY==0)
			{
				sum=DP[endY][endX];
			}
			else if(startY==0)
			{
				sum=DP[endY][endX]-DP[endY][startX-1];
				
			}
			else if(startX==0)
			{
				sum=DP[endY][endX]-DP[startY-1][endX];
			}
			else
				sum=((DP[endY][endX]-DP[endY][startX-1])-DP[startY-1][endX])+DP[startY-1][startX-1];
			System.out.println(sum);
		}
	}

}
