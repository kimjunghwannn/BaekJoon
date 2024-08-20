package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class back_2589 {
	static class doing {
		public int y;
		public int x;
		public int time;
		public doing(int y,int x,int time) {
			this.y=y;
			this.x=x;
			this.time=time;
		}
	}
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		boolean map[][]=new  boolean [y][x];
		boolean visited[][]=new boolean [y][x];
		for(int i=0;i<y;i++)
		{
			String input2=id.readLine();
			for(int j=0;j<x;j++)
			{
				if(input2.charAt(j)=='W')
					map[i][j]=true;
			}
		}
		
		int dx[]= {0,0,1,-1};
		int dy[]= {1,-1,0,0};
		int max=0;
		int distance[][]=new int [y][x];
		for(int i=0;i<y;i++)
		{
			for(int j=0;j<x;j++)
			{
				if(map[i][j]==false)
				{
					
					Queue <doing>queue=new LinkedList<>();
					
					queue.add(new doing(i,j,0));
					visited[i][j]=true;
					while(!queue.isEmpty()) 
					{
						doing now=queue.poll();
						max=Math.max(now.time,max);
						for(int k=0;k<4;k++)
						{
							int cx=now.x+dx[k];
							int cy=now.y+dy[k];
							if(cx<0||cx>=x||cy<0||cy>=y)
								continue;
							if(map[cy][cx])
								continue;
							if(visited[cy][cx])
								continue;
							if(distance[cy][cx]!=0&&now.time>=distance[cy][cx])
								continue;
							distance[cy][cx]=now.time+1;
							visited[cy][cx]=true;
							queue.add(new doing(cy,cx,now.time+1));
						}
					}
					for (int l = 0; l < y; l++) {
				           Arrays.fill(visited[l], false);
				            Arrays.fill(distance[l], 0);
				       }
				}
			}
		}
		System.out.println(max);
		
	}
}
