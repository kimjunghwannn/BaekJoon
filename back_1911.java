package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class back_1911 {
	static class hole {
		public int start;
		public int end;
		public hole(int start,int end) {
			this.start=start;
			this.end=end;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int cm=Integer.parseInt(input[1]);
		hole holes[]=new hole[n];
		for(int i=0;i<n;i++)
		{
			String input2[]=id.readLine().split(" ");
			int start=Integer.parseInt(input2[0]);
			int end=Integer.parseInt(input2[1]);
			holes[i]=new hole(start,end);
		}
		Comparator<hole> comarator = new Comparator<hole>() {
			public int compare(hole hole1, hole hole2)
			{
				return hole1.start-hole2.start;
			}
		};
		Arrays.sort(holes,comarator);
		int pan=0;
		int now=-1;
		for(int i=0;i<n;i++)
		{
			int nowpan=0;
			if(now>=holes[i].end-1)
				continue;
			if(now>=holes[i].start)
				holes[i].start=now+1;
			nowpan=(holes[i].end-holes[i].start)/cm;
			
			if((holes[i].end-holes[i].start)%cm!=0||(holes[i].end-holes[i].start)/cm==0)
				nowpan++;
			now=holes[i].start+(nowpan*cm)-1;
			pan+=nowpan;
			
		}
		System.out.println(pan);
	}
}
