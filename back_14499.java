package algo;

import java.io.*;
import java.util.*;
public class back_14499 
{
	static int dice[]= new int [7];
	static int map[][];
	static int dy[]= {0,0,-1,1};
	static int dx[]= {1,-1,0,0};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		int diceY=Integer.parseInt(input[2]);
		int diceX=Integer.parseInt(input[3]);
		int K=Integer.parseInt(input[4]);
		
		map=new int[n][m];
		
		for(int i=0;i<n;i++)
		{
			String inputLine[]=br.readLine().split(" ");
			for(int j=0;j<m;j++)
			{
				map[i][j]=Integer.parseInt(inputLine[j]);
			}
		}
		String input2[]=br.readLine().split(" ");
		int inputK[]=new int [K];
		for(int i=0;i<K;i++)
			inputK[i]=Integer.parseInt(input2[i]);
		for(int i=0;i<K;i++)
		{
			int cy=diceY+dy[inputK[i]-1];
			int cx=diceX+dx[inputK[i]-1];
			if(cy<0||cy>=n||cx<0||cx>=m)
			{	
				//System.out.println("?");
				continue;
			}
			if(inputK[i]==4)
			{
				int tmp=0;
				tmp=dice[1];
				dice[1]=dice[2];
				dice[2]=dice[6];
				dice[6]=dice[5];
				dice[5]=tmp;
			}
			if(inputK[i]==3)
			{
				int tmp=0;
				tmp=dice[2];
				dice[2]=dice[1];
				dice[1]=dice[5];
				dice[5]=dice[6];
				dice[6]=tmp;
				
			}
			if(inputK[i]==2)
			{
				int tmp=0;
				tmp=dice[1];
				dice[1]=dice[3];
				dice[3]=dice[6];
				dice[6]=dice[4];
				dice[4]=tmp;
			}
				
			if(inputK[i]==1)
			{
				int tmp=0;
				tmp=dice[1];
				dice[1]=dice[4];
				dice[4]=dice[6];
				dice[6]=dice[3];
				dice[3]=tmp;
				
			}
			
			
			if(map[cy][cx]!=0)
			{	
				dice[6]=map[cy][cx];
				map[cy][cx]=0;
			}
			else
			{
				map[cy][cx]=dice[6];
			}
			
				
			diceY=cy;
			diceX=cx;
			System.out.println(dice[1]);
		}
	}

}
