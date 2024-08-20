package algo;
import java.util.*;
import java.io.*;
public class back_2805 
{
	static long tree[];
	static long neededTreeLen;
	public static void main(String args[]) throws IOException
	{
		BufferedReader id = new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int treeN=Integer.parseInt(input[0]);
		neededTreeLen=Integer.parseInt(input[1]);
		tree=new long [treeN];
		String input2[]=id.readLine().split(" ");
		for(int i=0;i<treeN;i++)
			tree[i]=Integer.parseInt(input2[i]);
		Arrays.sort(tree);
		long start=0;
		long end=tree[treeN-1]+1;
		while(start<end)
		{
			long middle=(start+end)/2;
			if(needMoreTreeLen(middle))
			{
				end=middle;
			}
			else
				start=middle+1;
			
		}
		System.out.println(end-1);
	}

	private static boolean needMoreTreeLen(long height) 
	{
		long sum=0;
		for(int i=0;i<tree.length;i++)
		{	
			long dif=tree[i]-height;
			if(dif>0)
			sum+=dif;
		}
		if(neededTreeLen==sum)
		{
			System.out.println(height);
			System.exit(0);
		}
		else if(neededTreeLen>sum)
			return true;
		return false;
	}
	

}
