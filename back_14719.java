package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_14719 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[1]);
		String input2[]=id.readLine().split(" ");
		int startbig=0;
		boolean floor=false;
		int floorsu=0;
		int total=0;
		int blocks[]=new int [n];
		boolean firstblock=false;
		for(int i=0;i<n;i++)
			blocks[i]=Integer.parseInt(input2[i]);
		if(blocks[0]>blocks[n-1])
			reverseArray(blocks);
		startbig=blocks[0];
		for(int i=1;i<n;i++)
		{
			if(firstblock==false&&blocks[i]<=startbig) {
				if(startbig==blocks[i])
					floorsu++;
				else 
				{
					startbig=blocks[i];
					total+=(floorsu+1)*(blocks[i]-startbig);
					firstblock=true;
					floorsu=0;
					continue;
				}
				
			}
			if(i==n-1)
			{
				if(blocks[i]<startbig)
				{	
					total-=floorsu*(startbig-blocks[i]);
					break;
				}
			}
			if(blocks[i]>=startbig)
			{
				startbig=blocks[i];
				floorsu=0;
				firstblock=true;
				floor=false;
			}
			else if(blocks[i]<startbig)
			{	
				floor=true;
				total+=startbig-blocks[i];
				floorsu++;
			}
			else if(floor==false&&startbig<blocks[i])
			{
				startbig=blocks[i];
			}
		}
		System.out.println(total);
	}
	  public static void reverseArray(int[] arr) {
	        int start = 0;
	        int end = arr.length - 1;
	        
	        while (start < end) {
	            // 시작과 끝을 교환
	            int temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            // 시작 인덱스 증가, 끝 인덱스 감소
	            start++;
	            end--;
	        }
	    }
}
