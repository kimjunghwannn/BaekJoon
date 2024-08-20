package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2529 {
	static String box[];
	static long min=Long.MAX_VALUE;
	static long max=0;
	static boolean check[]=new boolean [10];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		box=id.readLine().split(" ");
		for(int i=0; i<10;i++)
		{	
			check[i]=true;
			doing(i,0,i+"");
			check[i]=false;
		}
		int checksu=1;
		for(int i=0;i<box.length;i++)
			checksu*=10;
		if(max<checksu)
			System.out.println(0+""+max);
		else
			System.out.println(max);
		if(min<checksu)
			System.out.println(0+""+min);
		else
			System.out.println(min);
	}
	private static void doing(int su, int index, String answer) 
	{	
		if(index==box.length)
		{
			if(max< Long.parseLong(answer))
				max= Long.parseLong(answer);
			if(min> Long.parseLong(answer))
				min= Long.parseLong(answer);
			return;
		}
		if(box[index].equals("<"))
		{
			for(int i=su+1;i<10;i++)
			{
				if(check[i])
					continue;
				check[i]=true;
				doing(i,index+1,answer+""+i);
				check[i]=false;
			}
		}
		else
		{
			for(int i=su-1;i>=0;i--)
			{
				if(check[i])
					continue;
				check[i]=true;
				doing(i,index+1,answer+""+i);
				check[i]=false;
			}
		}
		
	}
}
