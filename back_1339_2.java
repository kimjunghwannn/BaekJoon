package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class back_1339_2 
{
	static class Alphabet implements Comparable<Alphabet>
	{
		public int value;
		public char alphabet;
		
		public Alphabet(int value,char alphabet)
		{
			this.value=value;
			this.alphabet=alphabet;
		}
		@Override
		public int compareTo(Alphabet a2)
		{
			return Integer.compare(a2.value,this.value );
		}
	}
	static long POSITION_VALUES []= {1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
	static Map<Character,Integer> alphabetValueMap=new HashMap<>();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String words[]=new String [N];
		Alphabet alphabets[]=intializeAlphabets();
		//A-Z alphabets[0]=value=0 alphabet=A 
		
		
		for(int i=0;i<N;i++)
		{	
			words[i]=br.readLine();
			setAlphabetValues(words[i], alphabets);
		}
		
		PriorityQueue<Alphabet> alphabetPQ=new PriorityQueue<>();
		for(int i=0;i<26;i++)
			if(alphabets[i].value!=0)
				alphabetPQ.add(alphabets[i]);
		
		int value=9;
		while(!alphabetPQ.isEmpty())
		{
			Alphabet nowAlphabet=alphabetPQ.poll();
			alphabetValueMap.put(nowAlphabet.alphabet, value);
			value--;
		}
		
		
		int sum=0;
		for(int i=0;i<words.length;i++)
		{
			String a="";
			for(int j=0;j<words[i].length();j++)
			{
				a+=alphabetValueMap.get(words[i].charAt(j));
			}
			sum+=Integer.parseInt(a);
		}
		
		
		System.out.println(sum);
	}
	private static void setAlphabetValues(String word, Alphabet[] alphabets) 
	{
		for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'A'; 
            alphabets[index].value += POSITION_VALUES[word.length() - i - 1];
        }
		
	}
	private static Alphabet[] intializeAlphabets() {
		Alphabet alphabets[]=new Alphabet[26];
		for(int i=0;i<26;i++)
			alphabets[i]=new Alphabet(0,(char) ('A' + i));
		return alphabets;
	}
}
