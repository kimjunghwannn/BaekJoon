package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class back_15989 {
	static int a[]= {1,2,3};
	static int su=0;
	static boolean three_store[]=new boolean [100001];
	static void check_this(int now,int target,int one_n,int two_n,int three_n) {
		
		if(now==target)
		{
			
			if(three_store[three_n])
				return;
			three_store[three_n]=true;
			su++;
			return;
		}
		if(now>target)
			return;
		for(int i=0;i<3;i++)
		{
			
				
			if(i==0)
			{	
				one_n++;
				check_this(now+a[i],target,one_n,two_n,three_n);
				one_n--;
			}
			else if(i==1) {
				two_n++;
				check_this(now+a[i],target,one_n,two_n,three_n);
				two_n--;
			}
			else {
				three_n++;
				check_this(now+a[i],target,one_n,two_n,three_n);
				three_n--;
			}
		}
	}
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(id.readLine());
		while(testcase-->0) {
			int n=Integer.parseInt(id.readLine());		
			check_this(0,n,0,0,0);
			System.out.println(su);
			su=0;
			Arrays.fill(three_store,false);
		}
	}
}
