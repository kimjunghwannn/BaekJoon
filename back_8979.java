package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_8979 {
	static class medal{
		public int gold;
		public int silver;
		public int bronze;
		public medal(int gold,int silver, int bronze) {
			this.gold=gold;
			this.silver=silver;
			this.bronze=bronze;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int countrysu=Integer.parseInt(input[0]);
		int serach=Integer.parseInt(input[1]);
		medal nowmedal[]=new medal[countrysu];
		int grade=1;
		for(int i=0;i<countrysu;i++)
		{
			String input2[]=id.readLine().split(" ");
			nowmedal[Integer.parseInt(input2[0])-1]=new medal(Integer.parseInt(input2[1]),Integer.parseInt(input2[2]),Integer.parseInt(input2[3]));		
		}
		for(int i=0;i<countrysu;i++)
		{
			if(i==serach-1)
				continue;
			if(nowmedal[i].gold>nowmedal[serach-1].gold)
			{
				grade++;
			}
			else if(nowmedal[i].gold==nowmedal[serach-1].gold)
			{
				if(nowmedal[i].silver>nowmedal[serach-1].silver)
				{
					grade++;
				}
				else if(nowmedal[i].silver==nowmedal[serach-1].silver)
				{
					if(nowmedal[i].bronze>nowmedal[serach-1].silver)
					{
						grade++;
					}
				}
			}
		}
		System.out.println(grade);
	}
}
