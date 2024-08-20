package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class back_15649 {
	static boolean visited[];
	static int N;
	static int M;
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		visited=new boolean [N+1];
		Stack<Integer> a = new Stack<>();
		doing(0,a);
	}
	private static void doing( int n ,Stack<Integer> a) {
		if(M==n)
		{
			for(int i :a)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++)
		{
			if(visited[i])
				continue;
			visited[i]=true;
			a.push(i);
			doing(n+1,a);
			a.pop();
			visited[i]=false;
		}
	}
}
