package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class back_1213_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		HashSet<Character> alpa=new HashSet<>();
		int check[]=new int[26];
		int checkOdd=0;int i;
		char center='a';
		String answer=input;
		   StringBuilder stringBuilder = new StringBuilder(answer);
		for(i=0;i<input.length();i++)
		{
			check[input.charAt(i)-65]++;
			alpa.add(input.charAt(i));
		}
		 List<Character> list = new ArrayList<>(alpa);
		for(i=0;i<=25;i++)
		{
			
			if(check[i]%2==1)
				checkOdd++;
		}if(checkOdd>1)
			{
				System.out.print("I'm Sorry Hansoo");
				System.exit(0);
			}
		Collections.sort(list);	int start=0;
		for(i=0;i<list.size();i++)
		{
			
			if(check[list.get(i)-65]==0)
			{
				continue;
			}
			else if(check[list.get(i)-65]==1)
			{
				center=list.get(i);
				continue;
			}
			while(check[list.get(i)-65]>1) {
			stringBuilder.setCharAt(start, list.get(i));
			stringBuilder.setCharAt(input.length()-1-start, list.get(i));check[list.get(i)-65]-=2;
			start++;
			
			}
			if(check[list.get(i)-65]==1)
			{
				center=list.get(i);
				continue;
			}
		}
		if(input.length()%2==1)
		stringBuilder.setCharAt(input.length()/2, center);
			answer=stringBuilder.toString();
			System.out.print(answer);
		}
		
}
