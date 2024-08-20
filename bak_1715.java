package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class bak_1715 {
	public static void main(String []args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	  
	    int i;
	    int small_1;
	    int small_2;
	    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
	    int answer=0;
	    for(i=0;i<n;i++)
	    	priorityQueue.add(Integer.parseInt(br.readLine()));
	    if(n==1)
	    	{	
	    		System.out.print(0);
	    		System.exit(0);
	    	}
	    while(priorityQueue.size()>1) 
	    	{
	    		small_1=priorityQueue.poll();
	    		small_2=priorityQueue.poll();
	    		i=small_1+small_2;
	    		answer+=i;
	    		priorityQueue.add(i);
	    	}
	    System.out.print(answer);
		}
}

