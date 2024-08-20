package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_11382 {
	public static void main(String args[]) throws IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		System.out.println(Long.parseLong(input[0])+Long.parseLong(input[1])+Long.parseLong(input[2]));
		
	}
}
