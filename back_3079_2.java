package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_3079_2  { 
	static long[] inspectionTimesPerCounter;
	static BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
	static long answer=Long.MAX_VALUE;
	static long friendsCount;
	public static void main(String args[]) throws IOException	
	{
	
		String input[] = br.readLine().split(" ");
		int immigrationDeskCount=Integer.parseInt(input[0]);
		friendsCount=Long.parseLong(input[1]);	
	
		initializeInspectionTimes(immigrationDeskCount);
		sortInspectionTimes();
	
		if(immigrationDeskCount==1)
		{
			long totalTime=friendsCount*inspectionTimesPerCounter[0];
			System.out.println(totalTime);
			System.exit(0);
		}
		binarySearch();
		System.out.println(answer);
	}
	
	private static void binarySearch() {
		long left=0;
		long right=1000000000000000000L; 
		
		while(left<=right)
		{
			long mid=(left+right)/2;
			System.out.println(mid);
			if(canCompleteInspectionsInTime(mid))
				right=mid-1;
			else
				left=mid+1;
		}
		
	}

	private static boolean canCompleteInspectionsInTime(long time) 
	{
		long sum =0;
		for(int i=0; i<inspectionTimesPerCounter.length; i++) {
			sum += time/inspectionTimesPerCounter[i]; 
			if(sum>=friendsCount) 
			{	
				answer=Math.min(answer,time);
				return true;
			}
		}
		
		return false;
	}

	static void sortInspectionTimes() 
    {
		Arrays.sort(inspectionTimesPerCounter);
	}

	static void initializeInspectionTimes(int immigrationDeskCount) throws NumberFormatException, IOException 
	{
		inspectionTimesPerCounter=new long [immigrationDeskCount];
		for(int i=0;i<immigrationDeskCount;i++)
			inspectionTimesPerCounter[i]=Long.parseLong(br.readLine());
		
	}
}