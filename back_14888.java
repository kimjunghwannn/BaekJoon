package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.script.ScriptException;

public class back_14888 {
	static int operator[]=new int[4];
	static long high= Integer.MIN_VALUE;
	static long low=Integer.MAX_VALUE;
	static int size;
	static String input[];
	public static void main(String args[]) throws NumberFormatException, IOException, ScriptException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());	
		input=id.readLine().split(" ");
		String input2[]=id.readLine().split(" ");
		size=input.length;
		for(int i=0;i<4;i++)
			operator[i]=Integer.parseInt(input2[i]);
		doit(0,0,0,0,Long.parseLong(input[0]),1);
		System.out.println(high);
		System.out.println(low);
	}
	private static void doit(int pul, int ma, int goq, int na, long sum, int index) throws ScriptException {
		if(index==size)
		{
			if(sum>high)
				high=sum;
			if(low>sum)
				low=sum;
		}
		for(int i=0;i<4;i++)
		{
			
			if(i==0) {
				if(operator[i]-pul==0)
					continue;
				long result=sum+Long.parseLong(input[index]);
				doit(pul+1,ma,goq,na,result,index+1);
			}
			else if(i==1)
			 {
				if(operator[i]-ma==0)
					continue;
				long result=sum-Long.parseLong(input[index]);
				doit(pul,ma+1,goq,na,result,index+1);
			}
			else if(i==2) {
				if(operator[i]-goq==0)
					continue;
				long result=sum*Long.parseLong(input[index]);
				doit(pul,ma,goq+1,na,result,index+1);
			}	
			else {
				if(operator[i]-na==0)
					continue;
				long result=sum/Long.parseLong(input[index]);
				doit(pul,ma,goq,na+1,result,index+1);
			}
			
			
				
		}
	}
}
