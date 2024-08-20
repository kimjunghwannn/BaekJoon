package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_4659 {
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while(!(input=id.readLine()).equals("end")) 
		{
		boolean aeiouyes=false;
		int sameaeiou=0;
		int samenoaeiou=0;
		boolean check=false;
		for(int i=0;i<input.length();i++) {
			if(sameaeiou==3||samenoaeiou==3)
			{
				System.out.println('<'+input+'>'+" is not acceptable.");
				check=true;
				break;
			}
			if(i!=0&&input.charAt(i)==input.charAt(i-1))
			{
				if(input.charAt(i)!='e'&&input.charAt(i)!='o')
					{
						System.out.println('<'+input+'>'+" is not acceptable.");
						check=true;
						break;
					}
			}
			if(input.charAt(i)=='a'||input.charAt(i)=='e'||input.charAt(i)=='i'||input.charAt(i)=='o'||input.charAt(i)=='u')
				{
						if(samenoaeiou!=0)
							samenoaeiou=0;
						
						aeiouyes=true;
						sameaeiou++;
				}
			else 
			{
				if(sameaeiou!=0)
					sameaeiou=0;
				samenoaeiou++;
			}
		}
			if(check==false)
			{
				if(aeiouyes==true&&sameaeiou!=3&&samenoaeiou!=3)
					System.out.println('<'+input+'>'+" is acceptable.");
				else			
					System.out.println('<'+input+'>'+" is not acceptable.");
		
			}
			
		}
	
	}
}
