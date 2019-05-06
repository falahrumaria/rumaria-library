package myTrial;

public class Person {

	public int age = 7;
	public float height = 1.7f;
	public String name = "falah, " + age + ", " + height;

	public Person(int age, float height, String name) {
		super();
		this.age = age;
		this.height = height;
		this.name = name;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public void sayHi() {
		System.out.println("hi");
	}

	public void laugh() {
		System.out.println("hahahaha");
	}
}
