package algo;

import java.util.Arrays;

public class Kruskal {
	private int n;
	private Edge edges[];
	private int parent[];
	public Kruskal() {
		this.n=0;
		edges=new Edge[100];
		for (int i = 0; i < 100; i++) {
		    edges[i] = new Edge();
		}
		parent=new int [50];
	}
	public void insert_edge(int start,int end,int weight) {
		edges[n].setedge(start,end,weight);
		n++;
	}
	public int set_find(int curr) {
		
		if(parent[curr]==-1)
			return curr;
		while(parent[curr]!=-1)curr=parent[curr];
		return curr;
		
	}
	public void set_union(int a,int b) {
		
		if(a != b)
			parent[a]=b;
	}
	public void dokruskal() {
		int edge_accepted=0;
		int uset,vset;
		Edge e;
		int i=0;
		 Arrays.sort(edges);
		while(edge_accepted<n-1) {
			e=edges[i];
			uset=set_find(e.start);
			vset=set_find(e.end);
			if(uset!=vset) {
				System.out.println("간선"+e.start+" "+e.end);
				edge_accepted++;
				set_union(uset,vset);
			}
			i++;
		}
	}
	public static class Edge {
		int start;
		int end;
		int weight;
		public void setedge(int start,int end,int weight) {
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
	}
	public static void main(String args[]) {
		
	}
}
