package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1987 {
	static boolean check[]=new boolean[26];
	static char map[][];
	static int max=0;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static boolean visited[][];
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader (System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		map=new char [y][x];
		visited=new boolean[y][x];
		for(int i=0;i<y;i++)
		{
			String input2=id.readLine();
			for(int j=0;j<x;j++)
			{
				map[i][j]=input2.charAt(j);
			}
		}
		visited[0][0]=true;
		check[map[0][0] - 'A']=true;
		Dfs(0,0,0);
		System.out.println(max+1);
	}
	private static void Dfs(int y, int x,int n) {
		for(int i=0;i<4;i++)
		{
			int cx=dx[i]+x;
			int cy=dy[i]+y;
			if(cx<0||cx>=map[0].length||cy<0||cy>=map.length)
				continue;
			if(visited[cy][cx]||check[map[cy][cx] - 'A'])
				continue;
			visited[cy][cx]=true;
			check[map[cy][cx] - 'A']=true;
			Dfs(cy,cx,n+1);
			visited[cy][cx]=false;
			check[map[cy][cx] - 'A']=false;
		}
		max=Math.max(max, n);
	}
}
