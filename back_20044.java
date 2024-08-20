package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_20044 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int power[]=new int [n*2];
		String input[]=id.readLine().split(" ");
		for(int i=0;i<n*2;i++)
			power[i]=Integer.parseInt(input[i]);
		Arrays.sort(power);
		int answer[]=new int [n];
		for(int i=0;i<n;i++)
		{
			answer[i]=power[i]+power[n*2-i-1];
		}
		Arrays.sort(answer);
		System.out.println(answer[0]);
	}
}
