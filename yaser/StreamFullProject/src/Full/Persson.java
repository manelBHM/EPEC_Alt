package Full;

public class Persson {
	
	private String name;
	private int age;
	
	public Persson() {}
	
	public Persson(String name, int age) {
		this.name= name;
		this.age=age;
		
	}
	
	public String getName() {
		return this.name;
	}
	public String setName(String name) {
		return this.name;
		
	}
	
	public int getAge() {
		return this.age;
	}
	public int setAge(int age) {
		return this.age;
	}

	@Override
	public String toString() {
		return "Persson [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
