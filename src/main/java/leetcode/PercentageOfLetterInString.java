package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PercentageOfLetterInString {
	public static void main(String[] args) {

		String s = "foobar";
		char letter = 'o';
		short count = 0;

		for (char c : s.toCharArray()) {
			if(c == letter) count++;
		}

		System.out.println(count * 100 / s.length());
	}
}
