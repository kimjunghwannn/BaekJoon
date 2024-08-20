package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class back_25757 {
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		String game=input[1];
		int needsu;
		Set<String> name=new HashSet<>();
		if(game.equals("Y"))
			needsu=1;
		else if(game.equals("F"))
			needsu=2;
		else
			needsu=3;
		for(int i=0;i<n;i++)
		{
		   name.add(id.readLine());
			
		}
		System.out.println(name.size()/needsu);
	}
	
}
