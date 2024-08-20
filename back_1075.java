package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1075 {
	public static void main(String []args) throws IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		int n=Integer.parseInt(input);
		input=id.readLine();
		int f=Integer.parseInt(input);
		n/=10;
		n/=10;
		for(int i=0;i<=9;i++) {
			for(int j=0;j<=9;j++) {
					n*=10;
					n+=i;
					n*=10;
					n+=j;
				if(n%f==0)
				{
					System.out.println(i+""+j);
					System.exit(0);
				}
				n/=10;
				n/=10;
			}
			
			
		}
	}
}
