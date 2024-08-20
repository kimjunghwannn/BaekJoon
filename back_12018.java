package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_12018 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		int needsu[]=new int [n];
		for(int i=0;i<n;i++)
		{
			String input2[]=id.readLine().split(" ");
			int another=Integer.parseInt(input2[0]);
			int deadline=Integer.parseInt(input2[1]);
			int another_score[]=new int[another];
			String scores[]=id.readLine().split(" ");
			for(int j=0;j<another;j++)
			{
				another_score[j]=Integer.parseInt(scores[j]);
			}
			Arrays.sort(another_score);
			if(deadline>another)
			{	
				needsu[i]=1;
				continue;
			}
			needsu[i]=another_score[another-deadline];
		}
		Arrays.sort(needsu);
		int answer=0;
		for(int i=0;i<n;i++)
		{
			if(m-needsu[i]<0)
				break;
			m-=needsu[i];
			answer++;
		}
		System.out.println(answer);
	}
}
