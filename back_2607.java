package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class back_2607 {
	public static void main(String args[]) throws NumberFormatException, IOException 
	{
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		String words[]=new String[n];
		int answer=0;
		int map[]=new int [26];
		for(int i=0;i<n;i++)
		{
			words[i]=id.readLine();
			
		}
		for(int j=0;j<words[0].length();j++)
			{
				map[words[0].charAt(j)-'A']++;
			}
		for(int i=1;i<n;i++)
		{
			int aLength=words[0].length();
			int bLength=words[i].length();
			if(Math.abs(aLength-bLength)>1)
				continue;
			int lengthDif=aLength-bLength;
			int testMap[];
			testMap=map.clone();
			for(int j=0;j<words[i].length();j++)
			{
				if(testMap[words[i].charAt(j)-'A']>0)
				{	
					testMap[words[i].charAt(j)-'A']--;
					aLength--;
					bLength--;
				}
			}
			if(lengthDif==-1&&aLength==0&&bLength==1)
				answer++;
			if(lengthDif==1&&aLength==1&&bLength==0)
				answer++;
			if(lengthDif==0&&aLength==1&&bLength==1)
				answer++;
			if(lengthDif==0&&aLength==0&&bLength==0)
				answer++;
		}
		System.out.println(answer);
		
	}
}