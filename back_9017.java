package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class back_9017 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		int tastcase=Integer.parseInt(id.readLine());
		while(tastcase-->0) {
			int n=Integer.parseInt(id.readLine());
			String input[]=id.readLine().split(" ");
			int team[]=new int [201];
			boolean okay[]=new boolean [201];
			for(int i=0;i<n;i++)
			{
				
				team[Integer.parseInt(input[i])]++;
				if(team[Integer.parseInt(input[i])]==6)
					okay[Integer.parseInt(input[i])]=true;
			}
			LinkedList<Integer> score[]=new LinkedList[201];
			int grade=1;
			for(int i=1;i<=200;i++)
				score[i]=new LinkedList<>();
			for(int i=0;i<n;i++)				
			{
				
				if(okay[Integer.parseInt(input[i])])
				{	
					score[Integer.parseInt(input[i])].add(grade);
					grade++;
				}
			}
			int index=1;
			int small = 0;
			int sum=0;
			if(score[1].size()==6)
			{
				for(int j=0;j<4;j++)
				small+=score[1].get(j);
			}
			else {
				small=Integer.MAX_VALUE;
			}
			for(int i=2;i<score.length;i++)
			{
				sum=0;
				if(score[i].isEmpty()||score[i].size()<6)
					continue;
				for(int j=0;j<4;j++)
					sum+=score[i].get(j);
				if(sum<small)
				{
					small=sum;
					index=i;
				}
				if(sum==small)
				{
					if(score[i].get(4)<score[index].get(4))
					{
						small=sum;
						index=i;
					}
				}
				
			}
			System.out.println(index);
		}
	}
}
