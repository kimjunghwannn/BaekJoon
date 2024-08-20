package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class back_1094 {
	public static boolean make_this(LinkedList<Integer> checkcm,int sum,int answer,int start,int count) {
		boolean what=false;
		for (int i = start; i < checkcm.size(); i++) {
            sum+=checkcm.get(i);
            if(sum==answer)
            	return true;
            what=make_this(checkcm,sum,answer,i,count++);
            
        }
		
		return what;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		int n=Integer.parseInt(input);
		LinkedList <Integer>checkcm=new LinkedList<>();
		int nowcm=64;
		boolean okay=false;
		if(n==64)
		{
			System.out.println(1);
			System.exit(0);
		}
		checkcm.add(64);
		int deletesu=0;
		while(true) {
			checkcm.remove(deletesu);
			nowcm/=2;
			if(nowcm>n)
				checkcm.add(nowcm);
			else
			{
				deletesu++;
				checkcm.add(nowcm);
				checkcm.add(nowcm);
			}
			okay=make_this(checkcm,0,n,0,0);			
		}
	}
}
