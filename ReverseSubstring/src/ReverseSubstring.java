import java.util.Stack;

public class ReverseSubstring {

	public static String reverseParenthesesContent(String s) {

		validateContent(s);

		StringBuilder current = new StringBuilder();
		StringBuilder prev = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				prev = current;
				current = new StringBuilder();
			} else if (c == ')') {
				current = current.reverse();
				prev.append(current);
				current = prev;
			} else {
				current.append(c);
			}
		}

		return current.toString();
	}

	private static void validateContent(String s) {
		if (s == null || s.length() < 1 || s.length() > 2000) {
			throw new IllegalArgumentException("Input string is invalid.");
		}

		validateParenthesesAndLowerCase(s);
	}

	private static void validateParenthesesAndLowerCase(String s) {
		Stack<Character> stack = new Stack<>();
		boolean validParentheses = true;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					validParentheses = false;
				}
			} else if (!Character.isLowerCase(c)) {
				throw new IllegalArgumentException("Input string contains invalid characters.");
			}
		}

		if (!stack.isEmpty() || !validParentheses) {
			throw new IllegalArgumentException("Input string contains unbalanced parentheses.");

		}
	}

	public static void main(String[] args) {
		System.out.println(reverseParenthesesContent("abd(jnb)asdf")); // abd(bnj)asdf
		System.out.println(reverseParenthesesContent("abdjnbasdf")); // abdjnbasdf
		System.out.println(reverseParenthesesContent("dd(df)a(ghhh)")); // dd(fd)a(hhhg)
	}

}
