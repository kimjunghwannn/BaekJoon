package algo;
import java.io.*;
import java.util.*;
public class back_2110 {
	static boolean flag[];
	static int answer=Integer.MAX_VALUE;
	static int C;
	static int homeLocations[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		C=Integer.parseInt(input[1]);
		homeLocations=new int [N];
		flag=new boolean [N+1];
		for(int i=0;i<N;i++)
			homeLocations[i]=Integer.parseInt(id.readLine());
		Arrays.sort(homeLocations);
		int start=0;
		int end=(homeLocations[N-1]-homeLocations[0])+1;
		
		//upper bound 사용 왜냐하면 깃발 설치 가능한 개수를 넘기는 길이에서 -1 해준게 답임 
		// 그래서 upper를 사용
		while(start<end)
		{
			int mid=(start+end)/2;
			
			
			if(installFlag(mid)>=C)
			{
				start=mid+1;
			}
			else
				end=mid;
		}
		System.out.println(start-1);
	}
	static int installFlag(int distance)
	{
		int n=1;
		int lastLo=homeLocations[0];		
		for(int i=1;i<homeLocations.length;i++)
		{
			if(homeLocations[i]-lastLo>=distance)
			{
				lastLo=homeLocations[i];
				n++;
			}
		}
		return n;
	}
}
