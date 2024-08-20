package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_7562 {
	static class horse{
		public int y;
		public int x;
		public int time;
		public horse(int y,int x,int time) {
			this.y=y;
			this.x=x;
			this.time=time;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int test=Integer.parseInt(id.readLine());
		int dx[]= {2,2,1,1,-2,-2,-1,-1};
		int dy[]= {1,-1,2,-2,1,-1,2,-2};
		while(test-->0) {
			int n=Integer.parseInt(id.readLine());
			boolean check[][]=new boolean [n][n];
			String input[]=id.readLine().split(" ");
			int y=Integer.parseInt(input[0]);
			int x=Integer.parseInt(input[1]);
			input=id.readLine().split(" ");
			int endy=Integer.parseInt(input[0]);
			int endx=Integer.parseInt(input[1]);
			Queue <horse>queue=new LinkedList<>();
			queue.add(new horse(y,x,0));
			check[y][x]=true;
			while(!queue.isEmpty()) {
				horse now=queue.poll();
				if(now.x==endx&&now.y==endy)
				{
					System.out.println(now.time);
					break;
				}
				for(int i=0;i<8;i++)
				{
					int cx=now.x+dx[i];
					int cy=now.y+dy[i];
					if(cx<0||cx>=n||cy<0||cy>=n)
						continue;
					if(check[cy][cx])
						continue;
					check[cy][cx]=true;
					queue.add(new horse(cy,cx,now.time+1));
				}
			}
			
		}
	}
}
