package algo;

public class BinaryTreeNode {
	private int key;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	public BinaryTreeNode(int key, BinaryTreeNode left, BinaryTreeNode right) {
		this.key=key;
		this.left=left;
		this.right=right;
	}
	public BinaryTreeNode() {}
	public boolean search(int key) {
		BinaryTreeNode current = this;
		while(current!=null) {
			if(key==current.key)return true;
			else if(key<this.key)
				current=current.left;
			else
				current=current.right;
		}
		return false;
	}
	public BinaryTreeNode insert_node(int key) {
		BinaryTreeNode current =this;
		
		if(key<current.key)
			current.left= (current.left == null) ? new BinaryTreeNode(key, null, null) :current.left.insert_node(key);
		else if(key>current.key)
			current.right= (current.right  == null) ? new BinaryTreeNode(key, null, null) :current.right.insert_node(key);
		
		return current;
		
	}
	public BinaryTreeNode min_value_node(BinaryTreeNode node) {
		while(node.left!=null)
			node=node.left;
		return node;
	}
	public BinaryTreeNode delete_node(int key)
	{
		BinaryTreeNode current =this;
		if(current==null) return current;
		
		if(key<current.key)
			current.left=current.left.delete_node(key);
		else if(key>current.key)
			current.right=current.right.delete_node(key);
		else {
			if(current.left==null) {
				BinaryTreeNode temp=current.right;
				return temp;
			}
			else if(current.right==null) {
				BinaryTreeNode temp=current.left;
				return temp;
			}
			
			else {
				BinaryTreeNode temp=min_value_node(current.right);
				current.key=temp.key;
				current.right=current.right.delete_node(current.key);
			}
		}
		return current;
	}
}
