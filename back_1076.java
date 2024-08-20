package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1076 {
	public static void main(String []args) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		String first=id.readLine();
		String second=id.readLine();
		String third=id.readLine();
		String answer="";
		String test = null;
		for(int i=0;i<2;i++)
		{
			
			if(i==0)
				test=first;
			else
				test=second;
			if(i==0&&test.equals("black"))
				continue;
			else if(test.equals("black"))
				answer+="0";
			else if(test.equals("brown"))
				answer+="1";
			else if(test.equals("red"))
				answer+="2";
			else if(test.equals("orange"))
				answer+="3";
			else if(test.equals("yellow"))
				answer+="4";
			else if(test.equals("green"))
				answer+="5";
			else if(test.equals("blue"))
				answer+="6";
			else if(test.equals("violet"))
				answer+="7";
			else if(test.equals("grey"))
				answer+="8";
			else if(test.equals("white"))
				answer+="9";
		}
		test=third;
		if(!answer.equals("0"))
		{	
		if(test.equals("brown"))
			answer+="0";
		else if(test.equals("red"))
			answer+="00";
		else if(test.equals("orange"))
			answer+="000";
		else if(test.equals("yellow"))
			answer+="0000";
		else if(test.equals("green"))
			answer+="00000";
		else if(test.equals("blue"))
			answer+="000000";
		else if(test.equals("violet"))
			answer+="0000000";
		else if(test.equals("grey"))
			answer+="00000000";
		else if(test.equals("white"))
			answer+="000000000";}
		System.out.println(answer);
	}
}
