package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class back_1935 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String a=id.readLine();
		Double numbers[]=new Double [n];
		for(int i=0;i<n;i++)
			numbers[i]=(double) Integer.parseInt(id.readLine());
		Deque<Double> st =  new LinkedList<>();
		int j=0;
	
		while(true) {
			if(j==a.length())
				break;
			if(a.charAt(j)=='*'||a.charAt(j)=='+'||a.charAt(j)=='-'||a.charAt(j)=='/'||a.charAt(j)=='%')
			{
				Double first=st.pop();
				Double second=st.pop();
				Double sum=0.0;
				if(a.charAt(j)=='*')
				{
					sum=first*second;
					st.push(sum);
				}
				if(a.charAt(j)=='+')
				{
					sum=first+second;
					st.push(sum);
				}
				if(a.charAt(j)=='-')
				{
					sum=second-first;
					st.push(sum);
				}
				if(a.charAt(j)=='/')
				{
					sum=second/first;
					st.push(sum);
				}
				if(a.charAt(j)=='%')
				{
					sum=second%first;
					st.push(sum);
				}
				
			}
			else {
				st.push(numbers[(a.charAt(j)-'A')]);
			
			}
			j++;
		}
		  System.out.printf("%.2f\n", st.pop());
		
		
		
	}
}
