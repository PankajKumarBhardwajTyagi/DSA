import util.ArrayStack;
import util.Stack;

public class ArrayStackTest {
	public static void main(String[] args) {
		Stack<String> names = new ArrayStack<String>();
		try {
			System.out.println(names);
			names.push("Dilip");
			System.out.println(names);
			names.push("Mahesh");
			System.out.println(names);
			names.push("Santhosh");
			System.out.println(names);
			names.push("Bharath");
			System.out.println(names);
			names.push("Rajesh");
			System.out.println(names);
			names.push("Nitin");
			System.out.println(names);
		} catch(RuntimeException re) {
			System.err.println(re.getMessage());
		}
		try {
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
		} catch(RuntimeException re) {
			System.err.println(re.getMessage());
		}
		try {
			System.out.println(names.top());
		} catch(RuntimeException re) {
			System.err.println(re.getMessage());
		}
	}
}