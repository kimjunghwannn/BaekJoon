package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class back_2141 {
	static class village{
		public long now;
		public long person;
		public long total;
		public village(long now,long person) {
			this.now=now;
			this.person=person;
		}
		public void setTotal(long total) {
			this.total=total;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		village a[]=new village[n];
		
		
		for(int i=0;i<n;i++)
		{
			String input[]=id.readLine().split(" ");
			long now=Integer.parseInt(input[0]);
			long personsu=Integer.parseInt(input[1]);
			a[i]=new village(now,personsu);
		}
		Comparator<village> comparator=new Comparator<village>() {
			public int compare(village v1,village v2) {
				return Long.compare(v1.now, v2.now);
			}
		};
		Arrays.sort(a,comparator);
		long sum=0;
		for(int i=0;i<n;i++)
		{	
			sum+=a[i].person;
			a[i].setTotal(sum);
		}
		
		for(int i=0;i<n;i++)
		{
			
			if(a[i].total>=(sum/2))
			{
				System.out.println(a[i].now);
				break;
			}
		}
		
	}
}

