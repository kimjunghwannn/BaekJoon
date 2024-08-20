package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_9655 {
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		if(n%2==0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
}
