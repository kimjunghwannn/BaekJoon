package algo;

import java.util.*;
import java.io.*;
public class back_1992 
{
	static int Map[][];
	static String answer="";
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Map=new int [N][N];
		for(int i=0;i<N;i++)
		{
			String inputLine=br.readLine();
			for(int j=0;j<N;j++)
			{
				Map[i][j]=inputLine.charAt(j)-48;
			}
		}
		compressTree(0,0,N);
		System.out.println(answer);
	}
	private static String compressTree(int y,int x,int length) 
	{
			if(isCompress(y,x,length)||length==1)
			{
				return answer+=String.valueOf(Map[y][x]);
			}
			else
			{
				answer+="(";
				 compressTree(y,x,length/2); //왼쪽 위
				 compressTree(y,x+length/2,length/2); //오른쪽 위
				 compressTree(y+length/2,x,length/2); //왼쪽 아래
				 compressTree(y+length/2,x+length/2,length/2); //오른쪽 아래
				 answer+=")";
				 return answer;
			}
	}
	private static boolean isCompress(int y, int x,int length) 
	{
		int value=Map[y][x];
		for(int i=y;i<y+length;i++)
		{
			for(int j=x;j<x+length;j++)
			{
				if(Map[i][j]!=value)
					return false;
			}
		}
		return true;
	}
	
}
