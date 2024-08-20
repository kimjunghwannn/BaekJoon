package algo;

import java.util.*;
import java.io.*;
public class back_18870 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		int box[]=new int [N];
		String input[]=id.readLine().split(" ");
		for(int i=0;i<N;i++)
			box[i]=Integer.parseInt(input[i]);
		int sortedBox[]=Arrays.copyOf(box, N);
		Arrays.sort(sortedBox);
		Map<Integer,Integer> map=new HashMap<>();
		int next=sortedBox[0];
		int index=0;
		map.put(next, index);
		for(int i=1;i<N;i++)
		{
			if(next==sortedBox[i])
				continue;
			index++;
			map.put(sortedBox[i], index);
			next=sortedBox[i];
		}
		StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            result.append(map.get(box[i])).append(" ");
        }
        System.out.println(result.toString().trim());
	}
}
