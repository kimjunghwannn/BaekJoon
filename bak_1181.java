package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bak_1181 {
	
	
	static void merge_sort(String list[], int left, int right,String sorted[])
	{
	int mid;
	if(left<right)
	 {
	 mid = (left+right)/2;              // 리스트의 균등분할
	 merge_sort(list, left, mid,sorted);     // 부분리스트 정렬
	 merge_sort(list, mid+1, right,sorted);//부분리스트 정렬
	 merge(list, left, mid, right,sorted);    // 합병
	 }
	}

	static void merge(String list[], int left, int mid, int right,String sorted[])
{
	int i, j, k, l;
	i=left; j=mid+1; k=left;
	// 분할 정렬된 list의 합병
	while(i<=mid && j<=right){
	     if(list[i].length()<=list[j].length()) sorted[k++] = list[i++];
	     else sorted[k++] = list[j++];
	}
	if(i>mid) 	// 남아 있는 레코드의 일괄 복사
    for(l=j; l<=right; l++)
           sorted[k++] = list[l];
	else 	// 남아 있는 레코드의 일괄 복사
    for(l=i; l<=mid; l++)
            sorted[k++] = list[l];
//배열 sorted[]의 리스트를 배열 list[]로 복사
	for(l=left; l<=right; l++)
			list[l] = sorted[l];
}
	public static void main(String []args) throws IOException {
		int n;int i;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n=Integer.parseInt(br.readLine());
	    String words[]=new String[n];
	    String sorted[]=new String[n];
	    for(i=0;i<n;i++)
	    	words[i]=br.readLine();
	    merge_sort(words,0,n-1,sorted);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    for(i=0;i<n;i++)
	    {	
	    	if(i!=n-1)
	    	{
	    		if(sorted[i].equals(sorted[i+1]))
	    			continue;
	    		
	    	}
	    	
	    	System.out.println(sorted[i]);
	    }	
	}
}
