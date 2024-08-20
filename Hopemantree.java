package algo;

public class Hopemantree {
	
	public TreeNode make_tree(TreeNode left,TreeNode right,int key, char c) {
		TreeNode node=new TreeNode(key,c,left,right);
		return node;
	}
	public boolean is_leaf(TreeNode node) {
		return (node.getleft()==null)&&(node.getright()==null);
	}
	public void print_array(int codes[],int n) 
	{
		for(int i=0;i<n;i++)
			System.out.print(codes[i]);
		System.out.println("\n");
	}
	public void print_codes(TreeNode root, int codes[],int top) 
	{		
		if(root.getleft()!=null) {
			codes[top]=1;
			print_codes(root.getleft(),codes,top+1);
		}
		if(root.getright()!=null) {
			codes[top]=0;
			print_codes(root.getright(),codes,top+1);
		}
		if(is_leaf(root)) {
			System.out.print(root.ch);
			print_array(codes,top);		}
	}
	public void huffman_tree(int freq[],char ch_list[],int n) {
		int i;
		TreeNode node,x;
		hopelement e,e1=new hopelement(),e2=new hopelement();
		Minheap h=new Minheap();
		int top=0;
		int codes[]=new int[100];
		for(i=0;i<n;i++) {
			node = make_tree(null,null,freq[i],ch_list[i]);
			e= new hopelement(node,ch_list[i],freq[i]);
			h.insertMinHeap(e);
		}
		for(i=1;i<n;i++) {
			e1=h.deleteMinHeap();
			e2=h.deleteMinHeap();
			x=make_tree(e1.ptree,e2.ptree,e1.key+e2.key,'\0');
			e= new hopelement(x,'\0',e1.key+e2.key);
			System.out.println(e1.key+" "+e2.key+" "+e.key);
			h.insertMinHeap(e);
		}
		e=h.deleteMinHeap();
		print_codes(e.ptree,codes,top);
	}
	public static void main(String[] args) {
		char ch_list[] = { 's', 'i', 'n', 't', 'e' };
		int freq[] = { 4, 6, 8, 12, 15 };
		Hopemantree h= new Hopemantree();
		h.huffman_tree(freq, ch_list, 5);
  }
}
