package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1449 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		float l = Float.parseFloat(input[1]);
		int  box[]=new int [n];
		String input2[]=id.readLine().split(" ");
		for(int i=0;i<n;i++)
			box[i]=Integer.parseInt(input2[i]);
		Arrays.sort(box);
		int l_n=0;
		float real=l;
		boolean check[]=new boolean[1001];
		for(int i=0;i<n;i++)
		{
			if(check[box[i]])
				continue;
			for(int j=box[i];j<box[i]+l;j++)
			{
				if(j>1000)
					break;
				check[j]=true;
				
			}l_n++;
		}
		System.out.println(l_n);
	}
}
