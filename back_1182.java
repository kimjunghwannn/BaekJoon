package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class back_1182 {
	
	public static int sum;
	public static int count;
	public static void last_check(LinkedList<Integer> is) {
		int s=0;
		for(int i :is)
			s+=i;
		if(s==sum)
			count++;
	}
	public static void check_sum(LinkedList<Integer> is,int jungsu[],int start) {
		for(int i=start;i<jungsu.length;i++)
		{
			is.add(jungsu[i]);
			last_check(is);
			check_sum(is,jungsu,i+1);
			is.removeLast();
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		sum=Integer.parseInt(input[1]);
		String input2[]=id.readLine().split(" ");
		int jungsu[]=new int [n];
		LinkedList<Integer> is= new LinkedList<>();
		for(int i=0;i<n;i++)
			jungsu[i]=Integer.parseInt(input2[i]);
		check_sum(is,jungsu,0);	
		System.out.println(count);
	}
}
