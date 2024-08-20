package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class back_10431 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		int tasecase=Integer.parseInt(input);
		int n=1;
		while(tasecase>=n) {
			String input_cm[]=id.readLine().split(" ");
			LinkedList<Integer> new_cm=new LinkedList<>();
			int count=0;
			new_cm.add(Integer.parseInt(input_cm[1]));
			for(int i=2;i<=20;i++)
			{
				int newstu=Integer.parseInt(input_cm[i]);
				
				if(newstu<new_cm.get(i-2))
				{	
					
					int j;
					for(j=0;j<i;j++)
					{
						if(new_cm.get(j)<newstu)
							continue;
						else
							break;
					}
					new_cm.add(j, newstu);
					count+=i-j-1;
				}
				else
				{
					new_cm.add(newstu);
					continue;
				}
				
			}
			System.out.println(n+" "+count);
			n++;
		}
	}
}
