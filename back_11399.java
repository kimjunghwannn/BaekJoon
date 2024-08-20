package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_11399 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String input[]=id.readLine().split(" ");
		int person[]=new int [n];
		for(int i=0;i<n;i++)
			person[i]=Integer.parseInt(input[i]);
		Arrays.sort(person);
		int sum=0;
		int answer=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+person[i];
			answer+=sum;
		}
		
		System.out.println(answer);
	}
}
