package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class back_1205 {
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int newScore=Integer.parseInt(input[1]);
		int rankers=Integer.parseInt(input[2]);
		int score[]=new int [n];
		int samesu=0;
		if(n==0)
		{
			System.out.print(1);
			System.exit(0);
		}
		HashMap<Integer,Integer> nowranke = new  HashMap<Integer,Integer>();
		
		String scores[]=id.readLine().split(" ");		
		for(int i=0;i<scores.length;i++)
			score[i]=Integer.parseInt(scores[i]);
		Arrays.sort(score);
		int su=1;
		
		for(int i=n-1;i>=0;i--)
		{
			
			nowranke.put(su, score[i]);
			if(i!=0)
			{
				if(score[i]==score[i-1])
				{samesu=1;	continue; }
			su=n-i+1;	
			samesu=0;}
		}
		if(samesu==1&&score[0]==newScore&&n>=rankers)
		{
			System.out.print(-1);
			System.exit(0);
		}
		for(Integer i: nowranke.keySet()) {
			if(i==rankers&&nowranke.get(i)>=newScore)
			{
				System.out.print(-1);
				System.exit(0);
			}
			if(nowranke.get(i)<=newScore)
				{
					System.out.print(i);
					System.exit(0);
				}
		}
		
		System.out.print(n+1);
		
			
	}
}
