package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_17615 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String balls=id.readLine();
		Queue<String> queue=new LinkedList<>();
		//빨간색 오른쪽
		int answer=Integer.MAX_VALUE;
		int count=0;
		for(int i=0;i<balls.length();i++)
		{
			if(balls.charAt(i)=='R')
			{
				queue.add("R");
			}
			else
			{
				count+=queue.size();
				queue.clear();
			}
		}
		queue.clear();
	   answer=Math.min(answer, count);
	   count=0;
	   //빨간색 왼쪽
		for(int i=balls.length()-1;i>=0;i--)
		{
			if(balls.charAt(i)=='R')
			{
				queue.add("R");
			}
			else
			{
				count+=queue.size();
				queue.clear();
			}
		}
		queue.clear();
	   answer=Math.min(answer, count);
	   
	   count=0;
	   //파란색 왼쪽
		for(int i=balls.length()-1;i>=0;i--)
		{
			if(balls.charAt(i)=='B')
			{
				queue.add("R");
			}
			else
			{
				count+=queue.size();
				queue.clear();
			}
		}
		queue.clear();
	   answer=Math.min(answer, count);
	   count=0;
		for(int i=0;i<balls.length();i++)
		{
			if(balls.charAt(i)=='B')
			{
				queue.add("R");
			}
			else
			{
				count+=queue.size();
				queue.clear();
			}
		}
	   answer=Math.min(answer, count);
	   System.out.println(answer);
	}
}
