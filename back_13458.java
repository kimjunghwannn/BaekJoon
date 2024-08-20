package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_13458 {
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String input[]=id.readLine().split(" ");
		int students[]=new int[n];
		for(int i=0;i<n;i++)
			students[i]=Integer.parseInt(input[i]);
		String input2[]=id.readLine().split(" ");
		int boss=Integer.parseInt(input2[0]);
		int subboss=Integer.parseInt(input2[1]);
		long answer=n;
		for(int i=0;i<n;i++)
		{
			students[i]-=boss;
			if(students[i]<=0)
				continue;
			int a;
			a=students[i]/subboss;
			if(a==0)
				a=1;
			else if(students[i]%subboss>0)
				a++;
			answer+=a;
		}
		System.out.println(answer);
	}
}
