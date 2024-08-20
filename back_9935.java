package algo;
import java.io.*;
import java.util.*;
public class back_9935 {
	public static void main (String args[])throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String now=id.readLine();
		String bombString=id.readLine();
		Stack<Character> stack=new Stack<>();		
		for(int i=0;i<now.length();i++)
		{
			char nowChar=now.charAt(i);
			if((bombString.length()==1||!stack.isEmpty())&&nowChar==bombString.charAt(bombString.length()-1))
			{
				int index=bombString.length()-2;
				Stack<Character> queue=new Stack<>();	
				while(!stack.isEmpty()&&index>=0&&stack.peek()==bombString.charAt(index))
				{
					
					queue.add(stack.pop());
					index--;
				}
				if(index>=0)
				{
					while(!queue.isEmpty())
						stack.add(queue.pop());
					stack.add(nowChar);
				}
			}
			else
				stack.add(nowChar);
			
		}
		int size=stack.size();
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<size;i++)
			answer.append(stack.pop());
		 String a=answer.reverse().toString();
		 if(a.equals(""))
			 System.out.print("FRULA");
		 else
			 System.out.print(a);
	}

}
