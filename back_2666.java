package algo;

import java.io.*;
import java.util.*;
public class back_2666 
{
	
	static int min=Integer.MAX_VALUE;
	static int n;
	static int num[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		String input[]=br.readLine().split(" ");
		int openA=Integer.parseInt(input[0]);
		int openB=Integer.parseInt(input[1]);
		
		int m=Integer.parseInt(br.readLine());
		num=new int [m];
		for(int i=0;i<m;i++)
			num[i]=Integer.parseInt(br.readLine());
		move(openA,openB,0,0);
		System.out.println(min);
	}
	private static void move(int openA, int openB, int sum, int index) 
	{
		if(index==num.length)
		{
			min=Math.min(sum, min);
			return;
		}
		
		int moveToOpenA=Math.abs(openA-num[index]);
		int moveToOpenB=Math.abs(openB-num[index]);
		
		move(num[index],openB,sum+moveToOpenA,index+1);
		move(openA,num[index],sum+moveToOpenB,index+1);
	}	
}
