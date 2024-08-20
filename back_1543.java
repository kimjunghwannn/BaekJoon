package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1543 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		String test=id.readLine();
		int answer=0;
		while(true) {
			int a=input.indexOf(test);
			if(a!=-1)
				{
					input=input.substring(a+test.length());
					answer++;
				}
			else
				break;
		}
		System.out.println(answer);
	}
}
