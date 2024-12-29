package algo;


import java.util.*;
import java.io.*;
public class back_3055 
{
	static class Point
	{
		public int y;
		public int x;
		public int n;
		public int type;
		public Point(int y,int x,int n,int type)
		{
			this.y=y;
			this.x=x;
			this.n=n;
			this.type=type;
		}
	}
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static final int HOG=0;
	static final int WATER=1;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int R=Integer.parseInt(input[0]);
		int C=Integer.parseInt(input[1]);
		int map[][]=new int [R][C];
		Point hog=null;
		Point home=null;
		boolean visited[][]=new boolean [R][C];
		boolean waterVisited[][]=new boolean [R][C];
		Queue<Point> queue=new LinkedList<>();
		for(int i=0;i<R;i++)
		{
			String input2=br.readLine();
			for(int j=0;j<input2.length();j++)
			{
				char a=input2.charAt(j);
				if(a=='S')
					hog=new Point(i,j,0,0);
				else if(a=='D')
					home=new Point(i,j,0,2);
				else if(a=='*')
				{	
					waterVisited[i][j]=true;
					queue.add(new Point(i,j,0,1));
				}
				else if(a=='X')
					map[i][j]=1;
			}
		}
		visited[hog.y][hog.x]=true;
		queue.add(hog);
		
		while(!queue.isEmpty())
		{
			Point now=queue.poll();
			for(int i=0;i<4;i++)
			{
				int cy=now.y+dy[i];
				int cx=now.x+dx[i];
				
				if(cy<0||cy>=R||cx<0||cx>=C||map[cy][cx]==1)
					continue;
				if(now.type==HOG&&(visited[cy][cx]||waterVisited[cy][cx]))
					continue;
				if(now.type==WATER&&(waterVisited[cy][cx]||cy==home.y&&cx==home.x))
					continue;
				if(cy==home.y&&cx==home.x&&now.type==HOG)
				{
					System.out.println(now.n+1);
					System.exit(0);
				}
				if(now.type==HOG)
				{
					visited[cy][cx]=true;
					queue.add(new Point(cy,cx,now.n+1,HOG));
				}
				else
				{
					waterVisited[cy][cx]=true;
					queue.add(new Point(cy,cx,now.n,WATER));
				}
			}
		}
		System.out.println("KAKTUS");
	}
}
