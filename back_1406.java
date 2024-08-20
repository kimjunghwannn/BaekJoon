package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class back_1406 {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		Stack<Character> s = new Stack<>();
		for(int i=0; i<line.length(); i++) {
			s.push(line.charAt(i));
		}
		int m = Integer.parseInt(br.readLine());
		
		Stack<Character> dS= new Stack<>();
		for(int i=0;i<m;i++)
		{
			String order=br.readLine();
			if(order.equals("L"))
			{	
				if(!s.isEmpty())
					dS.push(s.pop());
			}
			else if(order.equals("D"))
			{
				if(!dS.isEmpty())
					s.push(dS.pop());
			}
			else if(order.equals("B"))
			{
				if(!s.isEmpty())
					s.pop();
			}
			else
			{
				char a=order.charAt(2);
				s.push(a);
			}
		}
		while(!s.isEmpty()) {
			dS.push(s.pop());
		}
		int size=dS.size();
		for(int i=0;i<size;i++)	
		{	bw.write(dS.pop());}	
		bw.flush();
		bw.close();
	}
	
	
}
