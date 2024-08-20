package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_2309 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int cm[]=new int [9];
		int sum=0;
		for(int i=0;i<9;i++)
		{
			cm[i]= Integer.parseInt(id.readLine());
			sum+=cm[i];
		
		}
		int i;
		int j = 0;
		boolean check=false;
		for(i=0;i<9;i++)
		{
			for(j=i+1;j<9;j++)
			{
				int testsum=sum;
				testsum=(sum-cm[i])-cm[j];
				if(testsum==100)
				{
					check=true;
					break;
				}
			}
			if(check)
				break;
		}
		int noi=cm[i];
		int noj=cm[j];
		Arrays.sort(cm);
		for(int q=0;q<9;q++)
		{
			if(cm[q]==noi||cm[q]==noj)
				continue;
			System.out.println(cm[q]);
		}
	}
}
