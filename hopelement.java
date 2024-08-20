package algo;

public class hopelement {
	 TreeNode ptree;
	 char ch;
 int key;
	public hopelement(TreeNode ptree, char ch, int key) {
		this.ch=ch;
		this.key=key;
		this.ptree=ptree;
	}
	public hopelement() {}
	public void setch(char ch) {
		this.ch=ch;
	}
	public void setkey(int key) {
		this.key=key;
	}
}
