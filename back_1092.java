package algo;

import java.io.*;
import java.util.*;
public class back_1092 
{
	static ArrayList<Integer> boxArray;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer> liftCapacity=new ArrayList<>();

		String input[]=br.readLine().split(" "); 
		for(int i=0;i<N;i++)
			liftCapacity.add(Integer.parseInt(input[i]));
		
		int M=Integer.parseInt(br.readLine());
		boxArray= new ArrayList<>();
		String input2[]=br.readLine().split(" ");
		for(int i=0;i<M;i++)
			boxArray.add(Integer.parseInt(input2[i]));
		
		Collections.sort(liftCapacity,Collections.reverseOrder());
		 Collections.sort(boxArray, Collections.reverseOrder());
		if(liftCapacity.get(0)<boxArray.get(0))
		{
			System.out.println(-1);
			System.exit(0);
		}
		int time=0;
		while(!boxArray.isEmpty())
		{
			time++;
			for(int i=0;i<liftCapacity.size();i++)
			{
				for(int j=0;j<boxArray.size();j++)
				{
					if(liftCapacity.get(i)>=boxArray.get(j))
					{	
						boxArray.remove(j);
						break;
					}
				}
			}
		}
		System.out.print(time);
		
	}

}
