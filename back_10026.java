package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_10026 {
	static boolean check[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static char map[][];
	private static final Object lock = new Object();
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		map =new char[n][n];
		check=new boolean [n][n];
		for(int i=0;i<n;i++)
		{
			String input=id.readLine();
			for(int j=0;j<n;j++)
			{
				map[i][j]=input.charAt(j);
			}
		}
		int answer=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(!check[i][j])
				{
				synchronized(lock) 
					{
						check[i][j]=true;
						Dfs(i,j,map[i][j]);
						answer++;
					}
				}
			}
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				check[i][j]=false;
		int realanswer=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(!check[i][j])
				{
					synchronized(lock) 
					{
					check[i][j]=true;
					realDfs(i,j,map[i][j]);
					realanswer++;
					}
				}
			}
		}
		System.out.println(realanswer+" "+answer);
	}
	private static void realDfs(int y, int x,char a) {
		
		for(int i=0;i<4;i++)
		{
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cx>=check.length||cy<0||cy>=check.length)
				continue;
			if(check[cy][cx])
				continue;
			if(a==map[cy][cx])
			{
				check[cy][cx]=true;
				realDfs(cy,cx,a);
			}
		}
		
	}
	private static void Dfs(int y, int x,char a) {
		
		for(int i=0;i<4;i++)
		{
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cx>=check.length||cy<0||cy>=check.length)
				continue;
			if(check[cy][cx])
				continue;
			if(a==map[cy][cx])
			{
				check[cy][cx]=true;
				Dfs(cy,cx,a);
			}
			if((a=='R'&&map[cy][cx]=='G')||(a=='G'&&map[cy][cx]=='R'))
			{
				check[cy][cx]=true;
				Dfs(cy,cx,a);
			}
		}
		
	}
}
