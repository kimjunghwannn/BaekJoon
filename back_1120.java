package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1120 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		String a=input[0];	
		String b=input[1];
		int min=Integer.MAX_VALUE;
		int now=0;
		for(int i=0;i<=b.length()-a.length();i++)
		{
			for(int j=0;j<a.length();j++)
			{
				if(a.charAt(j)!=b.charAt(j+i))
					now++;
				
			}
			min=Math.min(min, now);
			now=0;
		}
		System.out.println(min);
	}
}
