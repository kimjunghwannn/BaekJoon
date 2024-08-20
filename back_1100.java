package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1100 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));;
		int map[][]=new int [8][8];
		int i;int j;
		for(i=0;i<8;i++)
		{
			String input=id.readLine();
			for(j=0;j<8;j++)
			{
				if(input.charAt(j)=='F')
					map[i][j]=1;
			}
		}
		int count=0;
		for(i=0;i<8;i++) 
		{
			if(i%2==0)
				j=0;
			else
				j=1;
			for(;j<8;j+=2)
			{
				if(map[i][j]==1)
				{	count++;}
			}	
		}
		System.out.println(count);
	}
}
