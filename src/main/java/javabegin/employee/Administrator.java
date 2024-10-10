package javabegin.employee;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Administrator extends AbstractEmployee {

	public Administrator(String name, String surname, int age) {
		super(name, surname, age);
	}

	public void control() {
		System.out.println("Administrator control...");
	}

	@Override
	public void walk() {
		System.out.println("Administrator walk...");
	}
}
