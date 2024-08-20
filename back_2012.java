package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class back_2012 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(id.readLine());
		int rank[]=new int [n];
		for(int i=0;i<n;i++)
			rank[i]=Integer.parseInt(id.readLine());
		Queue<Integer> a=new LinkedList<>();
		Arrays.sort(rank);
		boolean checked[]=new boolean [500001];
		long sum=0;
		for(int i=0;i<n;i++)
		{
			if(checked[rank[i]])
				a.add(rank[i]);
			else {
				checked[rank[i]]=true;
			}
		}
		int index=1;
		
		while(!a.isEmpty()) 
		{
			if(checked[index]==false)
			{
				sum+=Math.abs(index-a.poll());
				checked[index]=true;
			}
			index++;
		}
		System.out.println(sum);
	}
}