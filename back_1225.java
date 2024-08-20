package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1225 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		String a=input[0];
		String b=input[1];
		long sum = 0;
		for(int i=0;i<a.length();i++)
			for(int j=0;j<b.length();j++)
			{
				sum+=(long) Character.getNumericValue(a.charAt(i))*Character.getNumericValue(b.charAt(j));
				
			}
		System.out.print(sum);
	} 
	
}
