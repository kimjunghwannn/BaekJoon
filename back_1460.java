package algo;
import java.io.*;
import java.util.*;
public class back_1460 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int map[][]=new int [N][N];
		int DP[][][]=new int [2][N][N];
		for(int i=0;i<M;i++)
		{
			String input2[]=br.readLine().split(" ");
			int startX=Integer.parseInt(input2[0]);
			int startY=Integer.parseInt(input2[1]);
			int len=Integer.parseInt(input2[2]);
			int number=Integer.parseInt(input2[3]);
			for(int j=startX;j<startX+len;j++)
			{
				for(int k=startY;k<startY+len;k++)
				{
					map[j][k]=number;
				}
			}
		}
		DP[0][0][0]=1;
	}
}
