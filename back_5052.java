package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class back_5052 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		 
		 BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		 int testcase=Integer.parseInt(id.readLine());
		while(testcase-->0)
		{
			int n=Integer.parseInt(id.readLine());
			String map[]=new String[n];
			long min=Integer.MAX_VALUE;
			Map<String,Integer> bu=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				String num = id.readLine();
				min=Math.min(min, num.length());
                map[i] = num;
				bu.put(map[i], 1);
			}
			
			boolean check=false;
			for(int i=0;i<n;i++)
			{
				
				if(map[i].length()==min)
					continue;
				String a=map[i];
				int end=map[i].length()-1;
				while(a.length()>min) {
					a=map[i].substring(0, end);
					end--;
					if(bu.get(a)!=null)
					{
						check=true;
						break;
					}
				}
				if(check)
				{
					break;
				}
			}
			if(check)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}
