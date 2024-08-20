package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class bak_minheap {
	public static void main(String args[]) throws NumberFormatException, IOException {
	Scanner scanner = new Scanner(System.in);
	
	int element[]=new int[100000];
	Arrays.fill(element, 0);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int number=Integer.parseInt(br.readLine());


	int size=0;
	while(number>0) {
		number--;
		int doit=Integer.parseInt(br.readLine());


		if(doit==0) {
			if(size==0)
				System.out.println("0");
			else {
			int parent=1, child=2;
			int item,temp;
			item=element[1];
			temp=element[size--];
			while(child<=size) {
				if((child<size)&&element[child]>element[child+1])
					child++;
				if(temp<=element[child])break;
				element[parent]=element[child];
				parent=child;
				child*=2;
			}
			element[parent]=temp;
			System.out.println(item);}
		}
		else {
			int i=++size;
			while((i!=1)&&(doit<element[i/2]))
			{
				element[i]=element[i/2];
				i=i/2;
			}
			element[i]=doit;
			
		}
	}
	  scanner.close();
	}
}
