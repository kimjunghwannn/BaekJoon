package algo;
import java.io.*;
import java.util.*;
public class back_2306 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String DNA=br.readLine();
		int dp[]=new int [DNA.length()+1];
		for(int i=2;i<=DNA.length();i++)
		{
			if(DNA.substring(i-2, i)=="at"||DNA.substring(i-2, i-1)=="gc")
			{
					dp[i]=2;
					if(i>=4)
						dp[i]+=dp[i-2];
					
			}
			else if(DNA.charAt(i-1)=='a'||DNA.charAt(i-1)=='g')
			{
				dp[i]=dp[i-1];
			}
			else
			{
				if(DNA.charAt(i-1)=='t')
				{
					for(int j=i-2;j>=1;j--)
					{
						if(DNA.charAt(j)=='a'&&DNA.charAt(j+1)!='t')
							dp[i]=dp[j-1]+2;
					}
				}
				if(DNA.charAt(i-1)=='c')
				{
					for(int j=i-2;j>=1;j--)
					{
						if(DNA.charAt(j)=='g'&&DNA.charAt(j+1)!='c')
							dp[i]=dp[j-1]+2;
					}
				}
			}
			System.out.println(i+" "+dp[i]);
		}
		System.out.println(dp[DNA.length()]);
	}

}
