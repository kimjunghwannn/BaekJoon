package algo;

import java.util.*;
import java.io.*;


public class back_15683 
{
	static class Node
	{
		public int x;
		public int y;
		public Node(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static class CCTVCheckedNode extends Node
	{
		public int direction;
		public CCTVCheckedNode(int y,int x,int direction)
		{
			super(y,x);
			this.direction=direction;
		}
	}
	static class CCTV extends Node
	{
		public int type;
		public int id;
		public CCTV(int y,int x,int type,int id)
		{
			super(y,x);
			this.type=type;
			this.id=id;
		}
	}
	//위,오른쪽,아래,왼쪽
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	static LinkedList<CCTV> cctvs;
	static int answer=Integer.MAX_VALUE;
	static int map[][];
	static int height;
	static int width;
	static public void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String mapInput[]=br.readLine().split(" ");
		
		height=Integer.parseInt(mapInput[0]);
		width=Integer.parseInt(mapInput[1]);
		map=new int [height][width];
		cctvs=new LinkedList<>();
		
		int id=7;
		
		for(int i=0;i<height;i++)
		{
			String lineInput[]=br.readLine().split(" ");
			for(int j=0;j<width;j++)
			{	
				map[i][j]=Integer.parseInt(lineInput[j]);
				if(map[i][j]!=0&&map[i][j]!=6)
					cctvs.add(new CCTV(i,j,map[i][j],id++));
			}
		}
		setCCTVDirection(0);
		System.out.println(answer);
	}
	
	
	
	private static void setCCTVDirection(int index) 
	{
		if(index>=cctvs.size())
		{
			int count=0;
			for (int i = 0; i < height; i++) 
	        {
	            for (int j = 0; j < width; j++) 
	            {
	                if(map[i][j]==0)
	                	count++;
	            }
	        }
			answer=Math.min(answer, count);
			return;
		}
		for(int i=0;i<4;i++)
		{
			fillSpots(i,index,cctvs.get(index).id);
			setCCTVDirection(index+1);
			fillSpots(i,index,0);
		}
	}
	private static void fillSpots(int direction,int index,int value) 
	{
		Queue<CCTVCheckedNode> queue=new LinkedList<>();
		CCTV nowCCTV=cctvs.get(index);
		int cctvDirections=direction;
		if(nowCCTV.type==1)
		{
			queue.add(new CCTVCheckedNode(nowCCTV.y,nowCCTV.x,cctvDirections));
		}
		if(nowCCTV.type==2)
		{
			for(int i=0;i<4;i++)
			{	
				if(Math.abs(i-cctvDirections)==2)
					continue;
				if(i==cctvDirections)
						continue;
				queue.add(new CCTVCheckedNode(nowCCTV.y,nowCCTV.x,i));
			}
		}
		if(nowCCTV.type==3)
		{
			for(int i=0;i<4;i++)
			{	
				if(Math.abs(i-cctvDirections)==2)
					continue;
				if(i==(3+cctvDirections)%4)
					continue;
				queue.add(new CCTVCheckedNode(nowCCTV.y,nowCCTV.x,i));
			}
		}
		if(nowCCTV.type==4)
		{
			for(int i=0;i<4;i++)
			{	
				if(Math.abs(i-cctvDirections)==2)
					continue;
				queue.add(new CCTVCheckedNode(nowCCTV.y,nowCCTV.x,i));
			}
		}
		if(nowCCTV.type==5)
		{
			for(int i=0;i<4;i++)
				queue.add(new CCTVCheckedNode(nowCCTV.y,nowCCTV.x,i));
		}
		
		
		while(!queue.isEmpty())
		{
			CCTVCheckedNode now=queue.poll();
			int cx=now.x+dx[now.direction];
			int cy=now.y+dy[now.direction];
			if(cx<0||cx>=width||cy<0||cy>=height)
				continue;
			if(map[cy][cx]==6)
				continue;
			if(map[cy][cx]==0&&value!=0)
				map[cy][cx]=value;
			if(map[cy][cx]==nowCCTV.id&&value==0)
				map[cy][cx]=0;
			queue.add(new CCTVCheckedNode(cy,cx,now.direction));
		}
	
	}
	
}
