package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_21921 {
	public static void main(String []args) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int day=Integer.parseInt(input[0]);
		int longer=Integer.parseInt(input[1]);
		int dayinfom[]=new int [day];
		String input2[]=id.readLine().split(" ");
		int highsu=0;
		int sum[]=new int [day-(longer-1)];
		int countsum=0;
		int count=0;
		for(int i=1;i<=day;i++)
		{	
			dayinfom[i-1]=Integer.parseInt(input2[i-1]);
			countsum+=dayinfom[i-1];
			if(i>=longer)
			{
				sum[count++]=countsum;
				countsum-=dayinfom[i-longer];
			}
			
			if(highsu<dayinfom[i-1])
				highsu=dayinfom[i-1];
			
		}
		if(highsu==0)
		{
			System.out.println("SAD");
			System.exit(0);
		}
		Arrays.sort(sum);
		int samehigh=1;
		for(int i=sum.length-2;i>=0;i--)
		{
			if(sum[sum.length-1]!=sum[i])
				break;
			samehigh++;
		}
		System.out.println(sum[sum.length-1]);
		System.out.println(samehigh);
	}
}
