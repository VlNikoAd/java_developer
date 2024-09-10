package optional;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {

		System.out.println("Test1");
		String test = "Hello";
		Optional<String> optional = Optional.of(test);
		Optional<String> stringOptional = Optional.empty();
		System.out.println(stringOptional.isPresent() + "," + optional.isPresent());

		System.out.println("\nTest2");
		String empty = null;
		Optional<String> optionalNull = Optional.ofNullable(empty); //если может быть null
		System.out.println(optionalNull.isPresent() + "," + optionalNull.isEmpty()); //not NPE

		System.out.println("\nTest3");
		Optional<String> opt = Optional.ofNullable("Something");
		opt.ifPresent(x -> System.out.println(x.length()));

		System.out.println("\nTest4");
		String stringNull = null;
		String name = Optional.ofNullable(stringNull).orElse("Vlad");
		System.out.println(name);

		System.out.println("\nTest5");
		String stringNull1 = null;
		String name1 = Optional.ofNullable(stringNull1).orElseThrow(IllegalArgumentException::new); //exception
		System.out.println(name1);
	}
}
