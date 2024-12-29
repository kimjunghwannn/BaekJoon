package algo;
class A
{
	private int a;
	protected int b;
}
public class ParentClass {
	public static void main(String args[])
	{
		A instance = new A();
		//System.out.println(instance.a);
		System.out.println(instance.b);
	}
}
