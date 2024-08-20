package algo;

public class BinarysearchTree {
	private BinaryTreeNode root;
	public BinarysearchTree(int key) {
		root=new BinaryTreeNode(key,null,null);
	}
	public void serach(int key) {
		if(root.search(key))
			System.out.println(key+"가 있습니다");
		else
			System.out.println("없습니다");
		
		
	}
	public void delete(int key) {
		root=root.delete_node(key);
	}
	public void insert(int key) {
		root=root.insert_node(key);
	}
	public static void main(String args[]) {
		BinarysearchTree root=new BinarysearchTree(15);
		root.insert(30);
		root.insert(20);
		root.insert(10);
		root.serach(10);
		root.delete(10);
		root.serach(10);
	}
}
