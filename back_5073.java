package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_5073 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String inputcheck=id.readLine();
		String lastsu="0 0 0";
		while(!lastsu.equals(inputcheck)) {
			String input[]=inputcheck.split(" ");
			Arrays.sort(input);
			if(Integer.parseInt(input[2])>=Integer.parseInt(input[1])+Integer.parseInt(input[0]))
			{
				System.out.println("Invalid");
			}
			else if((input[0].equals(input[1])&&!input[1].equals(input[2]))||(input[1].equals(input[2])&&!input[1].equals(input[0]))||
					(input[0].equals(input[2])&&!input[0].equals(input[1])))  
			{
				System.out.println("Isosceles");
			}
			else if(input[0].equals(input[1])&&input[1].equals(input[2]))
			{
				System.out.println("Equilateral");
			}
			else {
				System.out.println("Scalene");
			}
			inputcheck=id.readLine();
		}
	}
}
