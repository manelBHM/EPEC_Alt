package domains;

import java.util.Comparator;

public class Person implements Comparable<Person> {
	
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return getName() + " / " + getAge();
	}
	
	
	// Cette méthode compare les âges des Person
	public static Comparator <Person> ageComparator = new Comparator<Person>() {
		
		public int compare(Person p1, Person p2) {
			int age1 = p1.getAge();
			int age2 = p2.getAge();
			
			return age1 - age2;
		}
	};
	
	public static Comparator <Person> nameComparator = new Comparator<Person>() {
			
		public int compare(Person p1, Person p2) {
			String name1 = p1.getName();
			String name2 = p2.getName();
				
			return p1.compareTo(p2);
		}
	};

	@Override
	public int compareTo(Person o) {
		return 0;
	}
	
}
