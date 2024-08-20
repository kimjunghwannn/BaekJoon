
package algo;
import java.util.*;
import java.io.*;
public class back_17086 {
	static int map[][];
	static int max=0;
	static int dx[]= {0,0,1,-1,-1,1,1,-1};
	static int dy[]= {1,-1,0,0,-1,-1,1,1};
	static class node implements Comparable<node>
	{
		public int y;
		public int x;
		public int n;
		public node(int y,int x,int n)
		{
			this.y=y;
			this.x=x;
			this.n=n;
		}
		@Override
		public int compareTo(node other) {
			return Integer.compare(this.n,other.n);
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		map=new int [N][M];
		for(int i=0;i<N;i++)
		{
			String input2[]=id.readLine().split(" ");
			for(int j=0;j<input2.length;j++)
	    	{
	    		map[i][j]=Integer.parseInt(input2[j]);
	    	}
		}
		
	    for(int i=0;i<N;i++)
	    {
	    	for(int j=0;j<M;j++)
	    	{
	    		if(map[i][j]==0)
	    			bfs(i,j);
	    	}
	    }
	    System.out.println(max);
	}
	static void bfs(int y,int x)
	{
		PriorityQueue<node> nodeQ=new PriorityQueue<>();
		nodeQ.add(new node(y,x,0));
		boolean visited[][]=new boolean [map.length][map[0].length];
		while(!nodeQ.isEmpty())
		{
			node nowNode=nodeQ.poll();
			
			for(int i=0;i<8;i++)
			{
				int cx=nowNode.x+dx[i];
				int cy=nowNode.y+dy[i];
				if(cx<0||cy<0||cy>=map.length||cx>=map[0].length)
					continue;
				if(visited[cy][cx])
					continue;
				if(map[cy][cx]==1)
				{
					max=Math.max(nowNode.n+1, max);
					nodeQ.clear();
					break;
				}
				visited[cy][cx]=true;
				nodeQ.add(new node(cy,cx,nowNode.n+1));
			}
		}
	}
}
