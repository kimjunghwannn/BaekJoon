package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1747 {
	private static final int MAX = 1003001;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		boolean[] arr;
		arr = new boolean[MAX+1];
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            int base = i;
            while ((base+=i) <= MAX) {
                arr[base] = true;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            
        	if (!arr[i] && !isPalindrome(i)) {
                arr[i] = true;
            }
        }
        
		
		for(int i=n;i<=1003001;i++)
		{
			if(!arr[i])
			{	
				System.out.println(i);
				System.exit(0);
			}
		}
	}
	private static boolean isPalindrome(int pn) {
		  String tmp = String.valueOf(pn);
	        for (int i = 0; i < tmp.length()/2; i++) {
	            if (tmp.charAt(i) != tmp.charAt(tmp.length()-1-i))
	                return false;
	        }
	        return true;
	}
}
