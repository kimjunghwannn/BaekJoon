package algo;

import java.io.*;
import java.util.*;
public class back_2216 
{
	static int DP[][];
	static String X;
	static String Y;
	static int a;
	static int b;
	static int c;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		a=Integer.parseInt(input[0]);
		b=Integer.parseInt(input[1]);
		c=Integer.parseInt(input[2]);
		
		X=br.readLine();
		Y=br.readLine();
		DP=new int [X.length()+1][Y.length()+1];
		
	}
	
}
