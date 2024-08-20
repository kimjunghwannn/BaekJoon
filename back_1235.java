package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1235 {
	public static void main(String []args) throws IOException {
		 BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		 String input=id.readLine();
		 int n=Integer.parseInt(input);
		 int i,j;
		 String number[]=new String[n];
		 int answer=0;
		 for(i=0;i<n;i++)
			 number[i]=id.readLine();
		 for(i=0;i<n;i++)
			 for(j=i+1;j<n;j++)
			 {
				 int size=number[j].length();
				 while(size>0) {
					 
					 if(number[i].charAt(size-1)!=number[j].charAt(size-1))
					 {
						 if(answer<number[j].length()-size+1)
						 {
							answer=number[j].length()-size+1;} 
						 break;
					 }
					 size--;
				 }
			 }
		 System.out.println(answer);
	}
}
