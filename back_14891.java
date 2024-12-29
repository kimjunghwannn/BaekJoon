package algo;

import java.util.*;
import java.io.*;
public class back_14891 
{
	static int cogWheel[][];
	static boolean isdiff[][];
	static boolean visited[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		cogWheel=new int [4][8];
		int K;
		initializingCogWheel(br);
		K=Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=0;i<K;i++)
		{
			String input[]=br.readLine().split(" ");
			int cogWheelIndex=Integer.parseInt(input[0]);
			int direction=Integer.parseInt(input[1]);
			visited=new boolean [4];
			cogWheelIndex--;
			visited[cogWheelIndex]=true;
			
			checkDiff();
			doRotate(cogWheelIndex,direction);
		}
		sum+= cogWheel[0][0] == 0 ? 0 : 1;
		sum+= cogWheel[1][0] == 0 ? 0 : 2;
		sum+= cogWheel[2][0] == 0 ? 0 : 4;
		sum+= cogWheel[3][0] == 0 ? 0 : 8;
		
		System.out.println(sum);
	}
	static void checkDiff() 
	{
		isdiff=new boolean [4][4];
		
		for(int i=0;i<3;i++)
		{
			if(cogWheel[i][2]!=cogWheel[i+1][6])
			{
				isdiff[i][i+1]=true;
				isdiff[i+1][i]=true;
			}
		}
		
			
	}
	static void doRotate(int cogWheelIndex, int direction) 
	{
		int tmp;
		int nextDirection;
		if(direction==-1)
		{
			tmp=cogWheel[cogWheelIndex][0];
			for(int i=1;i<8;i++)
			{
				cogWheel[cogWheelIndex][i-1]=cogWheel[cogWheelIndex][i];
			}
			cogWheel[cogWheelIndex][7]=tmp;
			nextDirection=1;
		}
		else
		{
			tmp=cogWheel[cogWheelIndex][7];
			for(int i=7;i>=1;i--)
			{
				cogWheel[cogWheelIndex][i]=cogWheel[cogWheelIndex][i-1];
			}
			cogWheel[cogWheelIndex][0]=tmp;
			nextDirection=-1;
		}
		
		if(cogWheelIndex==0)
		{
			if(isPossibleRotate(0,1))
			{
				visited[1]=true;
				doRotate(1,nextDirection);
			}
		}
		if(cogWheelIndex==1)
		{
			if(isPossibleRotate(1,0))
			{
				visited[0]=true;
				doRotate(0,nextDirection);
			}
			if(isPossibleRotate(1,2))
			{
				visited[2]=true;
				doRotate(2,nextDirection);
			}
		}
		if(cogWheelIndex==2)
		{
			if(isPossibleRotate(2,1))
			{
				visited[1]=true;
				doRotate(1,nextDirection);
			}
			if(isPossibleRotate(2,3))
			{
				visited[3]=true;
				doRotate(3,nextDirection);
			}
		}
		if(cogWheelIndex==3)
		{
			if(isPossibleRotate(3,2))
			{
				visited[2]=true;
				doRotate(2,nextDirection);
			}
		}
	}
	static public boolean isPossibleRotate(int start,int end)
	{
		if(isdiff[start][end]&&!visited[end])
			{
				return true;
			}
		return false;
	}
	static public void initializingCogWheel(BufferedReader br) throws IOException
	{
		for(int i=0;i<4;i++)
		{
			String input=br.readLine();
			for(int j=0;j<input.length();j++)
			{
				cogWheel[i][j]=input.charAt(j)-'0';
			}
		}
	}
}
