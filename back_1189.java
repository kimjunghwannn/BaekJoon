package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1189 {
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int count=0;
	public static void do_start(int nowx,int nowy,int map[][],int checksu,boolean visited[][],int K,int x,int y)
	{
		if(nowx==x-1&&nowy==0)
		{
			
			if(checksu==K)
				count++;
			return;	
		}
		int cx;
		int cy;
		for(int i=0;i<4;i++)
		{
			cx=nowx+dx[i];
			cy=nowy+dy[i];
			if(cx>x-1||cx<0||cy>y-1||cy<0)
				continue;
			if(visited[cy][cx]||map[cy][cx]==1)
				continue;
			visited[cy][cx]=true;
			do_start(cx,cy,map,checksu+1,visited,K,x,y);
			visited[cy][cx]=false;
		}
		
	}
	
	
	public static void main(String[]args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		int K=Integer.parseInt(input[2]);
		
		int map[][]=new int [y][x];
		boolean visited[][]=new boolean[y][x];
		for(int i=0;i<y;i++)
		{
			String inputs=id.readLine();
			for(int j=0;j<x;j++)
			{
				if(inputs.charAt(j)=='T')
					map[i][j]=1;	
			}
		}
		visited[y-1][0]=true;
		do_start(0,y-1,map,1,visited,K,x,y);
		System.out.println(count);
	}
}
