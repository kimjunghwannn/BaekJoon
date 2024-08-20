package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class back_11724 {
	static boolean check[];
	static int N;
	static LinkedList<Integer>a[];
	public static void main(String []args) throws IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		a=new LinkedList[N+1];
		for(int i=1;i<=N;i++)
			a[i]=new LinkedList<>();
		for(int i=0;i<M;i++)
		{
			String input2[]=id.readLine().split(" ");
			int start=Integer.parseInt(input2[0]);
			int end=Integer.parseInt(input2[1]);
			a[start].add(end);
			a[end].add(start);
		}
		check=new boolean [N+1];
		int answer=0;
		for(int i=1;i<=N;i++)
		{
			if(check[i]==false)
			{	
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	private static void dfs(int start) {
		// TODO Auto-generated method stub
		for(int go:a[start])
		{
			if(check[go]==false)
			{
				check[go]=true;
				dfs(go);
			}
		}
	}
}
