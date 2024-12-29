package algo;


import java.util.*;
import java.io.*;
public class back_17070 {
	static int dx[][][]= 
			{
				{{1,1},{1,1},{}},
				{{1,1},{1,1},{1,0}},
				{{},{0,1},{0,0}}
			
			}; 
	static int dy[][][]= 
		{
				{{0,0},{0,1},{}},
				{{1,0},{1,1},{1,1}},
				{{},{1,1},{1,1}}
		}; 
	static int map[][];
	static int answer=0;
	static class PipePosition
	{
		public int x[]=new int[2];
		public int y[]=new int [2];
		public int direction;
		public PipePosition(int y1,int x1,int y2,int x2,int direction)
		{
			x[0]=x1;
			x[1]=x2;
			y[0]=y1;
			y[1]=y2;
			this.direction=direction;
		}
	}
	static public void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		map=new int [N+1][N+1];
		for(int i=1;i<=N;i++)
		{
			String input[]=br.readLine().split(" ");
			for(int j=1;j<=N;j++)
			{
				map[i][j]=Integer.parseInt(input[j-1]);
			}
		}
		if(map[N+1][N+1]==1) {
            System.out.println(0);
            return ;
        }
		pipeMove(new PipePosition(1,1,1,2,0));
		System.out.println(answer);
	}
	private static void pipeMove(PipePosition firstPosition) 
	{
		Queue<PipePosition> queue=new LinkedList<>();
		queue.add(firstPosition);
		while(!queue.isEmpty())
		{
			PipePosition nowPosition=queue.poll();
			//i는 지금 움직이는 방향을 뜻함
			for(int i=0;i<3;i++)
			{
				if(nowPosition.direction==0&&i==2)
					continue;
				if(nowPosition.direction==2&&i==0)
					continue;
				int cx[]= {nowPosition.x[0]+dx[nowPosition.direction][i][0] , nowPosition.x[1]+dx[nowPosition.direction][i][1]};
				int cy[]= {nowPosition.y[0]+dy[nowPosition.direction][i][0] , nowPosition.y[1]+dy[nowPosition.direction][i][1]};
				if(cx[0]<1||cx[0]>=map.length||cx[1]<1||cx[1]>=map.length)
					continue;
				if(cy[0]<1||cy[0]>=map.length||cy[1]<1||cy[1]>=map.length)
					continue;
				if(!canPlacePipe(cx,cy,i))
					continue;
				if(isAtEndPoint(cx,cy))
				{	
					answer++;
					continue;
				}
				queue.add(new PipePosition(cy[0],cx[0],cy[1],cx[1],i));
			}
		}
	}
	private static boolean canPlacePipe(int[] cx, int[] cy, int direction) 
	{
		if(direction==1)
		{
			if(map[cy[0]][cx[0]]==1||map[cy[1]][cx[1]]==1||
			   map[cy[0]+1][cx[0]]==1||map[cy[0]][cx[0]+1]==1)
				return false;
			else
				return true;
		}
		if(map[cy[0]][cx[0]]==1||map[cy[1]][cx[1]]==1)
			return false;
		else
			return true;
	}
	private static boolean isAtEndPoint (int[] cx, int[] cy) {
		if(cx[0]==map.length-1&&cy[0]==map.length-1)
			return true;
		if(cx[1]==map.length-1&&cy[1]==map.length-1)
			return true;
		return false;
	}

}
