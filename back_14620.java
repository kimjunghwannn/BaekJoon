package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class back_14620 {
	static class jijum{
		public int sum;
		public int y;
		public int x;
		
		public jijum(int sum,int y,int x)
		{
			this.sum=sum;
			this.y=y;
			this.x=x;
		}
	}
	static int max=Integer.MAX_VALUE;
	static int map[][];
	static boolean visited[][];
	static jijum a[];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		map=new int [n][n];
		visited=new boolean [n][n];
		for(int i=0;i<n;i++)
		{
			String input[]=id.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				map[i][j]=Integer.parseInt(  input[j]);			
			}
		}
		
		a=new jijum[(n-2)*(n-2)];
		int index=0;
		for(int y=1;y<n-1;y++)
		{
			for(int x=1;x<n-1;x++)
			{
				a[index]=new jijum(0,y,x);
				a[index].sum=map[y][x];
				for(int i=0;i<4;i++)
				{
					int cx=x+dx[i];
					int cy=y+dy[i];
					
					a[index].sum+=map[cy][cx];
				}
				index++;
			}
		}
		 Arrays.sort(a, new Comparator<jijum>() {
	            @Override
	            public int compare(jijum a, jijum b) {
	                return Integer.compare(a.sum, b.sum);
	            }
	        });
		
		doing(0,0,0);
		System.out.println(max);
		
	}
	private static void doing(int index, int n, int sum) {
		if(n==3)
		{
			max=Math.min(max, sum);
			return;
		}
		if(max<sum)
		{
			return;
		}
		for(int i=index;i<a.length;i++)
		{
			boolean pass=false;
			for(int j=0;j<5;j++)
			{
				int cx;
				int cy;
				
				if(j==4)
				{
					cx=a[i].x;
					cy=a[i].y;
				}
				else
				{
					cx=a[i].x+dx[j];
					cy=a[i].y+dy[j];
				}
				if(visited[cy][cx])
				{
					pass=true;
					break;
				}
					
					
			}
			if(pass)
				continue;
			for(int j=0;j<5;j++)
			{
				int cx;
				int cy;
				
				if(j==4)
				{
					cx=a[i].x;
					cy=a[i].y;
				}
				else
				{
					cx=a[i].x+dx[j];
					cy=a[i].y+dy[j];
				}
				visited[cy][cx]=true;
			}
			doing(i,n+1,sum+a[i].sum);
			for(int j=0;j<5;j++)
			{
				int cx;
				int cy;
				
				if(j==4)
				{
					cx=a[i].x;
					cy=a[i].y;
				}
				else
				{
					cx=a[i].x+dx[j];
					cy=a[i].y+dy[j];
				}
				visited[cy][cx]=false;
			}
		}
	}
}
