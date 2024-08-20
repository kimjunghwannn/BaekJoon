package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2195 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String a=id.readLine();
		String b=id.readLine();
		int index=0;
		String c="";
		String before="";
		int answer=0;
		while(b.length()>0) {
			if(index==b.length())
			{
				answer++;
				break;
			}
			before=c;
			c+=b.charAt(index++);
			
			if(!a.contains(c))
			{
				answer++;
				int startindex=b.indexOf(before);
				 b = b.substring(0, startindex) + b.substring(startindex + before.length(), b.length());
				c="";
				before="";
				index=0;
			}
		}
		System.out.println(answer);
	}
}
