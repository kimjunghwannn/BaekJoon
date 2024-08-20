package algo;
import java.io.*;
import java.util.*;
public class back_2631 {
	public static void main(String args[]) throws IOException 
	{
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		int table[]=new int [N];		
		for(int i=0;i<N;i++)
			table[i]=Integer.parseInt(id.readLine());
		int DP[]=new int [N];
		Arrays.fill(DP,1);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(table[i]>table[j])
					DP[i]=Math.max(DP[j]+1,DP[i]);
			}
		}
		Arrays.sort(DP);
		System.out.println(N-DP[N-1]);
	}
}
