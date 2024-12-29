package algo;
import java.io.*;
import java.util.*;
public class back_2295 
{
	static int n;
	static Set<Integer> check;
	static LinkedList<Integer> newIntArray;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		int intArray[]=new int [n];
		check=new TreeSet<>();
		for(int i=0;i<n;i++)
			intArray[i]=Integer.parseInt(br.readLine());
		Arrays.sort(intArray);
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				check.add(intArray[i]+intArray[j]);
			}
		}
		newIntArray= new LinkedList<>(check);
		for(int i=n-1;i>=0;i--)
		{
			for(int j = 0; j < i; j++)
			{
				int rest=intArray[i]-intArray[j];
				if(binarySerach(rest))
				{
					System.out.println(intArray[i]);
					System.exit(0);
				}
			}
		}
	}

	private static boolean binarySerach(int rest) {
		int start=0;
		int end=newIntArray.size()-1;
		while(start<=end)
		{
			int middle=(start+end)/2;
			
			
			if(newIntArray.get(middle)<rest)
				start=middle+1;
			else if(newIntArray.get(middle)>rest)
				end=middle-1;
			else if(newIntArray.get(middle)==rest)
				return true;
		}
		return false;
	}
}
