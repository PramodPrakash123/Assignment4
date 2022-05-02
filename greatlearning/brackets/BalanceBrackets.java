
package com.greatlearning.brackets;

import java.util.Stack;

public class BalanceBrackets {

	public static void main(String[] args) {
		String inputString = "([[{}]])";
		if (checkBlanceBrackets(inputString)) {
			System.out.println("Balance brackets");
		} else {
			System.out.println("\n not balance brackets");
		}

	}

	static boolean checkBlanceBrackets(String bracketexpression) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < bracketexpression.length(); i++) {
			char a = bracketexpression.charAt(i);
			if (a == '(' || a == '[' || a == '{') {
				stack.push(a);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char c;
			switch (a) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[') {
					return false;
				}
				break;
			case ')':
				c = stack.pop();
				if (c == '{' || c == '[') {
					return false;
				}
				break;
			case ']':
				c = stack.pop();
				if (c == '{' || c == '(') {
					return false;

				}
				break;

			default:
				break;
			}
		}
		return stack.isEmpty();
	}

}
