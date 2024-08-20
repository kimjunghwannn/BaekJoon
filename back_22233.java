package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class back_22233 {
	public static void main(String args[]) throws IOException {
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[]=id.readLine().split(" ");
		int keyword=Integer.parseInt(input[0]);
		int board=Integer.parseInt(input[1]);
		String keywords[]=new String[keyword];
		boolean check[]=new boolean[keyword];
		int i;
		for(i=0;i<keyword;i++)
			keywords[i]=id.readLine();
		Arrays.sort(keywords);
		int answer=keyword;
		for(i=0;i<board;i++)
		{
			String input2[]=id.readLine().split(",");
			for(int j=0;j<input2.length;j++)
			{
				int start=0;
				int end=keyword;
				while(end>start) {
					int midlle=(end+start)/2;
					if(keywords[midlle].compareTo(input2[j])<0)
						start=midlle+1;
					else {
						end=midlle;
					}
				}
				if(start>=keyword)
					continue;
				if(keywords[start].equals(input2[j])&&check[start]==false)
				{
					check[start]=true;
					answer--;
				}
			}
			writer.write(Integer.toString(answer));
			writer.newLine();
		}
		writer.flush();
	}
}
