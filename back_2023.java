package algo;

import java.util.*;
import java.io.*;
public class back_2023 
{
	static class Num
	{
		public int value;
		public int digitCount;
		public Num (int value,int digitCount)
		{
			this.value=value;
			this.digitCount=digitCount;
		}
	}
	static ArrayList<Integer> answer=new ArrayList<>();
	static int N;
	static int primeDigits []= {1,3,7,9};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		if(N==1)
		{
			printInitialPrimes();
		}
		else
		{
			generatePrimeNumbers();
			printAnswer();
		}
		
	}
	
	
	
	
	private static void printAnswer() 
	{
		Collections.sort(answer);
		for(int a :answer)
			System.out.println(a);
	}
	private static void generatePrimeNumbers() 
	{
		
		Queue<Num> queue= initializeQueue();
		while(!queue.isEmpty())
		{
			Num nowNum=queue.poll();
			
			for(int i=0;i<4;i++)
			{
				int numValue=nowNum.value;
				numValue=(numValue*10)+primeDigits [i];
				if(!isPrime(numValue))
					continue;
				if(nowNum.digitCount+1==N)
				{	
					answer.add(numValue);
					continue;
				}
				queue.add(new Num(numValue,nowNum.digitCount+1));
			}
		}
	}
	private static Queue<Num> initializeQueue() 
	{
		Queue<Num> queue= new LinkedList<>();
		queue.add(new Num(2,1));
		queue.add(new Num(3,1));
		queue.add(new Num(5,1));
		queue.add(new Num(7,1));
		return queue;
	}
	private static void printInitialPrimes() 
	{
		System.out.println(2);
		System.out.println(3);
		System.out.println(5);
		System.out.println(7);		
	}
	private static boolean isPrime(int numValue) {
		for(int j=2;j*j<=numValue;j++)
			if(numValue%j==0)
				return false;
		return true;
	}

}
