package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2303 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int max=0;
		int winner=0;
		for(int i=0;i<n;i++)
		{
			String input[]=id.readLine().split(" ");
			for(int j=0;j<5;j++)
				for(int k=j+1;k<5;k++)
					for(int l=k+1;l<5;l++)
					{
						int sum=Integer.parseInt(input[j])+Integer.parseInt(input[k])+Integer.parseInt(input[l]);
						sum=sum%10;
						if(sum>=max)
						{
							max=sum;
							winner=i+1;
						}
					}
		}
		System.out.println(winner);
	}
}
