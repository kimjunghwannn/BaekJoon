package algo;

import java.io.*;
import java.util.*;
public class back_14658 
{
	static class star
	{
		public int y;
		public int x;
		public star(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int width=Integer.parseInt(input[0]);
		int heigth=Integer.parseInt(input[1]);
		int sideLength=Integer.parseInt(input[2]);
		int starN=Integer.parseInt(input[3]);
		star starList[]=new star[starN];
		for(int i=0;i<starN;i++)
		{
			String input2[]=id.readLine().split(" ");
			starList[i]=new star(Integer.parseInt(input2[0]),Integer.parseInt(input2[1]));
		}
		for(int i=0;i<(heigth-sideLength)+1;i++)
		{
			for(int j=0;j<=width;j++)
			{
				
			}
		}
	}
}
