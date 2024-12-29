package algo;

import java.io.*;
import java.util.*;
public class back_14500 
{	static class Tecno
	{
		public Point PointArray[]=new Point [3];
		public Tecno(Point p1,Point p2,Point p3)
		{
			PointArray[0]=p1;
			PointArray[1]=p2;
			PointArray[2]=p3;
		}
	}
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
	static Tecno tecnoArray[]=new Tecno [19];
	static int map[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		map=new int [N][M];
		
		tecnoArray[0]=new Tecno(new Point(0,1),new Point(0,2),new Point(0,3));
		tecnoArray[1]=new Tecno(new Point(1,0),new Point(2,0),new Point(3,0));
		
		tecnoArray[2]=new Tecno(new Point(0,1),new Point(1,0),new Point(1,1));
		
		tecnoArray[3]=new Tecno(new Point(1,0),new Point(2,0),new Point(2,1));
		tecnoArray[4]=new Tecno(new Point(1,0),new Point(0,1),new Point(0,2));
		tecnoArray[5]=new Tecno(new Point(0,1),new Point(1,1),new Point(2,1));
		tecnoArray[6]=new Tecno(new Point(1,0),new Point(1,-1),new Point(1,-2));
		
		tecnoArray[7]=new Tecno(new Point(1,0),new Point(2,0),new Point(2,-1));
		tecnoArray[8]=new Tecno(new Point(1,0),new Point(1,1),new Point(1,2));
		tecnoArray[9]=new Tecno(new Point(0,1),new Point(1,0),new Point(2,0));
		tecnoArray[10]=new Tecno(new Point(0,1),new Point(0,2),new Point(1,2));
		
		tecnoArray[11]=new Tecno(new Point(1,0),new Point(1,1),new Point(2,1));
		tecnoArray[12]=new Tecno(new Point(1,0),new Point(0,1),new Point(1,-1));
		tecnoArray[13]=new Tecno(new Point(0,1),new Point(1,1),new Point(1,2));
		tecnoArray[14]=new Tecno(new Point(1,0),new Point(1,-1),new Point(2,-1));

		tecnoArray[15]=new Tecno(new Point(0,1),new Point(0,2),new Point(1,1));
		tecnoArray[16]=new Tecno(new Point(1,0),new Point(2,0),new Point(1,-1));
		tecnoArray[17]=new Tecno(new Point(1,0),new Point(1,1),new Point(1,-1));
		tecnoArray[18]=new Tecno(new Point(1,0),new Point(2,0),new Point(1,1));

		for(int i=0;i<N;i++)
		{
			String input2[]=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(input2[j]);
			}
		}
		int answer=0;
		for(int index=0;index<19;index++)
		{	
			for(int i=0;i<N;i++)
			{			
				for(int j=0;j<M;j++)
				{
					int sum=map[i][j];
					for(int k=0;k<3;k++)
					{
						int dy=tecnoArray[index].PointArray[k].y+i;
						int dx=tecnoArray[index].PointArray[k].x+j;
						if(dy<0||dy>=N||dx<0||dx>=M)
							break;
						sum+=map[dy][dx];
					}
					answer=Math.max(answer, sum);
				}
			}
		}
		System.out.println(answer);
	}
}
