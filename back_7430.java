package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class back_7430 {
	static PriorityQueue<String> answer;
	static int N;
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(id.readLine());
		while(testCase-->0)
		{
			N=Integer.parseInt(id.readLine());
			answer=new PriorityQueue<>();
			find_zero(1,"");
			while(!answer.isEmpty())
			{
				System.out.println(answer.poll());
			}
		}
	}
	private static void find_zero(int num,String formula) {
		if(num==N)
		{
			formula+=num;
			if(isZeroFormula(formula))
				answer.add(formula);
			return;
		}
		for(int i=0;i<3;i++)
		{
			String symbols = null;
			if(i==0)
				symbols="+";
			if(i==1)
				symbols="-";
			if(i==2)
				symbols=" ";
			find_zero(num+1,formula+num+symbols);
		}
	}
	private static boolean isZeroFormula(String formula) {
		LinkedList<String> box=new LinkedList<>();
		LinkedList<String> formulaBox=new LinkedList<>();
		formula=formula.replace(" ","");
		int lastSymbols=0;
		String mege="";
		for(int i=0;i<formula.length();i++)
		{
			if(i==formula.length()-1)
			{
				formulaBox.add(formula.substring(lastSymbols,i+1));
				break;
			}
			if(formula.charAt(i)=='+'||formula.charAt(i)=='-')
			{
				formulaBox.add(formula.substring(lastSymbols,i));
				formulaBox.add(formula.substring(i,i+1));
				lastSymbols=i+1;
			}
		}
		for(String a :formulaBox)
		{
			box.add(a);
			if(box.size()==3)
			{	
				
			    mege=calculate(box);
			    box.clear();
			    box.add(mege);			
			}
		}
		
		if(box.poll().equals("0"))
			return true;
		else
			return false;
	}
	private static String calculate(LinkedList<String> box) {
	
		int a=Integer.parseInt(box.get(0));
		String symbols=box.get(1);
		int b=Integer.parseInt(box.get(2));
		if(symbols.equals("+"))
			return String.valueOf((a+b));
		else
			return String.valueOf((a-b));
	}
}
