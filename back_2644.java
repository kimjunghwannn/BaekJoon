package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_2644 {
	static class doing{
		public int now;
		public int n;
		public doing(int now,int n) {
			this.now=now;
			this.n=n;
		}
	}
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader id= new BufferedReader (new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		boolean check[]=new boolean [n+1];
		LinkedList<Integer> a[]=new LinkedList [n+1];
		for(int i=1;i<=n;i++)
			a[i]=new LinkedList<>();
		
		String input[]=id.readLine().split(" ");
		int start=Integer.parseInt(input[0]); int end=Integer.parseInt(input[1]);
		int relation=Integer.parseInt(id.readLine());
		for(int i=0;i<relation;i++)
		{
			input=id.readLine().split(" ");
			int start2=Integer.parseInt(input[0]); int end2=Integer.parseInt(input[1]);
			a[start2].add(end2);
			a[end2].add(start2);
		}
		Queue<doing> b=new LinkedList<>();
		b.add(new doing(start,0));
		
		while(!b.isEmpty()) {
			doing c=b.poll();
			if(c.now==end)
			{
				System.out.println(c.n);
				System.exit(0);
			}
			check[c.now]=true;
			for(int x:a[c.now])
			{
				if(check[x])
					continue;
				b.add(new doing(x,c.n+1));
			}
		}
		System.out.println(-1);
	}
}
