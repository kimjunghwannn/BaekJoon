package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1459 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		long x=Long.parseLong(st.nextToken());
		long y=Long.parseLong(st.nextToken());
		long w=Long.parseLong(st.nextToken());
		long s=Long.parseLong(st.nextToken());
		
		long cost1, cost2, cost3;
		
		//1. 수평으로만 이동하는 경우
		cost1=(x+y)*w;
		
		//2. 대각선으로만 이동하는 경우
		//2.1 짝수일 경우 대각선으로만 이동 가능
		//2.2 홀수일 경우 대각선 이동 후 수평이동 한칸
		if((x+y)%2==0) cost2=Math.max(x, y)*s;
		else cost2=(Math.max(x, y)-1)*s+w;
		
		//3.대각선 + 수평 : 대각선으로 최대한 이동 후 수평 이동
		cost3=(Math.min(x, y))*s+(Math.abs(x-y))*w;
		
		System.out.println(Math.min(cost1, Math.min(cost2, cost3)));
		
		
	}
}