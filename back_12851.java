package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_12851 {
	static class doing {
		public int now;
		public int time;
		public doing(int now,int time) {
			this.now=now;
			this.time=time;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		Queue <doing>a=new LinkedList<>();
		String input[]=id.readLine().split(" ");
		int start=Integer.parseInt(input[0]);
		int end=Integer.parseInt(input[1]);
		a.add(new doing(start,0));
		boolean check[]=new boolean [100001];
		int ans1=Integer.MAX_VALUE,ans2=0;
		while(!a.isEmpty()) {
			doing b=a.poll();
			
			check[b.now]=true;
			
			if(ans1<b.time) break;
			
			if(b.now==end){
				ans1 = b.time;
				ans2++;
				continue;
			}
			if(b.now>0&&!check[b.now-1])
			{
				a.add(new doing(b.now-1,b.time+1));
			}	
			if(b.now<100000&&!check[b.now+1])
			{
				a.add(new doing(b.now+1,b.time+1));
				
			}
			if(b.now<=50000&&!check[b.now*2])
			{
				a.add(new doing(b.now*2,b.time+1));
				
			}
		}
		System.out.println(ans1+" "+ans2);
	}
}