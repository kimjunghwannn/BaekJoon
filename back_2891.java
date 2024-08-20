package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2891 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int broke_n=Integer.parseInt(input[1]);
		int add_n=Integer.parseInt(input[2]);
		
		boolean check[]=new boolean [n+1];
		int broked[]=new int[broke_n];
		String input2[]=id.readLine().split(" ");
		for(int i=0;i<broke_n;i++)
			broked[i]=Integer.parseInt(input2[i]);
		String input3[]=id.readLine().split(" ");
		for(int i=0;i<add_n;i++)
			check[Integer.parseInt(input3[i])]=true;
		int answer=0;
		Arrays.sort(broked);
		boolean pass[]=new boolean[n+1];
		for(int i=0;i<broke_n;i++)
		{
			if(check[broked[i]])
			{	
				check[broked[i]]=false;
				pass[broked[i]]=true;
			}
		}
		for(int i=0;i<broke_n;i++)
		{
			if(pass[broked[i]])
				continue;
			if(check[broked[i]-1])
			{
				check[broked[i]-1]=false;
			}
			else if(broked[i]+1<n&&check[broked[i]+1]) {
				check[broked[i]+1]=false;
			}
			else {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
