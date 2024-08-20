package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class staris
{
	public int n;
	public staris()
	{
		this.n=0;
	}
	public staris(int n) {
		this.n=n;
		
	}
}
public class back_2579 {
	
	static staris max[][];
	static int stairsTable[];
	static int N;
	static int answer;
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader( System.in));
		N=Integer.parseInt(id.readLine());
		stairsTable=new int [N+1];
		max=new staris [N+1][3];
		for(int i=0;i<=N;i++)
		{
			for(int j=0;j<3;j++)
			{
				max[i][j]=new staris();
			}
		}
		
		
		
		for(int i=1;i<=N;i++)
		{
			int value=Integer.parseInt(id.readLine());
			stairsTable[i]=value;
		}
		findMax(0,0,0);
		System.out.println(answer);
	}
	private static void findMax(int index, int sequence, int total) {
		
		if(index>N||sequence==3)
			return;
		int nowtotal=total+stairsTable[index];
		if(index==N)
		{
			answer=Math.max(nowtotal, answer);
			return;
		}
		if(index!=0&&max[index][sequence].n>=nowtotal)
		{
				return;
		}
		if(total>max[index][sequence].n)
		{
			max[index][sequence].n=total;
		}
		findMax(index+1,sequence+1,nowtotal);
		findMax(index+2,1,nowtotal);
	}
}
