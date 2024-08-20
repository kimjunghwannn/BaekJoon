package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2531 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader (System.in));	
		String input[]=id.readLine().split(" ");
		int n_dishes=Integer.parseInt(input[0]);
		int dishes_many=Integer.parseInt(input[1]);
		int eating_dishes=Integer.parseInt(input[2]);
		int number=Integer.parseInt(input[3]);
		int dishes[]=new int [n_dishes];
		boolean check[]=new boolean[dishes_many+1];
		for(int i=0;i<n_dishes;i++) {
			dishes[i]=Integer.parseInt(id.readLine());
		}
		int max=0;
		for(int i=0;i<n_dishes;i++)
		{
			int count=0;
			boolean use_cu=false;
			for(int j=i;j<i+eating_dishes;j++)
			{
				if(dishes[j%n_dishes]==number)
					use_cu=true;
				if(check[dishes[j%n_dishes]])
					continue;
				check[dishes[j%n_dishes]]=true;
				count++;
			}
			
			if(use_cu==false)
				count++;
			max=Math.max(max, count);
			Arrays.fill(check, false);
		}
		System.out.println(max);
	}
}
