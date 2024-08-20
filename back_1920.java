package algo;
import java.util.*;
import java.io.*;
public class back_1920 {
	static int box[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
		int sizeN=Integer.parseInt(id.readLine());
		box=new int [sizeN];
		String input[]=id.readLine().split(" ");
		for(int i=0;i<sizeN;i++)
			box[i]=Integer.parseInt(input[i]);
		int testN=Integer.parseInt(id.readLine());
		int testBox[]=new int [testN];
		String input2[]=id.readLine().split(" ");
		for(int i=0;i<testN;i++)
			testBox[i]=Integer.parseInt(input2[i]);
		Arrays.sort(box);
		for(int i=0;i<testN;i++)
		{	if(binarysearch(testBox[i]))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	public static boolean binarysearch(int i) {
		int start =0;
		int end=box.length-1;
		while(start<=end)
		{
			int middle=(start+end)/2;
			
			if(box[middle]==i)
				return true;
			else if(box[middle]>i)
				end=middle-1;
			else
				start=middle+1;
		}
		return false;
	}
}
