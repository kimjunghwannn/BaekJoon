package algo;

import java.util.*;
import java.io.*;
public class back_18111 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		int B=Integer.parseInt(input[2]);
		int map[][]=new int [N][M];
		Set<Integer> floor=new HashSet<>();
		
		int maxFloorInMap=0;
		int maxFloorNeedBlock=0;
		int height=Integer.MAX_VALUE;
		int time=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++)
		{
			String inputLine[]=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(inputLine[j]);
				floor.add(map[i][j]);
				
				maxFloorInMap=Math.max(maxFloorInMap, map[i][j]);
			}
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				maxFloorNeedBlock+=maxFloorInMap-map[i][j];
			}
		}
		if(maxFloorNeedBlock<=B)
		{
			height=maxFloorInMap;
			time=maxFloorNeedBlock;
		}
		for(int i=maxFloorInMap-1;i>=0;i--)
		{
			int needTime=0;
			int needBlock=0;
			int block=0;
			for(int k=0;k<N;k++)
			{
				for(int j=0;j<M;j++)
				{
					if(map[k][j]>i)
					{	
						needTime+=(map[k][j]-i)*2;
						block+=(map[k][j]-i);
					}
					else if(map[k][j]<i)
					{
						needBlock+=i-map[k][j];
						needTime+=i-map[k][j];
					}
				}
			}
			if(needBlock>block+B)
				continue;
			
			if(time>needTime)
			{
				time=needTime;
				height=i;
			}
		}
		
		
		System.out.println(time+" "+height);
	}
}
