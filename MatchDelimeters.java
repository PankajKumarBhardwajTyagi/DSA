import util.SinglyLinkedListStack;
import util.Stack;

public class MatchDelimeters {
	public static void main(String[] args) {
		// <p><b>This is a test</b></p>
		String expression = "(5+{4*[3-2]})";
		System.out.println("Expression is " + (isMatched(expression) ? "Valid" : "Not Valid"));
	}
	private static boolean isMatched(String expression) {
		String opening = "({["; // opening delimeters
		String closing = ")}]"; // closing delimeters
		Stack<Character> buffer = new SinglyLinkedListStack<Character>();
		for(char character : expression.toCharArray()) {
			if(opening.indexOf(character) != -1) buffer.push(character); // the left delimeter
			else if(closing.indexOf(character) != -1) { // the right delimeter
				if(buffer.isEmpty()) return false; // nothing to match
				if(closing.indexOf(character) != opening.indexOf(buffer.pop())) return false; // mismatched delimeter
			}
		}
		return buffer.isEmpty(); // where all opening delimeters matched
	}
}