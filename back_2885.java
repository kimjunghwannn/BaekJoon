package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2885 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		int wanteat=Integer.parseInt(id.readLine());
		int now=1;
		while(true) {
			if(wanteat<=now)
				break;
			now*=2;
		}
		int n=0;
		
		if(now==wanteat)
		{
			System.out.println(now+" "+0);
			System.exit(0);
		}
		int answer=now;
		while(true) {
			if(wanteat==0)
				break;
			now/=2;
			n++;
			if(wanteat>=now)
				wanteat-=now;
			
		}
		System.out.println(answer+" "+n);
	}
}
