package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1024 {
	public static void main(String args[]) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input[]=br.readLine().split(" ");
	    int n=Integer.parseInt(input[0]);
	    int l=Integer.parseInt(input[1]);
	    for(int i=l;i<=100;i++)
	    {	
	    	int challenge=0;
	    	int start=-1;
	    	
	    	while(challenge<n) {
	    		start++;
	    		challenge=0;
	    		for(int j=start;j<start+i;j++)
	    			challenge+=j;
	    		
	    	}
	    	
	    		
	    	if(challenge==n)
	    	{
	    		for(int k=start;k<start+i;k++)
	    		{
	    			System.out.print(k+" ");
	    		}
	    		System.exit(0);
	    	}
	    	if(start==0)
	    	{
	    		System.out.print("-1");System.exit(0);
	    	}
	    }
	     System.out.print("-1");

	}
}
