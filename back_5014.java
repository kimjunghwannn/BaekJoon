package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_5014 {
	static class doing {
		public int n;
		public int floor;
		
		public doing(int n,int floor) {
			this.n=n;
			this.floor=floor;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String a[]=id.readLine().split(" ");
		int top=Integer.parseInt(a[0]);
		int now=Integer.parseInt(a[1]);
		int want=Integer.parseInt(a[2]);
		int up=Integer.parseInt(a[3]);
		int down=Integer.parseInt(a[4]);
		Queue<doing> q=new LinkedList<>();
		q.add(new doing(0,now));
		boolean check[]=new boolean [top+1];
		while(!q.isEmpty()) {
			doing b=q.poll();
			if(b.floor==want) {
				System.out.println(b.n);
				System.exit(0);
			}
			if(b.floor+up<=top&&!check[b.floor+up])
			{
				check[b.floor+up]=true;
				q.add(new doing(b.n+1,b.floor+up));
			}
			if(b.floor-down>0&&!check[b.floor-down])
			{
				check[b.floor-down]=true;
				q.add(new doing(b.n+1,b.floor-down));
			}
		}
		System.out.println("use the stairs");
	}
}
