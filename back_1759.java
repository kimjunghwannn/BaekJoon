package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1759 {
	static int len;
	static String box[];
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		len=Integer.parseInt(input[0]);
		n=Integer.parseInt(input[1]);
		box=id.readLine().split(" ");
		Arrays.sort(box);
		
		for(int i=0;i<n;i++)
		{	
			doing(i,"");
		}
	}
	private static void doing(int index, String answer) {
		answer+=box[index];
		if(answer.length()==len)
		{
			int aeiou=0;
			for(int i=0;i<answer.length();i++)
			{
				if(answer.charAt(i)=='a'||answer.charAt(i)=='e'||answer.charAt(i)=='i'||answer.charAt(i)=='o'||answer.charAt(i)=='u')
					aeiou++;
			}
			if(aeiou==0||answer.length()-aeiou<2)
				return;
			System.out.println(answer);
			return;
		}
		
		for(int i=index+1;i<n;i++)
		{
			doing(i,answer);
		}
	}
}
