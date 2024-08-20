package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_20310 {
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		int one=0;
		int zero=0;
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)=='1')
				one++;
			else
				zero++;
		}
		one/=2;
		zero/=2;
		
		StringBuilder stringbuilder=new StringBuilder(input);
		int i=0;
		while(true) {
			
			if(one==0||i>=stringbuilder.length())
				break;
			if(stringbuilder.charAt(i)=='1')
				{
				
					one--;
					stringbuilder.deleteCharAt(i);
				}
			else {
				i++;
			}
		}
		
		i=stringbuilder.length()-1;
		while(true)
		{
			
			if(zero==0||i<0)
				break;
			if(stringbuilder.charAt(i)=='0')
				{
				
					zero--;
					stringbuilder.deleteCharAt(i);
				}
			else {
				i--;
			}
		}
		System.out.println(stringbuilder);
	}
}
