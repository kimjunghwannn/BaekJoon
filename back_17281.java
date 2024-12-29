package algo;

import java.util.*;
import java.io.*;
public class back_17281 
{
	static class Player
	{
		public int inning[]=new int [51];
	}
	static ArrayList<Player> orderList=new ArrayList<>();
	static Player playerArray[]=new Player[9];
	static boolean visited[]=new boolean[9];
	static int N;
	static int score;
	static int maxScore=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<9;i++)	
			playerArray[i]=new Player();
		for(int i=0;i<N;i++)
		{
			String input[]=br.readLine().split(" ");
			for(int j=0;j<9;j++)
			{
				int playerDo=Integer.parseInt(input[j]);
				playerArray[j].inning[i]=playerDo;
			}
		}
		generateOrder(0);
		
		
		System.out.println(maxScore);
	}
	private static void generateOrder(int index) 
	{
		if(index==8)
		{
			orderList.add(3, playerArray[0]);
			playBaseball();
			orderList.remove(3);
			return;
		}
		for(int i=1;i<9;i++)
		{
			if(visited[i])
				continue;
			orderList.add(playerArray[i]);
			visited[i]=true;
			generateOrder(index+1);
			orderList.remove(orderList.size()-1);
			visited[i]=false;
		}
	}
	private static void playBaseball()
	{
		score=0;
		int lastPlayer=0;
		for(int i=0;i<N;i++)
		{
			int out=0;
			boolean ru[]=new boolean [3];
			int rotate=0;
			while(out!=3)
			{
				for(int j=0;j<9;j++)
				{
					if(rotate==0&&lastPlayer>j)
						continue;
					int nowDo =orderList.get(j).inning[i];
					if(out==3)
					{	
						lastPlayer=j;
						break;
					}
					if(nowDo==0)
						out++;
					else
						score+=doHit(nowDo,ru);
				}
				rotate++;
			}
		}
		maxScore=Math.max(score, maxScore);
	}
	private static int doHit(int nowDo,boolean ru[]) 
	{
		int score=0;		
		for(int i=2;i>=0;i--)
		{
			if(ru[i])
			{
				if(i+nowDo>2)
				{	
					score++;
				}
				else
					ru[i+nowDo]=true;
				ru[i]=false;
			}
		}
		if(nowDo==4)
			score++;
		else
			ru[nowDo-1]=true;
		return score;
	}
}
