package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1059 {
	public static void main(String args[]) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		String nstr=id.readLine();
		int n=Integer.parseInt(nstr);
		String input[]=id.readLine().split(" ");
		int includesu=Integer.parseInt(id.readLine());
		int i;
		int gugan[]=new int[n];
		int number=0;
		for(i=0;i<n;i++)
			gugan[i]=Integer.parseInt(input[i]);
		Arrays.sort(gugan);
		
		for(i=0;i<n;i++)
			if(gugan[i]>=includesu)
				break;
		if(gugan[i]==includesu)
		{
			System.out.print(0);
			System.exit(0);
		}
		int k;
		if(i==0) k=1;
		else k=gugan[i-1]+1; 
		for(;k<=includesu;k++)
		{
			for(int j=includesu;j<gugan[i];j++)
			{	
				if(k==j)
					continue;
				number++;
			}
		}
		System.out.print(number);
	}
}
