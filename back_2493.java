package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2493 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String su[]=id.readLine().split(" ");
		int toplengh[]=new int [n];
		for(int i=0;i<su.length;i++)
			toplengh[i]=Integer.parseInt(su[i]);
		int nowhigh=toplengh[n-1];
		int check[]=new int [n];
		int lasttopindex=n-1;
		int mintopindex=n-1;
		int mintop=toplengh[n-1];
		boolean check_top[]=new boolean[n];
		for(int i=n-2;i>=0;i--)
		{	
			
			if(toplengh[i]<mintop)
			{
				mintop=toplengh[i];
				mintopindex=i;
			}
				
			else if(mintop<toplengh[i]&&toplengh[i]<nowhigh)
			{
				for(int k=mintopindex;k<n;k++)
				{
					if(toplengh[i]<toplengh[k])
							break;
					if(check_top[k]==false)
					{
						check[k]=i+1;
						check_top[k]=true;
					}
				}
				mintop=toplengh[i];
				mintopindex=i;
			}
			
			else if(toplengh[i]>nowhigh)
			{
				for(int j=lasttopindex;j>i;j--)
				{
					if(check_top[j]==false)
					{
						check[j]=i+1;
						check_top[j]=true;
					}
					
				}
				lasttopindex=i;
				nowhigh=toplengh[i];
				mintop=toplengh[i];
				mintopindex=i;
			}
		}
		check[0]=0;
		for(int a=0;a<n;a++)
			System.out.print(check[a]+" ");
	}
}
