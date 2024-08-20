package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1246 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int egg=Integer.parseInt(input[0]);
		int n=Integer.parseInt(input[1]);
		int price[]=new int [n];
		int high=0;
		int start=0;
		int sellsu=0;
		for(int i=0;i<n;i++)
		{
			price[i]=Integer.parseInt(id.readLine());
		}
		Arrays.sort(price);
		if(n-egg>0)
			start=n-egg;
		else
			egg=n;
		high=price[start]*egg;
		sellsu=price[start];
		for(int i=start;i<price.length-1;i++) {
			if(high<price[i+1]*(egg-1))
				{high=price[i+1]*(egg-1);sellsu=price[i+1];}
			egg--;
		}
		System.out.print(sellsu+" "+high);
	}
}
