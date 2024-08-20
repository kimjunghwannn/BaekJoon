package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1034 {
	static int map[][];
	static int high;
	public static void main(String args[]) throws IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int y=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		int i,j;
		map=new int [y][x];
		int checkmap[][]=new int [y][x];
		for(i=0;i<y;i++) {
			String input2=id.readLine();
			for(j=0;j<x;j++)
			{
				if(input2.charAt(j)=='0')
					{
						map[i][j]=0;
						checkmap[i][j]=0;
					}
				else {
						map[i][j]=1;
						checkmap[i][j]=0;
					}
			}
			
		}
		int doit=Integer.parseInt(id.readLine());
		if(doit>x)
		{
			if((doit-x)%2!=0)
				doit=doit-(doit-x+1);
			else
				doit=doit-(doit-x);
		}
	
		docheck(checkmap,doit,0);
		System.out.print(high);
	}
	private static void docheck(int[][] checkmap, int doit, int trys) {
		
		if(trys%2==doit%2)
		{
			int n=0;
			int check=0;
			for(int i=0;i<checkmap.length;i++)
			{	
				for(int j=0;j<checkmap[0].length;j++)
				{
					if(checkmap[i][j]==0)
						{check=1;break;}
				}
				if(check==0)
				n++;
			}
			if(n>high)
				high=n;
		
		}
		if(trys>=doit)
			return;
		for(int i=0;i<checkmap[0].length;i++)
		{
			for(int j=0;j<checkmap.length;j++)
			{
				if(checkmap[j][i]==1)
					checkmap[j][i]=0;
				else
					checkmap[j][i]=1;
			}
			docheck(checkmap,doit,trys+1);
			for(int j=0;j<checkmap.length;j++)
			{
				if(checkmap[j][i]==1)
					checkmap[j][i]=0;
				else
					checkmap[j][i]=1;
			}
		}
		
	}
}
