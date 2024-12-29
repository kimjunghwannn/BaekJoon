package algo;

import java.util.*;
import java.io.*;
public class back_1107 {
	static int answer;
	static Map<Integer,Boolean> disabledButton;
	static LinkedList<Integer> channel;
	static int N;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		disabledButton=new HashMap<>();
		N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		if(M!=0)
		{
			String input[]=br.readLine().split(" ");
			for(int i=0;i<M;i++)
				disabledButton.put(Integer.parseInt(input[i]),true);
		}
		
		answer=Math.abs(N-100);
		
		for(int i=0;i<=9;i++)
		{	
			channel=new LinkedList<>();
			makeStartPoint();
		}
		System.out.println(answer);
	}
	private static void makeStartPoint() 
	{
		if(channel.size()==6)
		{
			int sum=0;
			int digitCount=100000;
			for(int a : channel)
			{
				sum+=a*digitCount;
				digitCount/=10;
			}
			String strSum=String.valueOf(sum);
			for(int i=0;i<strSum.length();i++)
			{
				if(disabledButton.get(strSum.charAt(i)-'0')!=null)
					return;
			}
			int buttonClick=strSum.length();
			answer=Math.min(answer, Math.abs(sum-N)+buttonClick);
			return;
		}
		for(int i=0;i<=9;i++)
		{
			channel.add(i);
			makeStartPoint();
			channel.remove(channel.size()-1);
		}
	}
}
