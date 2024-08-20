package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class back_7568 {
	static class person {
		public int kg;
		public int cm;
		public int grade;
		public person(int kg,int cm) {
			this.kg=kg;
			this.cm=cm;
		}
		public void set_grade(int grade) {
			this.grade=grade;
		}
		
	
	}
	
	public static void main(String []args) throws IOException {
		BufferedReader id =new BufferedReader (new InputStreamReader(System.in));
		String input=id.readLine();
		int n=Integer.parseInt(input);
		
		person answer[]=new person[n];
		for(int i=0;i<n;i++)
		{
			String input2[]=id.readLine().split(" ");
			answer[i]=new person(Integer.parseInt(input2[0]),Integer.parseInt(input2[1]));
			
		}
		for(int i=0;i<n;i++)
		{
			int grade=1;
			for(int j=0;j<n;j++)
			{
				if(answer[i].cm<answer[j].cm)
				{
					if(answer[i].kg<answer[j].kg)
						grade++;
				}
				
			}
			System.out.print(grade+" ");
		}
		
			
	}
}
