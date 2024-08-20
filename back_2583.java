package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class back_2583 {
	static boolean check[][];
	static int dx[]= {0,0,-1,+1};
	static int dy[]= {1,-1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		check=new boolean [y][x];
		for(int i=0;i<Integer.parseInt(input[2]);i++)
		{
			String input2[]=id.readLine().split(" ");
			int start_x=Integer.parseInt(input2[0]);
			int start_y=Integer.parseInt(input2[1]);
			int end_x=Integer.parseInt(input2[2])-1;
			int end_y=Integer.parseInt(input2[3])-1;
			for(int q=start_x;q<=end_x;q++)
			{
				for(int w=start_y;w<=end_y;w++)
				{
					check[w][q]=true;
				}
			}
		}
		int n = 0;
		PriorityQueue queue=new PriorityQueue<>();
		
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				if(!check[j][i])
				{	
					check[j][i]=true;
					queue.add(Dfs(j,i,1));
					n++;
				}
				
			}
		}
		
		System.out.println(n);
		while(!queue.isEmpty()) {
			System.out.print(queue.poll()+" ");
		}
	}

	private static int Dfs(int y, int x,int sum) {
		int a=sum;
		for(int i=0;i<4;i++)
		{
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cx>=check[0].length||cy<0||cy>=check.length)
				continue;
			if(check[cy][cx])
				continue;
			check[cy][cx]=true;
			a+=Dfs(cy,cx,sum);
		}
		
		return a;
	}
}
