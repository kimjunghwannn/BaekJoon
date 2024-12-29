package algo;


import java.util.*;
import java.io.*;
public class back_17144 
{
	static int map[][];
	static Machine airPurifier=new Machine(); 
	static int dy[]= {0,0,1,-1};
	static int dx[]= {1,-1,0,0};
	static class Point
	{
		public int y;
		public int x;
		public Point(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static class Machine
	{
		public Point[] location;
		public Machine()
		{
			location=new Point [2];
		}
	}
	static class MovingDust
	{
		public Point from;
		public Point to;
		public int amount;
		public MovingDust(Point from,Point to,int amount)
		{
			this.from=from;
			this.to=to;
			this.amount=amount;
		}
	}
	static int R;
	static int C;
	static public void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		R=Integer.parseInt(input[0]);
		C=Integer.parseInt(input[1]);
		int T=Integer.parseInt(input[2]);
		int index=0;
		map = new int [R][C];
		for(int i=0;i<R;i++)
		{
			String inputLine[]=br.readLine().split(" ");
			for(int j=0;j<C;j++)
			{
				map[i][j]=Integer.parseInt(inputLine[j]);
				if(map[i][j]==-1)
					airPurifier.location[index++]= new Point(i,j);
			}
		}
		for(int i=0;i<T;i++)
		{
			LinkedList<MovingDust> nowMoving=new LinkedList<>();
			for(int k=0;k<R;k++)
			{
				for(int j=0;j<C;j++)
				{
					if(map[k][j]!=-1&&map[k][j]>=5)
						moveFineDust(nowMoving,k,j);
				}
			}
			for(MovingDust a:nowMoving)
			{
				map[a.from.y][a.from.x]-=a.amount;
				map[a.to.y][a.to.x]+=a.amount;
			}
			doaboveWindowOne();
			doaboveWindowTwo();
			doaboveWindowThree();
			doaboveWindowFour();
			dobelowWindowOne();
			dobelowWindowTwo();
			dobelowWindowThree();
			dobelowWindowFour();
		}
		int sum=0;
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if(map[i][j]>=1)
					sum+=map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	private static void dobelowWindowOne() {
		for(int i=airPurifier.location[1].y+1;i<R;i++)
		{
			int amout=map[i][0];
			if(map[i][0]!=0)
			{
				map[i][0]=0;
				if(i==airPurifier.location[1].y+1)
					continue;
				else
					map[i-1][0]=amout;
			}
				
		}
		
	}
	private static void dobelowWindowTwo() {
		for(int i=1;i<C;i++)
		{
			int amout=map[R-1][i];
			if(map[R-1][i]!=0)
			{
				map[R-1][i]=0;
				map[R-1][i-1]=amout;
			}
				
		}
		
	}
	private static void doaboveWindowOne() {
		for(int i=airPurifier.location[0].y-1;i>=0;i--)
		{
			int amout=map[i][0];
			if(map[i][0]!=0)
			{
				map[i][0]=0;
				if(i==airPurifier.location[0].y-1)
					continue;
				else
					map[i+1][0]=amout;
			}
				
		}
		
	}
	private static void dobelowWindowThree() {
		for(int i=R-2;i>=airPurifier.location[1].y;i--)
		{
			int amout=map[i][C-1];
			if(map[i][C-1]!=0)
			{
				map[i][C-1]=0;
				map[i+1][C-1]=amout;
			}
				
		}
		
	}
	private static void dobelowWindowFour() {
		for(int i=C-2;i>=1;i--)
		{
			int amout=map[airPurifier.location[1].y][i];
			if(map[airPurifier.location[1].y][i]!=0)
			{
				map[airPurifier.location[1].y][i]=0;
				map[airPurifier.location[1].y][i+1]=amout;
			}
				
		}
		
	}
	private static void doaboveWindowTwo() {
		for(int i=1;i<C;i++)
		{
			int amout=map[0][i];
			if(map[0][i]!=0)
			{
				map[0][i]=0;
				map[0][i-1]=amout;
			}
				
		}
		
	}
	private static void doaboveWindowThree() {
		for(int i=1;i<=airPurifier.location[0].y;i++)
		{
			int amout=map[i][C-1];
			if(map[i][C-1]!=0)
			{
				map[i][C-1]=0;
				map[i-1][C-1]=amout;
			}
				
		}
		
	}
	private static void doaboveWindowFour() {
		for(int i=C-2;i>=1;i--)
		{
			int amout=map[airPurifier.location[0].y][i];
			if(map[airPurifier.location[0].y][i]!=0)
			{
				map[airPurifier.location[0].y][i]=0;
				map[airPurifier.location[0].y][i+1]=amout;
			}
				
		}
		
	}
	private static void moveFineDust(LinkedList<MovingDust> nowMoving,int y,int x) 
	{			
				Point a=new Point(y,x);
				int amount=map[a.y][a.x]/5;
				for(int i=0;i<4;i++)
				{
					int cy=a.y+dy[i];
					int cx=a.x+dx[i];
					
					if(cx<0||cx>=map[0].length||cy<0||cy>=map.length)
						continue;
					if(map[cy][cx]==-1)
						continue;
					nowMoving.add(new MovingDust(a,new Point(cy,cx),amount));
				}
	}
}
