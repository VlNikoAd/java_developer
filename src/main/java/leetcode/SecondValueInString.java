package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class SecondValueInString {

	public static void main(String[] args) {
		String s = "dfa12321afd";
		System.out.println(secondHighest(s));


	}


	public static int secondHighest(String s) {
		int max1 = -1;
		int max2 = -1;

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				int num = Character.getNumericValue(c);
				if (num > max1) {
					max2 = max1;
					max1 = num;
				} else if (num > max2 && num < max1) {
					max2 = num;
				}
			}

		}
		return max2;
	}
}

