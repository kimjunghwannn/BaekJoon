package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2467 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String input[]=id.readLine().split(" ");
		int box[]=new int[n];
		int turningIndex=0;
		boolean one=false;
		int acidsum;
		int alkalinesum;
		for(int i=0;i<n;i++)
		{	
			int a=Integer.parseInt(input[i]);
			if(i>0&&box[i-1]<0&&box[i]>=0&&!one)
				{
					turningIndex=i;
					one=true;
				}
			box[i]=a;
		}
		if(box[turningIndex]==0)
		{
			if(turningIndex>0)
			{
				acidsum=Math.abs(box[turningIndex]+box[turningIndex-1]);
			}
			if(box.length-1>turningIndex)
			{
				alkalinesum=Math.abs(box[turningIndex]+box[turningIndex+1]);
			}
		}
		else
		{	
			if(turningIndex>1)
			{
				acidsum=Math.abs(box[turningIndex-2]+box[turningIndex-1]);
			}
			if(box.length-1>turningIndex)
			{
				alkalinesum=Math.abs(box[turningIndex]+box[turningIndex+1]);
			}
			
		}
	}
}