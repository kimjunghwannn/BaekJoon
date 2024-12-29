package algo;

import java.io.*;
import java.util.*;
public class back_30501 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			String input=br.readLine();
			if(input.contains("s"))
			{
				System.out.println(input);
				break;
			}
				
		}
	}

}
