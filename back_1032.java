package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1032 {
	public static void main(String []args) throws IOException {
		BufferedReader id= new BufferedReader (new InputStreamReader(System.in));
		int n;
		String input=id.readLine();
		n=Integer.parseInt(input);
		String first=id.readLine();
		String second;
		char a[]=new char[first.length()];
		char b[]=new char[first.length()];
		a=first.toCharArray();
		for(int i=0;i<n-1;i++)
			{
				second=id.readLine();
				
				b=second.toCharArray();
				for(int j=0;j<first.length();j++)
				{
					if(a[j]!=b[j])
						a[j]='?';
				}
			}
		first=String.valueOf(a);
		System.out.print(first);
		}
}
