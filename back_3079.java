package algo;

import java.util.*;
import java.io.*;
public class back_3079 
{
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
	
	static void binarySearch() 
	{
		long start=0;
		long end=friendsCount;
		while(start<=end)
		{
			long middle=(start+end)/2;
			if(canAddMoreCustomersToMinTimeDesk(middle))
				start=middle+1;
			else
				end=middle-1;
		}
	}

	static boolean canAddMoreCustomersToMinTimeDesk(long minTimeDeskCustomerCount) 
	{
		long minTimeDeskTotalTime=minTimeDeskCustomerCount*inspectionTimesPerCounter[0];
		long otherDesksCustomerCount=friendsCount-minTimeDeskCustomerCount;
		
		int index=1;
		while(otherDesksCustomerCount>0)
		{	
			if(index==inspectionTimesPerCounter.length-1)
			{
				if(otherDesksCustomerCount*inspectionTimesPerCounter[index]>minTimeDeskTotalTime)
				{	
					answer=Math.min(answer,otherDesksCustomerCount*inspectionTimesPerCounter[index]);
					return true;
				}
				else
				{	
					answer=Math.min(answer,minTimeDeskTotalTime);
					return false;
				}
			}
			long deskCustomerCount=minTimeDeskTotalTime/inspectionTimesPerCounter[index];
			otherDesksCustomerCount-=deskCustomerCount;
			index++;
		}
		answer=Math.min(answer,minTimeDeskTotalTime);
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
