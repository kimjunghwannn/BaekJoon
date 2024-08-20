package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class back_2621 {
	static class card implements Comparable<card>{
		public String color;
		public int number;
		
		public card(String color,int number) {
			this.color=color;
			this.number=number;
		}
		
		public int compareTo(card other) {
			return Integer.compare(this.number, other.number);
		}

		

		
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		card[]a=new card[5];
		Set<String> set= new HashSet<>();
		boolean samecolor=false;
		boolean onetotwo=true;
		boolean	foursame=false;
		boolean threesame=false;
		boolean twosame = false;
		boolean twoandtwosame=false;
		Map<Integer,Integer> map=new LinkedHashMap<>();
		
		for(int i=0;i<5;i++)
		{
			String input[]=id.readLine().split(" ");
			a[i]=new card(input[0],Integer.parseInt(input[1]));
			set.add(input[0]);
			map.put(Integer.parseInt(input[1]), map.get(Integer.parseInt(input[1]))+1);
		}
		Arrays.sort(a);
		if(set.size()==1)
			samecolor=true;
		int max=0;
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			if(max<entry.getKey())
				max=entry.getKey();
			if(twosame&&entry.getValue()==2)
				twoandtwosame=true;
			if(entry.getValue()==2)
				twosame=true;
			else if(entry.getValue()==3)
				threesame=true;
			else if(entry.getValue()==4)
				foursame=true;
		}
		int check=a[0].number;
		for(int i=1;i<5;i++)
		{
			if(check!=a[i].number+1)
				{
					onetotwo=false;
					break;
				}
			check=a[i].number+1;
		}
		int answer=0;
		if(samecolor==true)
		{
			if(onetotwo)
				answer=900+a[4].number;
			else
				answer=600+a[4].number;
		}
		if(foursame)
		{
			answer=Math.max(a[2].number+800, answer);
		}
		if(threesame)
		{
			if(twosame)
			{	
				int two=0;
				if(a[2].number!=a[0].number)
					two=a[0].number;
				else
					two=a[4].number;
				answer=Math.max((a[2].number*10)+700+two, answer);
			}
			else {
				answer=Math.max(a[2].number+200, answer);

			}
		}
		if(onetotwo)
		{
			answer=Math.max(a[4].number+500, answer);
		}
		if(twosame)
		{
			if(twoandtwosame)
			{
				int small=0;
				for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
					if(entry.getValue()!=max)
					{
						small=entry.getKey();
						break;
					}
				}
			}
			else {
				
			}
		}
	}
}
