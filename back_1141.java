package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class back_1141 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader id= new BufferedReader (new InputStreamReader(System.in));
		String input=id.readLine();
		int n=Integer.parseInt(input);
		String words[]=new String[n];
		boolean checked[]=new boolean[n];
		int num=0;
		for(int i=0;i<n;i++)
		{	
			words[i]=id.readLine();
		}
		  Arrays.sort(words, Comparator.comparingInt(String::length));
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
			{
				if(words[j].startsWith(words[i])||words[i].startsWith(words[j]))
				{ 	checked[i]=true; break;}
			}
		
		for(int i=0;i<n;i++) 
		{	
			if(!checked[i])
				num++;
		}
		System.out.println(num);
}
	}
