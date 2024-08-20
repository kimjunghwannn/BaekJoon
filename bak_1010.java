package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bak_1010 {
	
	static int briges[][]= new int [31][31];
	static int setbrige(int left, int right) {
		if(briges[left][right]!=0)
			return briges[left][right];
		if(left!=1)
		{
			for(int i=1;i<=right-left+1;i++)
			{
				briges[left][right]+= setbrige(left-1,right-i);
			}
			return briges[left][right];
		}
		
			briges[1][right]=right;
			return briges[1][right];
	}
	public static void main(String []args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    String input[];
	    int left;
	    int right;
	    while(n-->0) {
	    	input=br.readLine().split(" ");
	    	left=Integer.parseInt(input[0]);
	    	right=Integer.parseInt(input[1]);
	    	setbrige(left,right);
	    	System.out.println(briges[left][right]);
	    	
	    }
	    
	}
}
