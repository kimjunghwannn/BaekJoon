package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class back_1038 {
	static ArrayList<Long> list;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		list=new ArrayList<>();
		if(n<=9) System.out.println(n);
		else if(n>1022) System.out.println(-1);
		else {
			for(int i=0;i<=9;i++)
				BP(i,1);
			Collections.sort(list);
			System.out.println(list.get(n));
		}
		
	}

	private static void BP(long number, int idx) {
		if(idx>10) return;
		list.add(number);
		for(int i=0;i<number%10;i++)
		{
			BP((number*10)+i,idx+1);
		}
	}
	

}