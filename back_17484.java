package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_17484 {
	static int dx[]= {0,1,-1};
	static int dy[]= {1,1,1};
	static int men=Integer.MAX_VALUE;
	static int y;
	static int x;
	static int map[][];
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		y=Integer.parseInt(input[0]);
		x=Integer.parseInt(input[1]);
		map=new int [y][x];
		for(int i=0;i<y;i++) 
		{
			String input2[]=id.readLine().split(" ");
			for(int j=0;j<x;j++)
			{
				map[i][j]=Integer.parseInt(input2[j]);
				
			}
			
		}
		for(int i=0;i<x;i++)
			startgo(0,i,0,map[0][i]);
		System.out.println(men);
	}

	private static void startgo(int ny, int nx, int dire, int value) {
		
		if(ny+1==y)
		{
			if(value<men)
				men=value;
			return;
		}
		for(int i=0;i<3;i++)
		{
			if(i==dire)
				continue;
			if(nx+dx[i]<0||nx+dx[i]>=x)
				continue;
			startgo(ny+dy[i],nx+dx[i],i,value+map[ny+dy[i]][nx+dx[i]]);
		}
	}
}
