package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1019 {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    int number[]=new int[1000000000];
	    int su;
	    for(int i=1;i<=n;i++)
	    {
	    	su=i;
	    	while(su/10!=0) {
	    		number[su%10]++;
	    		su=su/10;		
	    	}
	    	number[su]++;
	    }
	    for(int i=0;i<=n;i++)
	    	System.out.print(number[i]+" ");
	}
}
