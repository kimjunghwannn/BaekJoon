package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2816 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(id.readLine());
		int box[]=new int [a];
		Arrays.fill(box, -1);
		int first=0;
		int second=0;
		for(int i=0;i<a;i++)
		{
			String input=id.readLine();
			if(input.equals("KBS1"))
			{	
				box[i]=1;
				first=i;
			}
			if(input.equals("KBS2"))
			{	
				box[i]=2;
				second=i;
			}
		}
		String answer="";
		for(int i=0;i<first;i++)
			answer+="1";
		for(int i=0;i<first;i++)
			answer+="4";
		if(first>second)
			second++;
		for(int i=0;i<second;i++)
			answer+="1";
		for(int i=1;i<second;i++)
			answer+="4";
		System.out.println(answer);
	}
}
