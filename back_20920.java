package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class back_20920 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int su=Integer.parseInt(input[1]);
		Map<String, Integer> hashMap = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String input2=id.readLine();
			if(input2.length()>=su)
			{
				if(hashMap.containsKey(input2))
				{
					   int value = hashMap.get(input2);
					   hashMap.put(input2, value + 1);
				}
				else {
					hashMap.put(input2, 1);
				}
			}
		}
		 List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
		 Comparator<Map.Entry<String, Integer>> valueComparator = Comparator
	                .<Map.Entry<String, Integer>, Integer>comparing(entry -> entry.getValue())
	                .reversed();

		 Comparator<Map.Entry<String, Integer>> keySizeComparator =Comparator
				 .<Map.Entry<String,Integer>,Integer>comparing(entry->entry.getKey().length())
				 .reversed();
	     Comparator<Map.Entry<String, Integer>> keyComparator = Comparator.comparing(Map.Entry::getKey);
	     Comparator<Map.Entry<String, Integer>> combinedComparator = valueComparator
	                .thenComparing(keySizeComparator)
	                .thenComparing(keyComparator);
	     Collections.sort(entryList, combinedComparator);
	     for (Map.Entry<String, Integer> entry : entryList) {
	            System.out.println(entry.getKey());
	        }
		}
}
