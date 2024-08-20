package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class back_1238 {
	static int highsu=0;
	public static void main(String[]args) throws IOException {
		BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
		String input[]=is.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int roadsu=Integer.parseInt(input[1]);
		int endplace=Integer.parseInt(input[2]);
		int i;
		int detailroad[][]=new int[roadsu+1][roadsu+1];
		int time[][]=new int [n+1][2];
		boolean check[]=new boolean [n+1];
		LinkedList<Integer> road[]=new LinkedList[roadsu+1];
		for(i=1;i<=roadsu;i++)
			road[i]=new LinkedList<Integer>();
		for(i=1;i<=roadsu;i++)
		{
			input=is.readLine().split(" ");
			detailroad[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=Integer.parseInt(input[2]);
			road[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
		}
		for(i=1;i<=n;i++) {
			if(i==endplace)
				continue;
			check[i]=true;
		docheck(0,i,detailroad,time,road,0,i,endplace,check);
		Arrays.fill(check, false);
		}
		for(i=1;i<=n;i++) {
			if(i==endplace)
				continue;
		check[endplace]=true;	
		docheck(1,i,detailroad,time,road,0,endplace,i,check);
		Arrays.fill(check, false);
		}

		for(i=1;i<=n;i++)
		{
			if(highsu<time[i][0]+time[i][1])
				highsu=time[i][0]+time[i][1];
		}
		
		System.out.println(highsu);
	}

	private static void docheck(int vector,int realstart,int[][] detailroad, int[][] time, LinkedList<Integer>[] road,int total,int start,int endplace,boolean []check) {
	
		if(start==endplace) {
			if(time[realstart][vector]==0||total<time[realstart][vector])
				
				{time[realstart][vector]=total;}
		}
		for(int i : road[start])
		{	
			if(check[i])
				continue;
			check[i]=true;
			total+=detailroad[start][i];
			docheck(vector,realstart,detailroad,time,road,total,i,endplace,check);
			check[i]=false;
			total-=detailroad[start][i];
		}
	}
}
