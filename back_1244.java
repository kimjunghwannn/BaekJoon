package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1244 {
	static boolean light[];
	static void boystduent(int start) {
		int plussu=start;
		while(start<=light.length-1) {
			light[start]=!light[start];
			start+=plussu;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException {
	BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
	int n=Integer.parseInt(id.readLine());
	light=new boolean[n+1];
	String input[]=id.readLine().split(" ");
	for(int i=1;i<=n;i++)
		{
			if(input[i-1].equals("1"))
				light[i]=true;
		}
	int studentn=Integer.parseInt(id.readLine());
	for(int i=0;i<studentn;i++)
	{
		String input2[]=id.readLine().split(" ");
		if(input2[0].equals("1"))
			boystduent(Integer.parseInt(input2[1]));
		else
			girlstudent(Integer.parseInt(input2[1]));
	}
		for(int i=1;i<=n;i++)
		{
			
			if(light[i])
			System.out.print(1+" ");
			else
				System.out.print(0+" ");
			if(i%20==0)
				System.out.println();
		}
	}
	private static void girlstudent(int start) {
		if(start==1)
		{	
			light[1]=!light[1];
			return;
		}
		int right=start;
		int left=start;
		while(true) {
			if(left-1<=0||right+1>light.length-1)
				break;
			if(light[left-1]!=light[right+1])
				break;
			right++;
			left--;
		}
		for(int i=left;i<=right;i++)
			light[i]=!light[i];
	}
}
