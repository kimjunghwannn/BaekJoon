package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bak_1015 {
	public static void main(String []args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    int real[]=new int[n];
	    int anwer[]=new int[n];
	    int i;
	    String input[]=br.readLine().split(" ");
	    int map[]=new int[1001];
	    for(i=0;i<n;i++)
	    {
	    	real[i]=Integer.parseInt(input[i]);
	    	anwer[i]=Integer.parseInt(input[i]);
	    	
	    }
	    Arrays.sort(anwer);
	    for(i=0;i<n;i++)
	    {
	    	for(int j=0;j<n;j++)
	    	{
	    		if(real[i]==anwer[j])
	    		{
	    			System.out.print(map[real[i]]+j+" ");
	    			map[real[i]]++;
	    			break;
	    		}
	    	}
	    }
	}
}
