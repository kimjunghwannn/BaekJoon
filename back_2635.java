package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_2635 {
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int i=n/2;
		if(n%2!=0)
			i++;
		int max=0;
		Queue <Integer>queue = null;
		
		for(;i<=n;)
		{
			int length=2;
			Queue<Integer>test=new LinkedList<>();
			
			int a=n;
			int b=i;
			test.add(a);
			while(true) {
				test.add(b);
				int change=b;
				b=a-b;
				a=change;
				if(b<0)
					break;
				length++;
			}
			if(max<length)
			{
				max=length;
				queue=new LinkedList<>(test);
			}
			i++;
		}
		System.out.println(max);
		for(int a: queue)
			System.out.print(a+" ");
	}
}
