package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1049 {
	public static int findMin(int[][]array, int firstindex) {
		int minvalue=array[0][firstindex];
		for(int i=1;i<array.length;i++)
		{
			int currentValue=array[i][firstindex];
			if(currentValue<minvalue)
				minvalue=currentValue;
		}
		return minvalue;
	}
	public static void main(String []args) throws IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		String[] input= id.readLine().split(" ");
		int changeline=Integer.parseInt(input[0]);
		int brandsu=Integer.parseInt(input[1]);
		int price[][]=new int[brandsu][2];
		for(int i=0;i<brandsu;i++)
		{
			input=id.readLine().split(" ");
			price[i][1]=Integer.parseInt(input[1]);
			price[i][0]=Integer.parseInt(input[0]);
		}
		int minone=findMin(price,1);
		int minsix=findMin(price,0);
		if(changeline<6)
		{
			if((changeline%6)*minone<minsix)
			System.out.print(minone*changeline);
			else
				System.out.print(minsix);
			System.exit(0);
		}
		if(minone*6<=minsix)
		{
			System.out.print(changeline*minone);
		}
		else
		{
			if((changeline%6)*minone<minsix)
				System.out.print((changeline/6)*minsix+(changeline%6)*minone);
			else
				System.out.print(((changeline/6)+1)*minsix);
		}
	}
}
