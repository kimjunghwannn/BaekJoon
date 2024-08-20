package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_12904 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader (new InputStreamReader(System.in));
		String a=id.readLine();
		String b=id.readLine();
		
		int index=b.length()-1;
		while(index>=0) 
		{
			if(a.equals(b)) 
			{
				System.out.println(1);
				break;
			}
			if(b.charAt(index)=='A')
			{
				b=b.substring(0, index);
			}
			else if(b.charAt(index)=='B')
			{
				String new_B="";
				for(int i=index-1;i>=0;i--)
				{
					new_B+=b.charAt(i);
				}
				b=new_B;
			}
			index--;
		}
		if(index==-1)
			System.out.println(0);
	}
}
