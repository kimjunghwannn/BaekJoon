package algo;

import java.io.*;
import java.util.*;
public class back_32248 
{
	static LinkedList<Integer> choicePepoleIndex[];
	static int memo[][];
	static boolean visited[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		long T=Long.parseLong(input[1]);
		String inputIndex[]=br.readLine().split(" ");
		int index=1;
		
		choicePepoleIndex=new LinkedList[N+1];
		memo=new int [N+1][N+1];
		
		for(int i=1;i<=N;i++)
		{	
			choicePepoleIndex[i]=new LinkedList<>();
			choicePepoleIndex[i].add(Integer.parseInt(inputIndex[i-1]));
		}
		for(int i=1;i<=N;i++)
		{
			int start=i;
			int end=choicePepoleIndex[i].get(0);
			visited=new boolean [N+1];
			memo[start][end]=checkCycle(start,start,end,1);
		}
		
		while(true)
		{
			
			int start=index;
			int end=choicePepoleIndex[start].getFirst();
			
			if(start==end)
			{	
				System.out.println(end);
				break;
			}
			
			if(T>memo[start][end]&&memo[start][end]!=0)
			{	
				T%=memo[start][end];
				if(T==0)
				{	
					System.out.println(start);
					break;
				}
			}
			else
			{	
				T--;
				index=end;
				if(T==0)
				{	
					System.out.println(end);
					break;
				}
			}
			
			
		}
		
	}
	private static int checkCycle(int firstStart, int start, int end, int n) {
		
		if(firstStart==end)
		{	
			return n;
		}
		if(visited[end])
		{	
			return 0;
		}
		visited[end]=true;
		int ret;
		ret=checkCycle(firstStart,end,choicePepoleIndex[end].get(0),n+1);
		return ret;
	}

}
