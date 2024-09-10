package stream;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
	public static void main(String[] args) {

		List<Person> list = new ArrayList();

		list.add(new Person(18, "Vlad", "Nikolaenko", "SPb"));
		list.add(new Person(15, "Artem", "Petrov", "SPb"));
		list.add(new Person(25, "Andrey", "Sidorov", "MSC"));
		list.add(new Person(37, "Serega", "Smirnov", "SPb"));
		list.add(new Person(29, "Nika", "Kolchenko", "MSC"));
		list.add(new Person(45, "Sveta", "Szaharova", "EKB"));
		list.add(new Person(9, "Nikita", "Vashtov", "SPb"));
		list.add(new Person(75, "Igor", "Vasilev", "MSC"));
		list.add(new Person(16, "Dima", "Nechaev", "SPb"));
		list.add(new Person(14, "Valy", "Shiraeva", "MSC"));

		System.out.println("Test1");
		list.stream()
		    .forEach(System.out::println);

		System.out.println("\nTest2");
		list.stream()
		    .map(p -> new Person(
				    p.getAge(),
				    "new" + p.getName(),
				    "Last" + p.getSurname(),
				    p.getCity())).toList()
		    .forEach(System.out::println);

		System.out.println("\nTest3");
		list.stream()
		    .sorted(Comparator.comparing(Person::getAge))
		    .toList()
		    .forEach(System.out::println);

		System.out.println("\nTest4");
		boolean answer = list.stream()
		                     .allMatch(p -> p.getAge() > 6);
		System.out.println("Age > 6 - " + answer);

		System.out.println("\nTest5");
		double avg = list.stream()
		                 .mapToInt(Person::getAge)
		                 .summaryStatistics()
		                 .getAverage();
		System.out.println("AVG age: " + avg);

		System.out.println("\nTest6");
		int max = list.stream()
		              .mapToInt(person -> person.getSurname().length())
		              .summaryStatistics()
		              .getMax();
		System.out.println("Max surname length: " + max);

		System.out.println("\nTest7");
		boolean startWith = list.stream()
		                        .anyMatch(person -> person.getName().charAt(0) == 'A');
		System.out.println("StartWith - " + startWith);

		System.out.println("\nTest8");
		long count = list.stream()
		                 .map(Person::getCity)
		                 .distinct()
		                 .count();
		System.out.println("Distinct: " + count);

		System.out.println("\nTest9");
		list.stream()
		    .filter(p -> p.getAge() > 18)
		    .filter(p -> p.getName().charAt(0) != 'V')
		    .forEach(System.out::println);

		System.out.println("\nTest9");
		Optional<Test> test1 = Optional.empty();
		Optional<Test> test2 = Optional.of(new Test("hello"));

		Optional<String> s1 = test1.map(Test::getToken);
		Optional<String> s2 = test2.map(Test::getToken);

		//String st1 = s1.orElseThrow();
		String st2 = s2.orElseThrow();


		System.out.println("st1: " + s1);
		System.out.println("st2: " + st2);
	}
}
