package algo;
import java.io.*;
import java.util.*;

public class back_2179 {
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		String words[]=new String [N];
		for(int i=0;i<N;i++)
			words[i]=id.readLine();
		Map<String,LinkedList<String>> wordMap=new HashMap();
		String S="";
		String T="";
		int max=0;
		for(int i=0;i<words.length;i++)
		{
			String nowWords="";
			for(int j=0;j<words[i].length();j++)
			{
				nowWords+=words[i].charAt(j);
				if(wordMap.get(nowWords)==null)
					wordMap.put(nowWords, new LinkedList<>());
				wordMap.get(nowWords).add(words[i]);
			}
		}
		for(int i=0;i<N;i++)
		{
			String nowWords="";
			for(int j=0;j<words[i].length();j++)
			{
				
				nowWords+=words[i].charAt(j);
				if(wordMap.get(nowWords)==null)
					break;
				if(max<j+1)
				{
					for(String a: wordMap.get(nowWords))
					{
						if(!a.equals(words[i]))
						{	
							S=words[i];
							T=a;
							max=j+1;
							break;
						}
					}
					
					
					
				}
			}
		}
		System.out.println(S);
		System.out.println(T);
	}
}
