package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_20125 {
	static int rarm;
	static int larm;
	static int body;
	static int rleg;
	static int lleg;
	static boolean map[][];
	static int check_length(char a,int x,int y,int dd) {
		
		int length=-1;
		while(true) {
			if(a=='x')
			{
				x+=dd;
				
			}
			else
			{
				y-=dd;
			}
			length++;
			if(y >=map.length || x >= map[0].length || y < 0 || x < 0 || !map[y][x])
				break;
		}
		return length;
	}
	
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		map=new boolean[n][n];
		int firststar=0;
		int hearty=0;
		int heartx=0;
		for(int i=0;i<n;i++)
		{
			String input=id.readLine();
			for(int j=0;j<n;j++)
			{
				if(input.charAt(j)=='*')
				{	
					map[i][j]=true;
					if(firststar==0)
					{
						heartx=j;
						hearty=i+1;
						firststar=1;
					}
				}
			}
		}
		
		larm=check_length('x',heartx,hearty,-1);
		rarm=check_length('x',heartx,hearty,+1);
		body=check_length('y',heartx,hearty,-1);
		int bodyy=hearty+body;
		int bodx=heartx;
		lleg=check_length('y',bodx-1,bodyy+1,-1)+1;
		rleg=check_length('y',bodx+1,bodyy+1,-1)+1;
		System.out.println((hearty+1)+" "+(heartx+1));
		System.out.println(larm+" "+rarm+" "+body+" "+lleg+" "+rleg);
		
	}
}
