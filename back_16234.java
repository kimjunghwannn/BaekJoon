package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class back_16234 {
	static class Point
	{
		public int x;
		public int y;
		public Point(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int minDif=Integer.parseInt(input[1]);
		int maxDif=Integer.parseInt(input[2]);
		int map[][]=new int [N][N];
		int dx[]= {0,0,1,-1};
		int dy[]= {1,-1,0,0};
		List<Point> visitedPoint=new ArrayList<>();
		boolean visited[][]=new boolean [N][N];
		for(int i=0;i<N;i++)
		{
			String input2[]=id.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(input2[j]);
			}
		}
		Queue<Point> queue=new LinkedList<>();
		boolean checkChangeMapValue=true;
		int answer=-1;
		while(checkChangeMapValue==true)
		{
			int totalVisited=0;
			checkChangeMapValue=false;
			answer++;
			while(totalVisited!=N*N)
			{
				
				int start_X = 0;
				int start_Y = 0;
				boolean check_Find=false;
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						if(visited[i][j]==false)
						{
							start_X=j;
							start_Y=i;
							check_Find=true;
							break;
						}
					}
					if(check_Find)
						break;
				}
				queue.add(new Point(start_Y,start_X));
				visitedPoint.add(new Point(start_Y,start_X));
				int Node_n=1;
				int Node_sum=map[start_Y][start_X];
				visited[start_Y][start_X]=true;
				while(!queue.isEmpty())
				{
					
					Point now=queue.poll();
					for(int i=0;i<4;i++)
					{
						int cx=dx[i]+now.x;
						int cy=dy[i]+now.y;
						if(cx<0||cy<0||cx>=map.length||cy>=map.length)
							continue;
						int dif=Math.abs(map[now.y][now.x]-map[cy][cx]);
						if(visited[cy][cx])
							continue;
						if(dif>maxDif||dif<minDif)
							continue;
						visitedPoint.add(new Point(cy,cx));
						visited[cy][cx]=true;
						queue.add(new Point(cy,cx));
						Node_n++;
						Node_sum+=map[cy][cx];
					}
				}
				totalVisited+=Node_n;
				if(visitedPoint.size()>1)
				{	
					int chage_mapValue=Node_sum/Node_n;
					checkChangeMapValue=true;
					for(Point a : visitedPoint)
					{
						
						map[a.y][a.x]=chage_mapValue;
					}
					
				}
				visitedPoint=new ArrayList<>();
			}
			visited=new boolean [N][N];
		}
		System.out.println(answer);
	}
}
