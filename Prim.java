package algo;

public class Prim {
	private int n;
	private int weight[][];
	private int selected[];
	private int distance[];
	public Prim(int n) {
		this.n=n;
		weight=new int [n][n];
		selected= new int[n];
		distance= new int[n];
	}
	 public void initWeight(int[][] inputWeight) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                weight[i][j] = inputWeight[i][j];
	            }
	        }
	    }
	public int get_min_vertex() {
		int v=0,i;
		for(i=0; i<n; i++)
			if(selected[i]!=1) {
				v=i;
				break;
			}
		for(i=0;i<n;i++)
			if(selected[i]!=1&&(distance[i]<distance[v]))v=i;
		return v;
	}
	public void doprim(int s) {
		int i,u,v;
		for(u=0;u<n;u++)
			distance[u]=Integer.MAX_VALUE;
		distance[s]=0;
		for(i=0;i<n;i++) {
			u=get_min_vertex();
			selected[u]=1;
			if(distance[u]==Integer.MAX_VALUE) return;
			System.out.println("정점"+u);
			for(v=0;v<n;v++)
				if(weight[u][v]!=Integer.MAX_VALUE)//u에서 v로 길이 있다면
					if(selected[v]!=1&&weight[u][v]<distance[v])
						distance[v]=weight[u][v];
		}
	}
	
}
