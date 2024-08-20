package algo;

import java.util.HashMap;
import java.util.Scanner;

interface animal{
	public void call();
}
class cat implements animal {
	public String name;
	public cat(String name)
	{
		this.name=name;
	}
	public void call()
	{
		System.out.println(name+": 야용");
	}
}
class dog implements animal {
	public String name;
	public dog(String name)
	{
		this.name=name;
	}
	public void call()
	{
		System.out.println(name+": 멍멍");
	}
}
class petOwner {
	public animal now;
	public HashMap <String,String>a;
	public petOwner()
	{
		a=new HashMap<>();
	}
	public void  setanimal(animal now)
	{
		this.now=now;
	}
	public void call()
	{
		now.call();
	}
	public void talk(String ja,String moon)
	{
		a.put(ja, moon);
	}
}
public class for_play {
	public static void main(String []args) throws InterruptedException 
	{
		System.out.println("강아지: 1번 고양이 2번을 눌러주세요");
		Scanner a=new Scanner(System.in);
		int pets=a.nextInt();
		 a.nextLine(); // 개행 문자 소비

		petOwner person=new petOwner();
		System.out.println("키울 펫 이름을 입력하세요");
		String name=a.nextLine();
		if(pets==1)
			person.setanimal(new dog(name));
		else
			person.setanimal(new cat(name));
		while(true)
		{
			System.out.println("강아지와 하고 싶은 상호작용을 입력하세요");
			System.out.println("1.짖게하기, 2.말 가르치기 3.가르친 말로 이야기 하기");
			int doing=a.nextInt();
			 a.nextLine(); // 개행 문자 소비

			if(doing==1)
				person.call();
			else if(doing==2)
			{
				System.out.println("가르칠 말을 자문 형식으로 입력하세요");
				System.out.print("자:");
				String ja=a.nextLine();
				System.out.print("문:");
				String moon=a.nextLine();
				person.talk(ja, moon);
			}
			else
			{
				System.out.println("가르친 말에 자 부분을 입력하세요");
				String ja=a.nextLine();
				System.out.println(person.a.get(ja));
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
