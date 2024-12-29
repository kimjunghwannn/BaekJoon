package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1034 {
	static int map[][];
	static int high;
	public static void main(String args[]) throws IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		for(int i=0;i<N;i++ )
		{
			String input2=id.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j]=input2.charAt(j)-'0';
			}
		}
		int K=Integer.parseInt(id.readLine());
		
	}
}
