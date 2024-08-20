package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_11501 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		int testcase=Integer.parseInt(id.readLine());
		while(testcase-->0) {
			int day=Integer.parseInt(id.readLine());
			int dayvalue[]=new int[day];
			String input[]=id.readLine().split(" ");
			
			for(int i=0;i<day;i++)
			{	
				dayvalue[i]=Integer.parseInt(input[i]);	
			}
		
			long answer=0;
			int max_value=0;
			for(int i=day-1;i>=0;i--)
			{
				max_value=Math.max(max_value, dayvalue[i]);
				answer+=max_value-dayvalue[i];
			}
			System.out.println(answer);
		}
		
	}
}
