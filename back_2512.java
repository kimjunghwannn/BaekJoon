package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2512 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String input[]=id.readLine().split(" ");
		int cityvalue[]=new int[n];
		long sum=0;
		int nowmoney;
		int i;
		int highsu=0;
		for(i=0;i<n;i++) {
			cityvalue[i]=Integer.parseInt(input[i]);
			if(highsu<cityvalue[i])
				highsu=cityvalue[i];
			sum+=cityvalue[i];
		}
		nowmoney=Integer.parseInt(id.readLine());
		if(sum<=nowmoney) {
			System.out.println(highsu);
			System.exit(0);
		}
		Arrays.sort(cityvalue);
		int avsue=nowmoney/n;
		int namoji=nowmoney%n;
		int start=0;
		while(true)
		{
		if(cityvalue[start]>avsue&&namoji<n-start)
			break;
		for(i=start;i<n;i++)
		{	
			if(cityvalue[i]<avsue)
				namoji+=avsue-cityvalue[i];
			else if(cityvalue[i]>avsue)
			{
				start=i;
				break;
			}
		}
		avsue=avsue+(namoji/(n-i));
		namoji=namoji%(n-i);
		}

		System.out.println(avsue);
		
	}
}
