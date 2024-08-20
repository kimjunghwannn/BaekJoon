package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;



public class back_3190 {
	static class apple {
		public int time;
		public String LR;
		public apple(int time,String LR)
		{
			this.time=time;
			this.LR=LR;
		}
	}
	static class now {
		public int y;
		public int x;
		public now(int y,int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int apple_n=Integer.parseInt(id.readLine());
		boolean map[][]=new boolean[n+1][n+1];
		String input[];
		for(int i=0;i<apple_n;i++)
		{
			input=id.readLine().split(" ");
			int y=Integer.parseInt(input[0]);
			int x=Integer.parseInt(input[1]);
			map[y][x]=true;
		}
		int changes=Integer.parseInt(id.readLine());
		apple box[]=new apple [changes];
		
		for(int i=0;i<changes;i++)
		{
			input=id.readLine().split(" ");
			box[i]=new apple(Integer.parseInt(input[0]),input[1]);
		}
		int time=0;
		int dx[]= {1,0,-1,0};
		int dy[]= {0,1,0,-1,};
		LinkedHashSet<now> a = new LinkedHashSet<>();
		a.add(new now(1,1));
		int di=0;
		int boxindex=0;
		while(true)
		{
			if(time==box[boxindex].time)
			{
				if(box[boxindex].LR.equals("D"))
				{	
					di=(di+1)%4;
				}
				else
				{	
					
					di=di-1;
					if(di<0)
						di=3;
				}
				if(boxindex<box.length-1)
				boxindex++;
			}
			
			LinkedHashSet<now> new_b=new LinkedHashSet<>();
			boolean check=false;
			int cx=0;
		    int cy=0;
			for (now b : a) {
			    cx = b.x + dx[di];
			    cy = b.y + dy[di];
			    System.out.println(cy+" "+cx+" "+time);
			    if (cx <= 0 || cy <= 0 || cx > n || cy > n) {
			        System.out.println(cy+" "+cx+"  "+(time+1));
			        System.exit(0);
			    }
			    if (map[cy][cx]) 
			    {   
			       check=true;
			       map[cy][cx]=false;
			       break;
			    }
			    else
			    	new_b.add(new now(cy,cx));
			}
			if(check==false)
			{
				if(a.size()!=new_b.size())
				{
					System.out.println((time+1));
					System.exit(0);
				}
				a=new_b;
			}
			else
				 a.add(new now(cy,cx));
			System.out.println(a.size());
			time++;
		}
	}
}
