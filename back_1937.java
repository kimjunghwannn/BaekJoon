package algo;


import java.io.*;
import java.util.*;
public class back_1937 
{
	static int map[][];
	static int dp[][];
	static int dy[]= {0,0,1,-1};
	static int dx[]= {1,-1,0,0};

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		map=new int [n][n];
		dp=new int [n][n];
		for(int i=0;i<n;i++)
		{
			String input[]=br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				map[i][j]=Integer.parseInt(input[j]);
			}
		}
		int min=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				min=Math.max(min,DFS(i,j));
			}
		}
		
		System.out.println(min+1);
	}
	private static int DFS(int y, int x) 
	{
		if(dp[y][x]!=0)
			return dp[y][x];
		for(int i=0;i<4;i++)
		{
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cx>=map.length||cy<0||cy>=map.length)
				continue;
			if(map[y][x]<map[cy][cx])
				dp[y][x]=Math.max(DFS(cy,cx)+1, dp[y][x]);
		}
		return dp[y][x];
	}
}
