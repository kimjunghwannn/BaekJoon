package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1051 {
	public static void main(String []args) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		int map[][]=new int [y][x];
		int i,j;
		for(i=0;i<y;i++)
		{
			String input2=id.readLine();
			for(j=0;j<x;j++)
			{
				map[i][j]=input2.charAt(j);
			}
		}
		int difference = (x < y) ? x : y;
		while(difference>1)
		{	
			for(i=0;i<=y-difference;i++)
				for(j=0;j<=x-difference;j++)
				{
					if (map[i][j] == map[i + difference - 1][j] &&
						    map[i][j] == map[i][j + difference - 1] &&
						    map[i][j] == map[i + difference - 1][j + difference - 1]) {
						    System.out.println(difference*difference);
						    System.exit(0);
						}
				}
			difference--;
		}
		System.out.println(1);
	}
}
