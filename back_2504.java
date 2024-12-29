package algo;

import java.util.*;
import java.io.*;
public class back_2504 
{
	static Queue<Character> bracket=new LinkedList<>(); //"[]"
	static StringBuilder sb=new StringBuilder();
	
	static int nestingLevel = 0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		String input=br.readLine();
		
		
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)=='('||input.charAt(i)==')')
				processSquareBracket(input.charAt(i));
			if(input.charAt(i)=='['||input.charAt(i)==']')
				processroundBrackets(input.charAt(i));
		}
	}
	static public void processSquareBracket(char input ) 
	{
	   if(input=='[')
	   {
		   if(!bracket.isEmpty())
		   {
			   sb.append("*(2");
			   nestingLevel++;
		   }
		   else
			   sb.append("2");
	   }
	   //']'
	   else
	   {
		   if(bracket.isEmpty()||bracket.peek()=='(')
		   {
			  System.out.println(0);
			  System.exit(0);
		   }
		   if(nestingLevel==bracket.size())
		   {
			   nestingLevel--;
			   sb.append(")");
		   }
		   else if(nestingLevel<bracket.size())
		   {
			   sb.append("+");
		   }
	   }
	}
	static public void processroundBrackets(char input ) 
	{
		
	}
}
