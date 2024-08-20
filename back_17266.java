package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_17266 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		int cm=Integer.parseInt(id.readLine());
		int n=Integer.parseInt(id.readLine());
		boolean road[]=new boolean [cm];
		int index[]=new int [n];
		String input[]=id.readLine().split(" ");
		int height=0;
		
		if(n==1)
		{
			height=Math.max(index[0], cm-index[0]);
		
		}
		else {
		for(int i=0;i<n;i++)
			index[i]=Integer.parseInt(input[i]);
		height=index[0];
		
		int nowindex=0;
		while(true) {
			if(nowindex==n-1)
			{if(index[nowindex]+height>=cm)
			{	
				break;
				
			}
			else {
				height=cm-index[nowindex];
				break;
			}
			}
			else {
			if(index[nowindex]+height<index[nowindex+1]-height)
			{	
				height++;
				continue;
			}
			else
			{
				nowindex++;
				continue;
			}
			}
		}
		}
		System.out.println(height);
	}
}
