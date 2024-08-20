package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class back_1260 {
	static LinkedList<Integer> maps[];
	static boolean check[];
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String input[]=	id.readLine().split(" ");
		int nodesu=Integer.parseInt(input[0]);
		int linesu=Integer.parseInt(input[1]);
		int start=Integer.parseInt(input[2]);
		maps=new LinkedList[nodesu+1];
		for(int i=1;i<=nodesu;i++)
			maps[i]=new LinkedList<>();
		for(int i=0;i<linesu;i++)
		{
			String input2[]=id.readLine().split(" ");
			int a=Integer.parseInt(input2[0]);
			int b=Integer.parseInt(input2[1]);
			maps[a].add(b);
			maps[b].add(a);
		}
		check=new boolean [nodesu+1];
		for(int i=1;i<=nodesu;i++)
			Collections.sort(maps[i]);
		
		dfs(start);
		System.out.println();
		Arrays.fill(check, false);
		Queue<Integer> a=new LinkedList<>();
		check[start]=true;
		System.out.print(start+" ");
		a.add(start);
		while(!a.isEmpty()) {
			int now=a.poll();
			
			for(int i: maps[now])
			{
				if(check[i])
					continue;
				a.add(i);
				System.out.print(i+" ");
				check[i]=true;
			}
		}
	}

	private static void dfs(int start) {
		if(check[start])
			return;
		check[start]=true;
		System.out.print(start+" ");
		for(int a : maps[start])
		{
			dfs(a);
		}
	}
}
