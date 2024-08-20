package algo;

import java.io.*;
import java.util.*;
public class back_11725 
{
	static class Node
	{
		public int n;
		public Node left;
		public Node right;
		public Node(int n,Node left, Node right)
		{
			this.left=left;
			this.right=right;
			this.n=n;
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader id = new BufferedReader (new InputStreamReader(System.in));
		int N=Integer.parseInt(id.readLine());
		Node Nodes[]=new Node[N+1];
		boolean visited[]=new boolean [N+1];
		
	}
}
