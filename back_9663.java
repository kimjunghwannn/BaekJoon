package algo;

import java.util.Scanner;

public class back_9663 {
	static int map[][];
	static int max=0;
	static boolean visited[][];
	static int dx[]= {0,0,1,1,1,-1,-1,-1};
	static int dy[]= {1,-1,0,-1,1,-1,1,0};
	public static void main(String args[])
	{
		Scanner id=new Scanner(System.in);
		int n=id.nextInt();
		id.nextLine();
		map=new int [n+1][n+1];
		visited=new boolean [n+1][n+1];
		doing(1,1,0);
		System.out.println(max);
	}
	private static void doing(int y, int x, int n) {
		
	if(y+1<map.length)
	{
		for(int i=y;i<map.length;i++)
		{
			
				if(visited[i][x])
					continue;
				System.out.println(i+"d"+x+" "+n);
				for(int k=0;k<8;k++)
				{
					int cx=x+dx[k];
					int cy=i+dy[k];
					if(cx<1||cy<1||cx>=map.length||cy>=map.length)
						continue;
					System.out.println(cy+"aa"+cx+" "+n);
					visited[cy][cx]=true;
				}
				visited[i][x]=true;
					doing(i+1,x,n+1);
				visited[i][x]=false;	
				for(int k=0;k<8;k++)
				{
					int cx=x-dx[k];
					int cy=i-dy[k];
					if(cx<1||cy<1||cx>=map.length||cy>=map.length)
						continue;
					System.out.println(cy+"aaa"+cx+" "+n);
					visited[cy][cx]=false;
				}
		}
	}
		if(x+1<map.length)
		{
			for(int i=x+1;i<map.length;i++)
			{
				for(int j=1;j<map.length;j++)
				{
					if(visited[j][i])
						continue;
					System.out.println(j+"a"+i+" "+n);
					for(int k=0;k<8;k++)
					{
						int cx=i+dx[k];
						int cy=j+dy[k];
						if(cx<1||cy<1||cx>=map.length||cy>=map.length)
							continue;
						visited[cy][cx]=true;
					}
					visited[j][i]=true;
					doing(j+1,i,n+1);
					visited[j][i]=false;
					for(int k=0;k<8;k++)
					{
						int cx=i-dx[k];
						int cy=j-dy[k];
						if(cx<1||cy<1||cx>=map.length||cy>=map.length)
							continue;
						visited[cy][cx]=false;
					}
				}
			}
		}
		max=Math.max(n,max);
	}
	
	
}