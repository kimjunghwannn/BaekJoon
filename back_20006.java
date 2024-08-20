package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class back_20006 {
	static class player implements Comparable<player> {
		public int level;
		public String name;
		public player(int level,String name) {
			this.name=name;
			this.level=level;
		}
		public int compareTo(player other) {
			return this.name.compareTo(other.name);
		}
	}
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(System.out));
		String input[]=id.readLine().split(" ");
		int personsu=Integer.parseInt(input[0]);
		int line=Integer.parseInt(input[1]);
		List<player> a[]=new ArrayList[personsu];
		int leveldeadline[]=new int [personsu];
		  for (int i = 0; i < personsu; i++) {
	            a[i] = new ArrayList<>();
	            
	        }

		
		for(int i=0;i<personsu;i++)
		{
			input=id.readLine().split(" ");
			player aplayer=new player(Integer.parseInt(input[0]),input[1]);
			for(int j=0;j<a.length;j++)
			{
				if(a[j].size()==0||((a[j].size()<line)&&
						(leveldeadline[j]+10>=aplayer.level&&
						 leveldeadline[j]-10<=aplayer.level)))
				{
					if(a[j].size()==0)
					{	
						leveldeadline[j]=aplayer.level;
					}
					a[j].add(aplayer);
					break;
				}
				
			}
		}
	
		
		for(int i=0;i<personsu;i++)
		{
			Collections.sort(a[i]);
			if(a[i].size()==line)
				writer.write("Started!");
			
			else if(a[i].size()!=0)
				writer.write("Waiting!");
				
			writer.newLine();
			for(int j=0;j<a[i].size();j++)
				{
					writer.write(Integer.toString(a[i].get(j).level)+" "+a[i].get(j).name);
					writer.newLine();
				}
		}
		writer.flush();
	}
}
