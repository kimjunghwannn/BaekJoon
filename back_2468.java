package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2468 {
	static int depth[][];
	static boolean check[][];
	static int dy[] = { 0,0,-1,1 };
	static int dx[] = { -1,1,0,0 };
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		depth=new int[n][n];
		int max=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			String input[]=id.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				if(max<Integer.parseInt(input[j]))
					max=Integer.parseInt(input[j]);
				if(min>Integer.parseInt(input[j]))
					min=Integer.parseInt(input[j]);
				depth[i][j]=Integer.parseInt(input[j]);
			}
		}
		int answer[]=new int[max+1];
		check=new boolean [n][n];
		for(int i=0;i<min;i++)
		{
			answer[i]=1;
		}
		for(int i=min;i<max;i++)
		{
			for(int y=0;y<n;y++)
			{
				for(int x=0;x<n;x++)
				{
					if(depth[y][x]>i&&!check[y][x])
					{	
						dps(y,x,n,i);
						answer[i]++;
					}
				}
			}
			for (int k = 0; k < n; k++) {
			    for (int j = 0; j < n;j++) {
			        check[k][j] = false;
			    }
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[max]);
	}
	private static void dps(int y, int x,int n,int now) {
		 check[y][x] = true;
		 
		    for (int i = 0; i < 4; i++) {
		        int ny = y + dy[i];
		        int nx = x + dx[i];
		 
		        if (ny < 0 || nx < 0 || ny >= n || nx >= n)
		            continue;
		        if (depth[ny][nx]>now && !check[ny][nx]) {
		            dps(ny, nx,n,now);
		        }
		    }
	}
}
