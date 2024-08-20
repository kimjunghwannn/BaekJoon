package algo;

import java.io.*;
import java.util.Arrays;

public class back_4485 {
	static int DP[][];
	static int N;
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int count=1;
		while(true)
		{
			N=Integer.parseInt(id.readLine());
			
			if(N==0)
				break;
			DP=new int [N][N];
			for(int i=0;i<N;i++)
				Arrays.fill(DP[i], Integer.MAX_VALUE);
			int board[][]=new int [N][N];
			for(int i=0;i<N;i++)
			{
				String[] X=id.readLine().split(" ");
				for(int j=0; j<N;j++)
				{
					board[i][j]=Integer.parseInt(X[j]);
				}
			}
			
			System.out.println("Problem"+" "+count+": "+dobfs(board,0,0));
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
					System.out.println(i+" "+j+" "+DP[i][j]);
			}
			count++;
		}
	}
	public static int dobfs(int[][] board,int x,int y) 
	{
		
		if(x==N-1&&y==N-1)
		{
			return board[N-1][N-1];
		}
		if(DP[y][x]!=Integer.MAX_VALUE)
			return DP[y][x];
		for(int i=0;i<4;i++)
		{
			int cx;
			int cy;
			cx=x+dx[i];
			cy=y+dy[i];
			if(cx==N||cy==N||cx<0||cy<0)
				continue;
			DP[y][x]=Math.min(DP[y][x],dobfs(board,cx,cy)+board[y][x]);
		}
		return DP[y][x];
	}
}
