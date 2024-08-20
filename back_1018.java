package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class back_1018 {
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String args[]) throws IOException {
		int n,m;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		n=Integer.parseInt(input[0]);
		m=Integer.parseInt(input[1]);
		int map[][]=new int [n][m];
		 int[][] map2 = new int[map.length][map[0].length];
		String input2;
		for(int i=0;i<n;i++)
		{
			input2=br.readLine();
			for(int j=0;j<m;j++)
			{
				if(input2.charAt(j)=='B')
					map[i][j]=0;
				else
					map[i][j]=1;
			}
		}
		Queue<Point> queue = new LinkedList<>();
		
		int nowx=0;
		int nowy=0;
		
		int newx=0;
		int newy=0;
		boolean visited[][];
		int changesu=0;
		int high=Integer.MAX_VALUE;
		for(int rx=0;m-rx>=8;rx++)
			for(int ry=0;n-ry>=8;ry++)
				for(int d=0;d<2;d++)
				{
				changesu=0;
				visited= new boolean[n][m];
				visited[ry][rx]=true;
				
				queue.offer(new Point(rx,ry));
				 for (int i = 0; i < map.length; i++) {
			            map2[i] = Arrays.copyOf(map[i], map[i].length);   
			        }
				 map2[ry][rx]=d;
				 	if(map2[ry][rx]!=map[ry][rx])
				 		changesu++;
				 	
		while(!queue.isEmpty()) {
			Point check=queue.poll();
			nowx=check.x;
			nowy=check.y;
			int BW=map2[nowy][nowx];
			for(int i=0;i<4;i++) {
				newx=nowx+dx[i];
				newy=nowy+dy[i];
				if(newx>=rx+8||newy>=ry+8||newx<rx||newy<ry)
					continue;
				if(visited[newy][newx]==true)
					continue;
				if(BW==map2[newy][newx])
				{	
					changesu++;
					if(BW==1)
					map2[newy][newx]=0;
					else
						map2[newy][newx]=1;
				}
				visited[newy][newx]=true;
				queue.offer(new Point(newx,newy));
			}
		}
		
		 if(changesu<high)
			 high=changesu;
		}
		System.out.println(high);
	}
}
