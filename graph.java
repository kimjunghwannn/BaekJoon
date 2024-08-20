package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class graph {
	private int n;
	private int adj_mat[][];
	private boolean visited[];
	public graph() {
		n=0;
		adj_mat=new int[50][50];
		visited=new boolean[50];
		Arrays.fill(visited,false);
		Arrays.stream(adj_mat).forEach(row -> Arrays.fill(row, 0));
		
	}
	
	public void insert_vertex(int v) {
		if(n>50)
			{
				System.out.println("초과");
				return;
			}
		n++;
	}
	public void insert_edge(int start,int end) 
	{
		if (start==end||start>=n||end>=n)
			{
				System.out.println("정점 번호 오류");
				return;
			}
		adj_mat[start][end]=1;
		adj_mat[end][start]=1;
		
	}
	public void dfs(int v) {
		visited[v]=true;
		System.out.println("정점 ->"+v);
		for(int w=0;w<n;w++)
			if(adj_mat[v][w]==1&&!visited[w])
				dfs(w);
		
	}
	public void bfs(int v) {
		int w;
		Queue<Integer> queue= new LinkedList<>();
		visited[v]=true;
		System.out.println("방문 ->"+v);
		queue.offer(v);
		while(queue.isEmpty()) {
			v=queue.poll();
			for(w=0;w<n;w++)
				if(adj_mat[v][w]==1&&!visited[w]) {
					visited[w]=true;
					System.out.println("방문 "+w);
					queue.offer(w);
				}
		}
	}
}
