package algo;

import java.util.*;
import java.io.*;
public class back_5582 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String str1=br.readLine();
		String str2=br.readLine();
		Map<String,Boolean> map=new HashMap<>();
		String answer="";
		for(int i=0;i<str1.length();i++)
		{
			for(int j=i+1;j<str1.length()+1;j++)
			{
				map.put(str1.substring(i,j),true);
			}
		}
		
		for(int i=0;i<str2.length();i++)
		{
			for(int j=i+1;j<str2.length()+1;j++)
			{
				String test=str2.substring(i,j);
				if(map.get(test)!=null)
				{
					if(test.length()>answer.length())
						answer=test;
				}
			}
		}
		System.out.println(answer.length());
	}
}
