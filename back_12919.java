package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class back_12919 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String S=id.readLine();
		String T=id.readLine();
		String reverse= new StringBuilder(S).reverse().toString();
		Queue<String> a = new LinkedList<>();
		boolean answer=false;
		if(T.contains(reverse)==false)
		{
			if(T.contains(S)==false)
			{
				System.out.println("0");
				System.exit(0);
			}
		}
		if(T.equals(S))
		{
			System.out.println("1");
			System.exit(0);
		}
		a.add(S);
		while(!a.isEmpty()) {
			String now=a.poll();
			String plusA=now+"A";
			String plusB=new StringBuilder(now+"B").reverse().toString();
			
			if(plusA.equals(T)||plusB.equals(T))
			{
					answer=true;
					break;
			}
			if(plusA.length()>=T.length())
					break;
			for(int i=0;i<2;i++)
			{
				String check=null;
				if(i==0)
					check=plusA;
				else
					check=plusB;
				if(T.contains(check)==false)
				{
					String reverse2= new StringBuilder(check).reverse().toString();
					if(T.contains(reverse2)==false)
					{
						continue;
					}
				}
				a.add(check);
			}
		}
		if(answer)
			System.out.println("1");
		else
			System.out.println("0");
	}
}
