package algo;

import java.io.*;
import java.util.*;
public class back_6987 
{
	static int teamArray[][]=new int [6][3];
	static int results[][]=new int [6][3];
	static int homeTeamIndex[]= {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4}; //{0,0,1}
	static int awayTeamIndex[]= {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5}; //{1,2,2}
	static int matchResultHome[] = {0,1,2}; //승 무 패
	static int matchResultAway[] = {2,1,0}; //패 무 승
	static boolean isPossibleResult;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	
		for(int j=0;j<4;j++)
		{	
			String inputTeam[]=br.readLine().split(" ");
			isPossibleResult=false;
			for(int i=0;i<inputTeam.length;i+=3)
			{
				int win=Integer.parseInt(inputTeam[i]);
				int draw=Integer.parseInt(inputTeam[i+1]);
				int lose=Integer.parseInt(inputTeam[i+2]);
				teamArray[i/3][0]=win;
				teamArray[i/3][1]=draw;
				teamArray[i/3][2]=lose;
			}
			combination(0);
			if(isPossibleResult)
				System.out.print(1+" ");
			else
				System.out.print(0+" ");	
		}
	}
	private static void combination(int round) 
	{
		if(round==15)
		{
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(teamArray[i][j]!=results[i][j])
						return;
				}
			}
			isPossibleResult=true;
			return;
		}
		
		for(int i=0;i<3;i++)
		{
			results[homeTeamIndex[round]][matchResultHome[i]]++;
			results[awayTeamIndex[round]][matchResultAway[i]]++;
			combination(round+1);
			results[homeTeamIndex[round]][matchResultHome[i]]--;
			results[awayTeamIndex[round]][matchResultAway[i]]--;
		}
	}
}
