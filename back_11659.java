package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_11659 {
	static int[] box;
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		String input=id.readLine();
		int N=Integer.parseInt(input.split(" ")[0]);
		int M=Integer.parseInt(input.split(" ")[1]);
		box=new int [N+1];
		String inputBox[]=id.readLine().split(" ");
		for(int i=1;i<box.length;i++)
		{	
			box[i]=Integer.parseInt(inputBox[i-1]);
			if(i>1)
				box[i]=box[i]+box[i-1];
		}
		for(int i=0;i<M;i++)
		{
			String inputs=id.readLine();
			int start=Integer.parseInt(inputs.split(" ")[0]);
			int end=Integer.parseInt(inputs.split(" ")[1]);
			System.out.println(box[end]-box[start-1]);
		}
	}
}
