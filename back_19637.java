package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class back_19637 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input[]=id.readLine().split(" ");
		int name=Integer.parseInt(input[0]);
		int person=Integer.parseInt(input[1]);
		int realname=name;
		Combat combatArray[]=new Combat[name];
		Map<Integer,Boolean>check_map=new HashMap<>();
		int counti=0;
		for(int i=0;i<name;i++)
		{
			input=id.readLine().split(" ");
			if(check_map.get(Integer.parseInt(input[1]))!=null)
			{	
				realname--;
				continue;
			}
			check_map.put(Integer.parseInt(input[1]), true);
			combatArray[counti++] = new Combat(input[0], Long.parseLong(input[1]));
		}
		for(int i=0;i<person;i++)
		{
			long score=Long.parseLong(id.readLine());
			int start=0;
			int end=realname;
			
			while(start<end) {
				int mid=(start+end)/2;
				if(score>combatArray[mid].combatScore)
					start=mid+1;
				else {
					end=mid;
				}
			}
			bw.write(combatArray[start].style + "\n");
		}
		  bw.flush();
	}
}
class Combat {
    String style;
    long combatScore;

    public Combat(String style, long combatScore) {
        this.style = style;
        this.combatScore = combatScore;
    }
}