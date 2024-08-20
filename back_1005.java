package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_1005 {
	static class city{
		public int number;
		public int depth;
		city(int number,int depth){
			this.number=number;
			this.depth=depth;
		}
	}
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int tastcase=Integer.parseInt(id.readLine());
		while(tastcase>0) {
		tastcase--;
		String input[]=id.readLine().split(" ");
		int citynumber=Integer.parseInt(input[0]);
		int roadnumber=Integer.parseInt(input[1]);
		String input2[]=id.readLine().split(" ");
		int cityvalue[]=new int [citynumber+1];
		boolean map[][]=new boolean[citynumber+1][citynumber+1];
		int result[]=new int [citynumber+1];
		int line[]=new int[citynumber+1];
		for(int i=1;i<=citynumber;i++)
			cityvalue[i]=Integer.parseInt(input2[i-1]);
		for(int i=0;i<roadnumber;i++)
		{
			input=id.readLine().split(" ");
			map[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=true;
			line[Integer.parseInt(input[1])]++;
		}
		int finished=Integer.parseInt(id.readLine());
		Queue<Integer> vertex=new LinkedList<>();
		for(int i=1;i<=citynumber;i++)
		{
			if(line[i]==0)
				{
					vertex.add(i);
					result[i]=cityvalue[i];
				}
		}
		while(true) 
		{
			int nowvertex=vertex.poll();
			if(nowvertex==finished)
			{
				System.out.println(result[finished]);
				break;
			}
			for(int i=1;i<=citynumber;i++)
			{
				if(map[nowvertex][i]==true)
				{
					result[i]=Math.max(result[i],result[nowvertex]+cityvalue[i]);
					line[i]--;
				}
				if(line[i]==0)
					vertex.add(i);
			}
		}
		
		
		}
		
		
	}
}
