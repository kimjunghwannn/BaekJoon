package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1193 {
	public static void main(String args[]) throws IOException {
		BufferedReader id= new BufferedReader (new InputStreamReader(System.in));
		String input=id.readLine();
		int n=Integer.parseInt(input);
		int count=1;
		int x=1;
		int y=1;
		int dx[]= {-1,+1};
		int dy[]= {+1,-1};
		int usedx=dx[0];
		int usedy=dy[0];
		if(x==1){

			System.out.println("1/1");
			System.exit(0);
		}
		for(int i=2;i<1000000;i++)
		{
			if(i%2==0)
				{
					x++;
					usedx=dx[0];
					usedy=dy[0];
					
				}
			else {
				y++;
				usedx=dx[1];
				usedy=dy[1];
			}
			count++;
			if(count==n)
			{
				System.out.println(y+"/"+x);
				System.exit(0);
			}
			for(int j=0;j<i-1;j++)
			{
				count++;
				y+=usedy;
				x+=usedx;
				if(count==n)
				{
					System.out.println(y+"/"+x);
					System.exit(0);
				}
			}
		}
	}
}
