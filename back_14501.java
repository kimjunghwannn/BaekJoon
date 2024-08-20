package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_14501 {
	static int money[];
	static int days[];
	static int high=0;
	static int n;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(id.readLine());
		money=new int[n+1];
		days=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			String input[]=id.readLine().split(" ");
			days[i]=Integer.parseInt(input[0]);
			money[i]=Integer.parseInt(input[1]);
		}
		doit(1,0);
		System.out.println(high);
	}
	private static void doit(int day, int sum) {
		if(day==n+1)
		{
			if(sum>high)
				high=sum;
		}
		for(int i=day;i<=n;i++)
		{
			if(i+days[i]<=n+1)
				doit(i+days[i],sum+money[i]);
		}
		if(sum>high)
			high=sum;
	}
}
