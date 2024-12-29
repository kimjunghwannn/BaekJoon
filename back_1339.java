package algo;

import java.util.*;
import java.io.*;
public class back_1339 
{
	static Map<Character,Integer> alphabetValueMap=new HashMap<>();
	static Map<Integer,Boolean> isDigitAssigned=new HashMap<>();
	static String wordArray[];
	static Set<Character> alphabetSet=new HashSet<>();
	static  Character[] alphabetArray;
	static int answer=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		wordArray=new String [N];
		for(int i=0;i<N;i++)
		{	
			wordArray[i]=br.readLine();
			for(int j=0;j<wordArray[i].length();j++)
				alphabetSet.add(wordArray[i].charAt(j));
		}
		alphabetArray = alphabetSet.toArray(new Character[0]);
		
		mapDigitsToAlphabet(0);
		calculateAlphabetValue();
		System.out.println(answer);
	}

	private static void mapDigitsToAlphabet(int alphabetIndex) 
	{
		if(alphabetIndex==alphabetArray.length)
		{
			return;
		}
		
		for(int i=0;i<=9;i++)
		{
			if(isDigitAssigned.get(i)!=null&&isDigitAssigned.get(i)==true)
				continue;
			alphabetValueMap.put(alphabetArray[alphabetIndex], i);
			isDigitAssigned.put(i,true);
			
			mapDigitsToAlphabet(alphabetIndex+1);
			
			alphabetValueMap.remove(alphabetArray[alphabetIndex]);
			isDigitAssigned.remove(i);
		}
	}

	private static void calculateAlphabetValue() 
	{
		int sum=0;
		for(int i=0;i<wordArray.length;i++)
		{
			String a="";
			for(int j=0;j<wordArray[i].length();j++)
			{
				a+=alphabetValueMap.get(wordArray[i].charAt(j));
			}
			sum+=Integer.parseInt(a);
		}
		answer=Math.max(answer, sum);
		
	}

}
