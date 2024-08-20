package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1522 {
	public static void main(String args[]) throws IOException {
		BufferedReader id=new BufferedReader(new InputStreamReader(System.in));
		String line=id.readLine();
		int bindex=0;
		int aindex=0;
		String realline=line;
		String aline=null;
		String linea=null;
		int count=0;
		int min_count=Integer.MAX_VALUE;
		int index=line.length()-1;
		if(!line.contains("b"))
		{
			System.out.println(0);
			System.exit(0);
		}
		while(line.charAt(index)=='a')
		{
				line=line.substring(0, index);
				line='a'+line;
		}
		aline=line;
		while(true) {
			bindex=line.indexOf('b');
			aindex=line.lastIndexOf('a');
			
			if(bindex>aindex)
				break;
			if(bindex+1==aindex)
			{
				count++;
				break;
			}
			count++;
			line=line.substring(bindex+1, aindex);
		}
		min_count=Math.min(count, min_count);
		line=aline;
		count=0;
		while(true) {
			bindex=line.lastIndexOf('b');
			aindex=line.indexOf('a');
			
			if(bindex<aindex)
				break;
			if(bindex-1==aindex)
			{
				count++;
				break;
			}
			count++;
			line=line.substring(aindex+1, bindex);
		}
		min_count=Math.min(count, min_count);
		line=realline;
		index=0;
		count=0;
		
		
		
		
		while(line.charAt(index)=='a')
		{
				line=line.substring(index+1, line.length());
				line=line+'a';
		}
		linea=line;
		while(true) {
			bindex=line.lastIndexOf('b');
			aindex=line.indexOf('a');
			
			if(bindex<aindex)
				break;
			if(bindex-1==aindex)
			{
				count++;
				break;
			}
			count++;
			line=line.substring(aindex+1, bindex);
		}
		min_count=Math.min(count, min_count);
		line=linea;

		count=0;
		while(true) {
			bindex=line.indexOf('b');
			aindex=line.lastIndexOf('a');
			
			if(bindex>aindex)
				break;
			if(bindex+1==aindex)
			{
				count++;
				break;
			}
			count++;
			line=line.substring(bindex+1, aindex);
		}
		min_count=Math.min(count, min_count);
		System.out.println(min_count);
	}
}
