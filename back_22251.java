package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_22251 {
	static int  numbers[][] = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9}
	static int N,P,K,X;
	static int count=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String inputs[]=id.readLine().split(" ");
		N=Integer.parseInt(inputs[0]);
		K=Integer.parseInt(inputs[1]);
		P=Integer.parseInt(inputs[2]);
		X=Integer.parseInt(inputs[3]);
		
		int now_digit[]=numToDigit(X);
		check(now_digit);
		System.out.println(count);
	}

	private static void check(int[] now_digit) {
		
		for(int i=1;i<=N;i++)
		{
			if(i==X)
				continue;
			if(can_reverse(i,now_digit))
				count++;
		}
	}

	private static boolean can_reverse(int target, int[] now_digit) {
		int target_digit[]=numToDigit(target);
		int diff=0;
		for(int i=0;i<target_digit.length;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(numbers[target_digit[i]][j]!=numbers[now_digit[i]][j])
					diff++;
				if(diff>P)
					return false;
			}
		}
		return true;
	}

	private static int[] numToDigit(int X) {
		int now_digit[]=new int [K];
		for(int i=0;i<K;i++)
		{
			now_digit[i]=X%10;
			X/=10;			
		}
		return now_digit;
	}
}
