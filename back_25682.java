package algo;

import java.io.*;
import java.util.*;
public class back_25682 
{
	static int min=Integer.MAX_VALUE;
	static int K;
	static int count[][][];
	static int DP[][][];	
	static char map[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		K=Integer.parseInt(input[2]);
		DP=new int [2][N+1][M+1];
		count=new int [2][N+1][M+1];
		map=new char [N][M];
		char bMap[][]=new char [N][M];
		char wMap[][]=new char [N][M];
		char values[]= {'B','W'};
		for(int i=0;i<N;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j]=input2.charAt(j);
			}
		}
		fillMap(bMap,0);
		fillMap(wMap,1);
		compareMap(bMap,0);
		compareMap(wMap,1);
		fillDP(0);
		fillDP(1);
		for(int i=1;i<=N+1-K;i++)
		{
			for(int j=1;j<=M+1-K;j++)
			{
				min=Math.min(min, ((DP[0][i+K-1][j+K-1]-DP[0][i-1][j+K-1])-DP[0][i+K-1][j-1])+DP[0][i-1][j-1]);
				min=Math.min(min, ((DP[1][i+K-1][j+K-1]-DP[1][i-1][j+K-1])-DP[1][i+K-1][j-1])+DP[1][i-1][j-1]);
			}
		}
		
		System.out.println(min);
	}

	private static void fillDP(int index) 
	{
		for(int i=1;i<=map[0].length;i++)
		{	
			DP[index][1][i]+=DP[index][1][i-1]+count[index][1][i];
		}
		for(int i=1;i<=map.length;i++)
		{	
			DP[index][i][1]+=DP[index][i-1][1]+count[index][i][1];
		}
		for(int i=1;i<=map.length;i++)
		{
			for(int j=1;j<=map[0].length;j++)
			{
				DP[index][i][j]=DP[index][i-1][j]+DP[index][i][j-1]-DP[index][i-1][j-1]+count[index][i][j];
			}
		}
	}

	private static void compareMap(char[][] compareMap,int index) {
		
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				if(map[i][j]!=compareMap[i][j])
					count[index][i+1][j+1]=1;
			}
		}
		
	}

	private static void fillMap(char[][] map, int startValue) 
	{
		char values[]= {'B','W'};
		
		for(int i=0;i<map.length;i++)
		{
			char start=values[(i+startValue)%2];
			for(int j=0;j<map[0].length;j++)
			{
				map[i][j]=start;
				if(start=='B')
					start='W';
				else
					start='B';
			}
		}
	}

}
