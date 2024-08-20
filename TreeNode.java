package algo;

public class TreeNode {
	 int weight;
     char ch;
	private TreeNode left;
	private TreeNode right;
	public TreeNode() {}
	public TreeNode(int weight,char ch,TreeNode left,TreeNode right) {
		this.weight=weight;
		this.ch=ch;
		this.left=left;
		this.right=right;
	}
	public TreeNode(TreeNode left,TreeNode right) {
		this.left=left;
		this.right=right;
		this.weight=0;
		this.ch='a';
	}
	public void setWeight(int weight) {
		this.weight=weight;
	}
	public TreeNode getleft() {
		return left;
	}
	public TreeNode getright() {
		return right;
	}
	public void setch(char ch) {
		this.ch=ch;
	}
	public void setkey(int weight) {
		this.weight=weight;
	}
}
