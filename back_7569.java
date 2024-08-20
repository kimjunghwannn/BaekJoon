package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_7569 {
	static int tomato[][][];
	static boolean check[][][];
	static int movex[]= {0,0,1,-1,0,0};
	static int movey[]= {1,0,0,0,0,-1};
	static int movez[]= {0,1,0,0,-1,0};
	static class doing {
		public int x;
		public int y;
		public int z;
		public doing(int z,int y,int x) {
			this.z=z;
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		tomato=new int [Integer.parseInt(input[2])][Integer.parseInt(input[1])][Integer.parseInt(input[0])];
		check =new boolean [Integer.parseInt(input[2])][Integer.parseInt(input[1])][Integer.parseInt(input[0])];
		boolean nozero=true;
		for(int a=0;a<Integer.parseInt(input[2]);a++)
			for(int b=0;b<Integer.parseInt(input[1]);b++)
				{
					String input2[]=id.readLine().split(" ");
					for(int c=0;c<Integer.parseInt(input[0]);c++)
					{
						tomato[a][b][c]=Integer.parseInt(input2[c]);
						if(Integer.parseInt(input2[c])==0)
							nozero=false;
					}
				}
		if(nozero)
		{
			System.out.println(0);
			System.exit(0);
		}
		int day=0;
		Queue <doing> queue=new LinkedList<>();
		while(true) 
		{
			boolean finish=true;
			boolean checkzero=false;
			for(int a=0;a<Integer.parseInt(input[2]);a++)
				{
				for(int b=0;b<Integer.parseInt(input[1]);b++)
					{
						for(int c=0;c<Integer.parseInt(input[0]);c++)
						{
							if(tomato[a][b][c]==0)
								checkzero=true;
							if(tomato[a][b][c]==1&&!check[a][b][c])
							{
								check[a][b][c]=true;
								finish=false;
								queue.add(new doing(a,b,c));
								
							}
						
						}
					}
				}
			if(checkzero==false)
			{
				System.out.println(day);
				System.exit(0);
			}
			while(!queue.isEmpty())
			{
				doing this_doing=queue.poll();
				for(int i=0;i<6;i++)
				{
					int dx=this_doing.x+movex[i];
					int dy=this_doing.y+movey[i];
					int dz=this_doing.z+movez[i];
					if(dx<0||dx==tomato[0][0].length||dy<0||dy==tomato[0].length||dz<0||dz==tomato.length)
						continue;
					if(tomato[dz][dy][dx]==-1)
						continue;
					tomato[dz][dy][dx]=1;
				}
			}
			if(finish==true&&checkzero==true)
			{
				System.out.println(-1);
				System.exit(0);
			}
			
			
			day++;
		}
}

}
