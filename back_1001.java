package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1001 {
	public static void main(String []args) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int a=Integer.parseInt(input[0]);
		int b=Integer.parseInt(input[1]);
		System.out.println(a-b);
	}
}
