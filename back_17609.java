package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_17609 {
	static class point {
		public int left;
		public int right;
		public int check;
		public point (int left,int right) {
			this.left=left;
			this.right=right;
			this.check=0;
		}
		public point (int left,int right,int check) {
			this.left=left;
			this.right=right;
			this.check=check;
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		for(int i=0;i<n;i++)
		{
			String input=id.readLine();				
			int check=0;
			int left=0;
			int right=input.length()-1;
			Queue <point>queue=new LinkedList<>();
			queue.add(new point(left,right));
			int small=0;
			while(!queue.isEmpty()) {
				
				point now=queue.poll();
				int nleft=now.left;
				int nright=now.right;
				if(nleft>=nright)
					break;
				small=now.check;
				//System.out.println(nleft+" "+nright+" "+small);
				if(now.check>1)
				{
					if(!queue.isEmpty()&&small!=2)
					{
						System.out.println(now.check);
						break;
					}
					else {
						continue;
					}
				}
				if(input.charAt(nleft)!=input.charAt(nright))
				{	
					now.check++;
					if(now.check==2)
						continue;
					int fake_l=nleft+1;
					int fake_r=nright-1;
					if(input.charAt(fake_l)==input.charAt(nright))
					{	
						queue.add(new point(fake_l,nright,now.check));
					}
					if(input.charAt(fake_r)==input.charAt(nleft))
					{	
						nright=fake_r;
						queue.add(new point(nleft,fake_r,now.check));
						continue;
					}
					now.check++;
					if(queue.isEmpty())
					{
					System.out.println(now.check);
					}
				}
				else 
				{
					nleft++;
					nright--;
					queue.add(new point(nleft,nright,now.check));
				}
			}
			if(small<2)
				System.out.println(small);
		}
	}
}
