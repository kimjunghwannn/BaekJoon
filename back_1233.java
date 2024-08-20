package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1233 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int first=Integer.parseInt(input[0]);
		int second=Integer.parseInt(input[1]);
		int third=Integer.parseInt(input[2]);
		int score[]=new int[81];
		for(int i=1;i<=first;i++)
			for(int j=1;j<=second;j++)
				for(int k=1;k<=third;k++)
				{
					score[i+j+k]++;
					
				}
		int max=score[0];
		int index=0;
		for(int i=1;i<=80;i++)
		{
			if(score[i]>max)
			{
				max=score[i];
				index=i;
			}
		}
		System.out.print(index);
	}
}
