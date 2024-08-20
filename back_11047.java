package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_11047 {
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int sum=Integer.parseInt(input[1]);
		int now=0;
		int money[]=new int [n];
		for(int i=0;i<n;i++)
			money[i]=Integer.parseInt(id.readLine());
		int usedsu=0;
		for(int i=n-1;i>=0;i--)
		{
			if(money[i]>sum)
				continue;
			
			int sibal=sum/money[i];
			usedsu+=sibal;
			now=sibal*money[i];
			sum=sum-now;	
			if(sum==0)
			{
				System.out.println(usedsu);
				break;
			}
		}
	}
}
