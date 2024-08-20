package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_2138 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		String inputNow=id.readLine();
		String inputWant=id.readLine();
		boolean now[]=new boolean [inputNow.length()];
		boolean want[]=new boolean [inputWant.length()];
		fillState(want,inputWant);
		int answer=Integer.MAX_VALUE;
		for(int i=0;i<2;i++)
		{
			int count=0;
			fillState(now,inputNow);
			if(i==0)
			{	
				do_switch(0,now);
				count++;
			}
			for(int j=1;j<now.length;j++)
			{
				if(now[j-1]!=want[j-1])
				{	
					do_switch(j,now);
					count++;
				}
			}
			if(check(now,want))
			answer=Math.min(answer, count);
			
		}
		if(answer==Integer.MAX_VALUE)
			answer=-1;
		System.out.println(answer);
	}
	static public boolean check(boolean[]now,boolean[]want)
	{
		for(int i=0;i<now.length;i++)
		{
			if(now[i]!=want[i])
				return false;
		}
		return true;
	}
	static public void do_switch(int index,boolean[] now)
	{
		if(index==0)
		{
			now[0]=!now[0];
			now[1]=!now[1];
		}
		else if(index==now.length-1)
		{
			now[index]=!now[index];
			now[index-1]=!now[index-1];
		}
		else
		{
			now[index+1]=!now[index+1];
			now[index]=!now[index];
			now[index-1]=!now[index-1];
		}
	}
	
	
	static public void fillState(boolean[] lightBulb,String state)
	{
		for(int i=0;i<state.length();i++)
		{
			if(state.charAt(i)=='0')
				lightBulb[i]=false;
			else
				lightBulb[i]=true;
		}
	}
}
