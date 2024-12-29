package algo;
import java.io.*;
import java.util.*;
public class back_2565 
{
	static StringTokenizer st;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] wires = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			wires[n][0] = Integer.parseInt(st.nextToken());
			wires[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wires, (e1, e2) -> {
			return e1[0] - e2[0];
		});

		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(wires[i][1]>wires[j][1]&&dp[i]<dp[j]+1)
					dp[i]=dp[j]+1;
			}
		}
		
		int max=0;
		
		for(int i=0;i<N;i++)
			max=Math.max(dp[i],max);
		
		System.out.println(N-max);
	}
}
