package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class back_2258 {
	static public class meat {
		public int kg;
		public int price;
		public meat(int kg,int price)
		{
			this.kg=kg;
			this.price=price;
		}
	}
	public static void main(String []args) throws IOException
	{
		BufferedReader id= new BufferedReader(new InputStreamReader(System.in));
		String input[]=id.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int M=Integer.parseInt(input[1]);
		  List<meat> meats = new ArrayList<>();
		
		for(int i=0;i<N;i++)
		{	
			String input2[]=id.readLine().split(" ");
			int kg=Integer.parseInt(input2[0]);
			int price=Integer.parseInt(input2[1]);
			meats.add(new meat(kg,price));
		}
		Collections.sort(meats,new Comparator<meat>() {
			public int compare(meat m1, meat m2) {
		        // price 비교
		        int priceComparison = Integer.compare(m1.price, m2.price);
		        
		        // price가 같으면 kg로 내림차순 비교
		        if (priceComparison == 0) {
		            return Integer.compare(m2.kg, m1.kg); // m2와 m1 순서 반대로하여 내림차순 정렬
		        } else {
		            return priceComparison; // price가 다를 때의 비교 결과 반환
		        }
		    }
		});
		int price=0;
		
		int sum=0;
		
		int n=0;
		for(meat a:meats)
		{
			if(price==a.price)
			{
				n++;
				sum+=a.kg;
			}
			else 
			{
				sum+=a.kg;
				n=1;
				price=a.price;
			}
			if(M<=sum)
			{
				int maxprice=Integer.MAX_VALUE;
				for(meat b:meats)
					if(price<b.price)
						maxprice=b.price;
				maxprice=Math.min(maxprice, price*n);
				System.out.println(maxprice);
				System.exit(0);
			}
			
			//System.out.println(price+" "+sum);
		}
		System.out.println(-1);
	}
}
