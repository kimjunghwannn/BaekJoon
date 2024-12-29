package algo;


import java.io.*;
import java.util.*;
public class back_1577 
{
	static class BlockLine
	{
		int startX;
		int startY;
		int endX;
		int endY;
		
		public BlockLine(int startX,int startY,int endX,int endY)
		{
			this.startX=startX;
			this.startY=startY;
			this.endX=endX;
			this.endY=endY;
		}
	}
	static BlockLine bLineArray[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new  BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		
		int K=Integer.parseInt(br.readLine());
		bLineArray=new BlockLine [K];
		long dp[][]=new long [M+1][N+1];
		for(int i=0;i<K;i++)
		{	
			String input2[]=br.readLine().split(" ");
			int startX=Integer.parseInt(input2[0]);
			int startY=Integer.parseInt(input2[1]);
			int endX=Integer.parseInt(input2[2]);
			int endY=Integer.parseInt(input2[3]);
			if(startX>endX)
			{
				int tmp;
				tmp=startX;
				startX=endX;
				endX=tmp;
			}
			if(startY>endY)
			{
				int tmp;
				tmp=startY;
				startY=endY;
				endY=tmp;
			}
			bLineArray[i]=new BlockLine(startX,startY,endX,endY);
		}
		dp[0][0]=1;
		
		for(int i=0;i<=M;i++)
		{
			for(int j=0;j<=N;j++)
			{
				if(j>0&&check(j-1,i,j,i))
					dp[i][j]+=dp[i][j-1];
				if(i>0&&check(j,i-1,j,i))//startX,startY,endX,endY
					dp[i][j]+=dp[i-1][j];
			}
		}
		System.out.println(dp[M][N]);
		
	}
	private static boolean check(int startX, int startY,int endX, int endY ) 
	{
		for(int i=0;i<bLineArray.length;i++)
		{
			if(bLineArray[i].endX==endX&&bLineArray[i].endY==endY&&
			   bLineArray[i].startX==startX&&bLineArray[i].startY==startY)
					return false;
				
		}
		return true;
	}
}
