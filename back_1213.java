package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class back_1213 {
	static String answer=null;
	static void do_back(int check[],HashSet<Character> alpa,String example,int length) {
		if(example.length()==length)
		{
			for(int i=0;i<(example.length()/2);i++)
			{
				if(example.charAt(i)!=example.charAt(length-i-1))
					return;
			}
			if(answer==null||example.compareTo(answer)<0)
				answer=example;	
		}
		 for (char item : alpa) {
	         if(check[item-65]==0)
	        	 continue;
			 	example+=item;
			 	check[item-65]--;
			 	do_back(check,alpa,example,length);
			 	int lastindex=example.lastIndexOf(item);
			 	example=example.substring(0,lastindex);
			 	check[item-65]++;
	        }
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		HashSet<Character> alpa=new HashSet<>();
		int check[]=new int[26];
		for(int i=0;i<input.length();i++)
		{
			check[input.charAt(i)-65]++;
			alpa.add(input.charAt(i));
		}
		
		
		do_back(check,alpa,"",input.length());
		if(answer==null)
			System.out.println("I'm Sorry Hansoo");
		else
		System.out.println(answer);
	}
}
