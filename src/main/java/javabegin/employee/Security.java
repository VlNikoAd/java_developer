package javabegin.employee;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Security extends AbstractEmployee {

	public Security(String name, String surname, int age) {
		super(name, surname, age);
	}

	@Override
	public void walk() {
		System.out.println("Security walk...");
	}
}
