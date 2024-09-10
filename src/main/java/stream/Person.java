package stream;

public class Person {

	int age;
	String name;
	String surname;
	String city;

	public Person(int age, String name, String surname, String city) {
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "streamJava.Person{" +
		       "age=" + age +
		       ", name='" + name + '\'' +
		       ", surname='" + surname + '\'' +
		       ", city='" + city + '\'' +
		       '}';
	}
}
