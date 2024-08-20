package algo;

import java.io.*;
import java.util.*;
public class back_2304 {
	static class Stick
	{
		public int index;
		public int length;
		public Stick(int index,int length)
		{
			this.index=index;
			this.length=length;
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		Stick box[]=new Stick[N];
		
		for(int i=0;i<N;i++)
		{
			String input[]=id.readLine().split(" ");
			int index=Integer.parseInt(input[0]);
			int length=Integer.parseInt(input[1]);
			box[i]=new Stick(index-1,length);
		}
		Comparator<Stick> a=new Comparator<Stick>() {
			public int compare(Stick s1,Stick s2) {
				return s1.index-s2.index;
			}
		};
		Arrays.sort(box,a);
		int answer=0;
		int long_length=box[0].length;
		int longStickIndex=box[0].index;
		int shortInLong=0;
		int shortInLongIndex=0;
		int boxIndex=0;
		for(int i=1;i<N;i++)
		{
			if(box[i].length>long_length)
			{					
				if(boxIndex>0&&box[boxIndex-1].length>long_length)
				{	
					answer+=(box[i].index-(box[boxIndex-1].index+1))*box[i].length;
				
				}
				else
					answer+=(box[i].index-longStickIndex)*long_length;
				long_length=box[i].length;
				longStickIndex=box[i].index;
				shortInLong=0;
				shortInLongIndex=0;
				boxIndex=i;
				if(i==N-1)
					answer+=long_length;
			}
			else
			{
				if(box[i].length>=shortInLong)
				{
					shortInLongIndex=box[i].index;
					shortInLong=box[i].length;
					if(i==N-1)
					{	
						answer+=long_length;
						answer+=box[i].length*((box[i].index+1)-(longStickIndex+1));

					}
				}
				else
				{
					answer+=long_length;
					answer+=shortInLong*((shortInLongIndex+1)-(longStickIndex+1));
					long_length=box[i].length;
					longStickIndex=box[i].index;
					boxIndex=i;
					shortInLong=0;
					shortInLongIndex=0;
					if(i==N-1)
					{	
						answer+=long_length;
					}
				}
				
			}System.out.println(answer);
		}
		System.out.println(answer);
	}
}

