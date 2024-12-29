package algo;

import java.util.*;
import java.io.*;
public class back_2011 
{
	static String input;
	static int answer=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		input=br.readLine();
		int DP[]=new int [input.length()+1];
		DP[1]=1;
		boolean isZero[]=new boolean [input.length()+1];
		
		
		if(input.charAt(0)-'0'==0||(input.length()==2&&input.charAt(1)-'0'==0&&Integer.parseInt(input)>26))
		{
			System.out.println(0);
			System.exit(0);
		}
		
		
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)-'0'==0)
			{	
				isZero[i+1]=true;
				if(i>0&&(isZero[i]||input.charAt(i-1)-'0'>2))
				{
					System.out.println(0);
					System.exit(0);
				}
			}
			
		}
		for(int i=2;i<=input.length();i++)
		{
			DP[i]=DP[i-1];
			if(isZero[i]||isZero[i-1])
				continue;
			if(i+1<=input.length()&&isZero[i+1])
				continue;
			if(Integer.parseInt(input.substring(i-2, i))<=26)
			{
				if(i==2)
					DP[i]=2;
				else
					DP[i]=(DP[i]+DP[i-2])%1000000;
			}
		}
		System.out.println(DP[input.length()]%1000000);
	}
	
}
