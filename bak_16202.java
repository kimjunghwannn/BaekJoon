package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class bak_16202 
	{
	public static class lines{
		int start;
		int end;
		int weight;
		public lines() {
			
		}
		public lines(int start,int end,int weight) {
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
	}
	public static int set_find(int curr,int parent[]) {
		
		if(parent[curr]==-1)
			return curr;
		while(parent[curr]!=-1)curr=parent[curr];
		return curr;
		
	}
	public static void set_union(int a,int b,int parent[]) {
		
		if(a != b)
			parent[a]=b;
	}
	public static int dokruskal(int n,lines edges[],int parent[],int score,int startingpoint) {
		int edge_accepted=0;
		int uset,vset;
		lines e;
		
		int i=startingpoint;
		
			while(edge_accepted<n-1) {
			if(i==edges.length)
				return 0;
			e=edges[i];
			uset=set_find(e.start,parent);
			vset=set_find(e.end,parent);
		
			if(uset!=vset) {
				score+=e.weight;
				edge_accepted++;
				
				set_union(uset,vset,parent);
			}
			i++;
		}
		return score;
	}
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n= Integer.parseInt(input[0]);
        int line=Integer.parseInt(input[1]);
        int i;
        int turn=Integer.parseInt(input[2]);
        lines gan[]= new lines[line];
        int parent[]=new int[n+1];
        
        Arrays.fill(parent, -1);
        int score=0;
       for(i=0;i<line;i++) {
    	   input = br.readLine().split(" ");
    	   gan[i]=new lines(Integer.parseInt(input[0]),Integer.parseInt(input[1]),i+1);
       }
       for(i=0;i<turn;i++) {
    	   if((score=dokruskal(n,gan,parent,score,i))!=0)
    		   System.out.print(score+" ");
    	   else
    		   System.out.print("0 ");
    	   score=0;
    	   Arrays.fill(parent, -1);
       }
	}
}
