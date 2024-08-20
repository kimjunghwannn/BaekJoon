package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1183 {
	public static void main(String args[]) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		
		String input=id.readLine();
		int n=Integer.parseInt(input);
		int times[][]=new int [n][2];
		int timegab[]=new int [n];
		int answer=0;
		for(int i=0;i<n;i++)
		{
			String inputtimes[]=id.readLine().split(" ");
			times[i][0]=Integer.parseInt(inputtimes[0]);
			times[i][1]=Integer.parseInt(inputtimes[1]);
			timegab[i]=times[i][1]-times[i][0];
		}
		Arrays.sort(timegab);
		int[] columnValues = Arrays.stream(times)
                .mapToInt(row -> row[0])
                .toArray();
		int minValue = Arrays.stream(columnValues).min().orElseThrow();
		if(n%2==1)
		{
			System.out.print(1);
			System.exit(0);
		}
		for(int i=0;i<timegab.length;i++)
		{
			int a=0;
			int b=0;
			int chagetime_0;
			int chagetime_1;
			for(int j=0;j<times.length;j++)
			{
				chagetime_0=times[j][0];
				chagetime_1=times[j][0];
				chagetime_0+=timegab[i];
				chagetime_1+=timegab[i]+1;
				a+=Math.abs(chagetime_0-times[j][1]);
				b+=Math.abs(chagetime_1-times[j][1]);
			}
			if(a==b)
			{	
				if(minValue-timegab[i]<0)
					continue;
				if(timegab[i]<0)
					answer=(timegab[i]*-1)+timegab[i+1]+1;
				else
				    answer=timegab[i+1]-timegab[i]+1;
			}
		}
		if(answer==0)
			answer++;
		System.out.println(answer);
	}
}
