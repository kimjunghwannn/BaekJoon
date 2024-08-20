package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class back_2573 {
	static class doing {
		public int x;
		public int y;
		public int now;
		public int years;
		public doing(int x,int y,int now,int years) {
			this.x=x;
			this.y=y;
			this.now=now;
			this.years=years;
		}
	}
	static boolean check[][];
	static int movex[] = {0,0,1,-1};
	static int movey[]= {1,-1,0,0};
	static int box[][];
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		box=new int [y][x];
		PriorityQueue <doing>a=new PriorityQueue<>((q,w)->{
			if(q.years!=w.years) {
				return q.years-w.years;
			}
			else {
				return w.now-q.now;
			}
		});	
		int years[][]=new int [y][x];
		for (int i = 0; i < y; i++) {
		    Arrays.fill(years[i], -1);
		}
		for(int i=0;i<y;i++)
		{
			String input2[]=id.readLine().split(" ");
			for(int j=0;j<x;j++)
			{
				box[i][j]=Integer.parseInt(input2[j]);
				if(box[i][j]>0)
				{	
					a.add(new doing(j,i,box[i][j],0));
					years[i][j]=0;
				}
			}
		}
		
	
		int now_year=0;
	
		check=new boolean[y][x];
		while(!a.isEmpty()) {
			doing this_doing=a.poll();
			if(now_year!=this_doing.years)
			{
				Queue <doing>queue=new LinkedList<>(a);
				queue.add(this_doing);
				int san=0;
				while(!queue.isEmpty()) 
				{
					doing this_do=queue.poll();
					if(check[this_do.y][this_do.x]==false)
						{
							dfs(this_do.x,this_do.y);
							san++;
						}
					if(san>=2)
					{
						System.out.println(this_do.years);
						System.exit(0);
					}
				}
				now_year++;
			}
			
			
			for(int i=0;i<4;i++)
			{
				int dx=this_doing.x+movex[i];
				int dy=this_doing.y+movey[i];
				
				if(dx<0||dx==box[0].length||dy<0||dy==box.length)
					continue;
				if(box[dy][dx]==0&&years[dy][dx]!=this_doing.years)
					box[this_doing.y][this_doing.x]--;
				if(box[this_doing.y][this_doing.x]==0)
					{
						years[this_doing.y][this_doing.x]=this_doing.years;
						break;
					}
				if(i==3)
					{
						check[this_doing.y][this_doing.x]=false;
						a.add(new doing(this_doing.x,this_doing.y,box[this_doing.y][this_doing.x],this_doing.years+1));
					}
			}

		}
		System.out.println(0);
	}
	private static void dfs(int x, int y) {
		for(int i=0;i<4;i++)
		{
			int dx=x+movex[i];
			int dy=y+movey[i];
			
			if(dx<0||dx==box[0].length||dy<0||dy==box.length)
				continue;
			if(box[dy][dx]>0&&!check[dy][dx])
				{	
					check[dy][dx]=true;
					dfs(dx,dy);
				}
		}
		
	}
}
