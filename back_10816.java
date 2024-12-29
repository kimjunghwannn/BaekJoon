package algo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class back_10816 {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt( br.readLine());
		Map<String,Integer> map=new HashMap<>();
		String input[]=br.readLine().split(" ");
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		String input2[]=br.readLine().split(" ");
		
		for(int i=0;i<N;i++)
		{
			if(map.get(input[i])==null)
				map.put(input[i], 1);
			else
				map.put(input[i], map.get(input[i])+1);
		}
		for(int i=0;i<M;i++)
		{
			if(map.get(input2[i])!=null)
				sb.append(map.get(input2[i])+" ");
			else
				sb.append(0+" ");
		}
		System.out.println(sb.toString());
	}
}
