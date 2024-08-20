package algo;

public class Dikstra {
	private int n;
	private int weight[][];
	private int distance[];
	private int found[];
	public Dikstra(int n,int weight[][]) {
		this.n=n;
		this.weight=new int [100][100];
		 for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                this.weight[i][j] = weight[i][j];
	            }
	        }
		 distance=new int [100];
		 found=new int[100];
	}
	public int choose() {
		int i,min,minpos;
		min=Integer.MAX_VALUE;
		minpos=-1;
		for(i=0;i<n;i++)
			if(distance[i]<min&&found[i]==0)
			{
				min=distance[i];
				minpos=i;
			}
		return minpos;
	}
	public void shortest_path(int start) {
		int i,u,w;
		for(i=0;i<n;i++)
		{
			distance[i]=weight[start][i];
			found[i]=0;
		}
		found[start]=1;
		distance[start]=0;
		for(i=0;i<n-1;i++) {
			System.out.print("STEP "+(i+1)+": distance");
			for(int j=0;j<n;j++)
				System.out.print(" "+distance[j]);
			System.out.println();
			u=choose();
			found[u]=1;
			for(w=0;w<n;w++)
				if(found[w]!=1)
					if(distance[u]+weight[u][w]<distance[w])
						distance[w]=distance[u]+weight[u][w];
		}
	}
	public static void main(String args[]) {
		int st[][]=  {
	            {0, 7, Integer.MAX_VALUE-100, Integer.MAX_VALUE-100, 3, 10, Integer.MAX_VALUE-100},
	            {7, 0, 4, 10, 2, 6, Integer.MAX_VALUE-100},
	            {Integer.MAX_VALUE-100, 4, 0, 2, Integer.MAX_VALUE-100,Integer.MAX_VALUE-100, Integer.MAX_VALUE-100},
	            {Integer.MAX_VALUE-100, 10, 2, 0, 11, 9, 4},
	            {3, 2, Integer.MAX_VALUE-100, 11, 0, Integer.MAX_VALUE-100, 5},
	            {10, 6, Integer.MAX_VALUE-100, 9, Integer.MAX_VALUE-100, 0, Integer.MAX_VALUE-100},
	            {Integer.MAX_VALUE-100, Integer.MAX_VALUE-100, Integer.MAX_VALUE-100, 4, 5, Integer.MAX_VALUE-100, 0}
	        };
		
		Dikstra d=new Dikstra(7,st);
		d.shortest_path(0);
	}
}
