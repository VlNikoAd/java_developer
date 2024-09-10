package util;

import io.vavr.control.Either;
import org.apache.http.HttpStatus;

import java.util.SortedMap;

public class EitherTest {

	public static void main(String[] args) {
		String s = "21";
		System.out.println(check(s));

	}

	public static Either<String, Integer> check(String s) {
		try {
			Integer number = Integer.parseInt(s);
			return Either.right(number); // Успешный результат
		} catch (NumberFormatException e) {
			return Either.left("Это не число"); // Ошибка
		}

	}

}
