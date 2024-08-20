package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class back_1446 {
	static class road{
		public int start;
		public int end;
		public int length;
		public road(int start,int end,int length) {
			this.start=start;
			this.end=end;
			this.length=length;
		}
	}
	public static void main(String []args) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int line=Integer.parseInt(input[1]);
		road now_road[]=new road[n];		
		
		for(int i=0;i<n;i++)
		{
			String input2[]=id.readLine().split(" ");
			int start=Integer.parseInt(input2[0]);
			int end=Integer.parseInt(input2[1]);
			int length=Integer.parseInt(input2[2]);
			now_road[i]=new road(start,end,length);
		}
		Arrays.sort(now_road, new Comparator<road>() {
            @Override
            public int compare(road road1, road road2) {
                // start를 오름차순으로 정렬합니다.
                int startComparison = Integer.compare(road1.start, road2.start);
                if (startComparison != 0) {
                    return startComparison;
                }
                    return Integer.compare(road1.end, road2.end);
            }
        });
		Queue<road> a=new LinkedList<>();
		int distance[]=new int [line+1];
		for(int i=0;i<=line;i++)
			distance[i]=i;
		a.add(new road(0,0,0));
		while(!a.isEmpty()) {
			road this_road=a.poll();
			int now_location=this_road.end;
			for(road check_road : now_road)
			{
				if(check_road.end>line)
					continue;
				if(check_road.start<now_location)
					continue;
				if(check_road.end-check_road.start<check_road.length)
					continue;
				if(distance[check_road.end]>distance[now_location]+(check_road.start-now_location)+check_road.length)
				{
					distance[check_road.end]=distance[now_location]+(check_road.start-now_location)+check_road.length;
					a.add(check_road);
				}
				distance[line]=Math.min(distance[line], distance[check_road.end]+(line-check_road.end));
			}
		}
		System.out.println(distance[line]);
	}
}
