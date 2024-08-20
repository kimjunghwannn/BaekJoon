package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_5585 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int price=Integer.parseInt(id.readLine());
		int money[]= {500,100,50,10,5,1};
		int answer=0;
		int nomoji=1000-price;
		for(int i=0;i<money.length;i++)
		{
			answer+=nomoji/money[i];
			nomoji=nomoji%money[i];
		}
		System.out.print(answer);
	}
}
