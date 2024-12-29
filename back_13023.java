package algo;

import java.util.*;
import java.io.*;
public class back_13023 
{
	static LinkedList<Integer> linkedNodes[];
	static boolean visited[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		
		visited=new boolean [N];
		linkedNodes=new LinkedList [N];
		for(int i=0;i<N;i++)
			linkedNodes[i]=new LinkedList<>();
		
		for(int i=0;i<M;i++)
		{
			String input2[]=br.readLine().split(" ");
			linkedNodes[Integer.parseInt(input2[0])].add(Integer.parseInt(input2[1]));
			linkedNodes[Integer.parseInt(input2[1])].add(Integer.parseInt(input2[0]));
		}
		for(int i=0;i<N;i++)
		{	
			visited[i]=true;
			DFS(i,0);
			Arrays.fill(visited, false);
		}
		System.out.println(0);
	}
	private static void DFS(int index, int depth) 
	{
		if(depth==4)
		{
			System.out.println(1);
			System.exit(0);
		}
		
		for(int a : linkedNodes[index])
		{
			if(visited[a])
				continue;
			visited[a]=true;
			DFS(a,depth+1);
			visited[a]=false;
		}
	}

}
