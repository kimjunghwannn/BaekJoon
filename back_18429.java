package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_18429 {
	static int box[];
	static boolean visited[];
	static int answer;
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		String input2[]=id.readLine().split(" ");
		box=new int[N];
		visited=new boolean [N];
		for(int i=0;i<N;i++)
			box[i]=Integer.parseInt(input2[i]);	
		doing(500,K,0);
		System.out.println(answer);
	}
	private static void doing(int nowKG,int minous,int days) {
		if(days==box.length)
		{
			answer++;
			return;
		}
		for(int i=0;i<box.length;i++)
		{
			if(visited[i]==true)
				continue;
			if(nowKG-minous+box[i]>=500)
			{
				visited[i]=true;
				doing(nowKG-minous+box[i],minous,days+1);
				visited[i]=false;
			}
			
		}
	}
}
