package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1652 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(id.readLine());
		boolean map[][]=new boolean [a][a];
		for(int i=0;i<a;i++)
		{	
		
			String input=id.readLine();
			for(int j=0;j<a;j++)
			{
				if(input.charAt(j)=='X')
					map[i][j]=true;
			}
		}
		int y=0;
		
		for(int i=0;i<a;i++)
		{
			int two=0;
			int real=0;
			for(int j=0;j<a;j++)
			{
				if(map[j][i])
				{	
					if(two>=2)
						real++;
					two=0;
				}
				else if(!map[j][i])
					two++;
			}
			if(two>=2)
				real++;
			y+=real;				
			
		}
		int x=0;
		for(int i=0;i<a;i++)
		{
			int two=0;
			int real=0;
			for(int j=0;j<a;j++)
			{
				if(map[i][j])
				{	
					if(two>=2)
						real++;
					two=0;
				}
				else if(!map[i][j])
					two++;
			}
			if(two>=2)
				real++;
			x+=real;		
		}
		System.out.println(x+" "+y);
	}
}
