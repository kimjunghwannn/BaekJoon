package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bak_1181_1 {
	static void buble(String words[],int size) {
		String temp;
		    for (int i = 0; i < size - 1; i++) {
		        for (int j = 0; j < size - i - 1; j++) {
		        	if (words[j].length() > words[j + 1].length()){
		                temp = words[j];
		                words[j] = words[j + 1];
		                words[j + 1] = temp;
		            }
		            else if(words[j].length()==words[j+1].length())
		            {
				if(words[j].compareTo(words[j+1])>0)
				{	 temp = words[j];
				   words[j]= words[j + 1];
				   words[j + 1] = temp;}
		            }
		        }
		    }
			
	        }
	            
	
	public static void main(String []args) throws IOException {
		int n;int i;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n=Integer.parseInt(br.readLine());
	    String words[]=new String[n];
	    for(i=0;i<n;i++)
	    	words[i]=br.readLine();
	    buble(words,n);
	    
	    for(i=0;i<n;i++)
	    {	
	    	if(i!=n-1)
	    	{
	    		if(words[i].equals(words[i+1]))
	    			continue;
	    		
	    	}
	    	
	    	System.out.println(words[i]);
	    }	
	}
}
