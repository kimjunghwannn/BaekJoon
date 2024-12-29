package algo;
import java.io.*;
import java.util.*;
public class back_12869 
{
	static int scv[];
	static int min=Integer.MAX_VALUE;
	static boolean visited[][][]=new boolean [61][61][61];
	static int attack[][]=
		{
				{9,3,1},
				{9,1,3},
				{3,1,9},
				{3,9,1},
				{1,9,3},
				{1,3,9}
		};
	public static void main(String args[]) throws IOException 
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String input[]=br.readLine().split(" ");
		scv=new int [3];		
		for(int i=0;i<N;i++)
		{	
			scv[i]=Integer.parseInt(input[i]);
		}
		playing(scv[0],scv[1],scv[2],0);
		System.out.println(min);
	}
	private static void playing(int a,int b,int c,int n) 
	{
		int sorting[]= {a,b,c};
		Arrays.sort(sorting);
		c=sorting[0];
		b=sorting[1];
		a=sorting[2];
		
		a=Math.max(0, a);
		b=Math.max(0,b);
		c=Math.max(0,c);
		
		if(a==0&&b==0&&c==0)
		{
			min=Math.min(min, n);
			return;
		}
		if(visited[a][b][c])
			return;
		else
			visited[a][b][c]=true;
		if(n>min)
			return;
		for(int i=0;i<6;i++)
			playing(a-attack[i][0],b-attack[i][1],c-attack[i][2],n+1);
		
	}
	
}
