package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class back_20437 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int tastcase=Integer.parseInt(id.readLine());
		while(tastcase-->0) {
			String test=id.readLine();
			int K=Integer.parseInt(id.readLine());
			int check[]=new int [26];
			int high=0;
			boolean visit[]=new boolean [test.length()];
			boolean minus=false;
			int low=Integer.MAX_VALUE;
			LinkedList<Integer> a[]=new LinkedList[26];
			for(int i=0;i<26;i++)
				a[i]=new LinkedList<>();
			for(int i=0;i<test.length();i++)
			{
				check[test.charAt(i)-97]++;
				a[test.charAt(i)-97].add(i);
				if(check[test.charAt(i)-97]==K)
				{
					minus=true;
					int start=a[test.charAt(i)-97].poll();
					
			
					int length=i-start+1;
					if(length>high)
						high=length;
					if(length<low)
						low=length;
					check[test.charAt(i)-97]--;
					visit[start]=true;
				}
			}
			if(minus)
			System.out.println(low+" "+high);
			else
				System.out.println("-1");
		}
	}
}
