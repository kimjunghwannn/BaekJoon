package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_3758 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(id.readLine());
		while(testcase-->0) {
			String input[]=id.readLine().split(" ");
			int team_su=Integer.parseInt(input[0]);
			int question_su=Integer.parseInt(input[1]);
			int yourteam=Integer.parseInt(input[2]);
			int log=Integer.parseInt(input[3]);
			int score[][]=new int [team_su+1][question_su+1];
			int logsu[]=new int [team_su+1];
			int lasttime[]=new int [team_su+1];
			for(int i=0;i<log;i++)
			{
				String input2[]=id.readLine().split(" ");
				if(Integer.parseInt(input2[2])>score[Integer.parseInt(input2[0])][Integer.parseInt(input2[1])])
				score[Integer.parseInt(input2[0])][Integer.parseInt(input2[1])]=Integer.parseInt(input2[2]);
				logsu[Integer.parseInt(input2[0])]++;
				lasttime[Integer.parseInt(input2[0])]=i;
			}
			int lank=1;
			int sum_score[]=new int [team_su+1];
			for(int i=1;i<score.length;i++)
				for(int j=1;j<=question_su;j++)
				{
					sum_score[i]+=score[i][j];
				}
			for(int i=1;i<=team_su;i++)
			{
				
				if(i==yourteam)
					continue;
				if(sum_score[i]>sum_score[yourteam])
				{
					lank++;
				}
				else if(sum_score[i]==sum_score[yourteam])
				{
					if(logsu[i]<logsu[yourteam])
						lank++;
					else if(logsu[i]==logsu[yourteam])
						if(lasttime[i]<lasttime[yourteam])
							lank++;
				}
				
				
			}
			System.out.println(lank);
		}
	}
}
