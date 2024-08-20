package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_19941 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int k=Integer.parseInt(input[1]);
		String input2=id.readLine();
		boolean checkH[]=new boolean [n];
		int count=0;
		for(int i=0;i<n;i++)
		{
			int first=0;
			if(input2.charAt(i)=='H')
				continue;
			else
			{
				for(int l=k;l>=1;l--)
				{
					if(i-l<0||checkH[i-l])
						continue;
					if(input2.charAt(i-l)=='H')
					{
						checkH[i-l]=true;
						count++;
						first=1;
						break;
					}
				}
				if(first!=1)
				{
					for(int j=1;j<=k;j++)
				{
					if(i+j>=n||checkH[i+j])
						continue;
					if(input2.charAt(i+j)=='H')
					{
						checkH[i+j]=true;
						count++;
						break;
					}
				}
				}
			
			}
		}
		System.out.println(count);
	}
}
