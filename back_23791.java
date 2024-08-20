package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class back_23791 {

	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		int py=Integer.parseInt(input[2]);
		int px=Integer.parseInt(input[3]);
		int personx=((x-1)/(px+1))+1;
		int persony=((y-1)/(py+1))+1;
		System.out.print(personx*persony);
	}
}
