package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2661 {
	
	static int n;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(id.readLine());
		doing("1","1");
		doing("2","1");
		doing("3","1");
	}
	private static void doing(String plus,String now) {
		now+=plus;
		int size=0;
		int how=now.length()/2;
		if(now.length()%2!=0)
			how++;
		for(int i=now.length()-1;i>=how;i--)
		{
			if(now.substring(i).equals(now.substring(i-1-size,i)))
				return;
			size++;
		}
		if(n==now.length())
		{
			System.out.println(now);
			System.exit(0);			
		}
		for(int i=1;i<=3;i++)
		{
			doing(Integer.toString(i),now);
		}
	}
}
