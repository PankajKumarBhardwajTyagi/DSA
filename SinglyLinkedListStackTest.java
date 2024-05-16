import beans.Employee;
import util.SinglyLinkedListStack;
import util.Stack;

public class SinglyLinkedListStackTest {
	public static void main(String[] args) {
		Stack<Employee> employees = new SinglyLinkedListStack<Employee>();
		
		System.out.println("Initial Stack:");
		System.out.println(employees);
		System.out.println();
		
		employees.push(new Employee(12, "Dilip", 30000));
		System.out.println(employees);
		System.out.println();
		
		employees.push(new Employee(15, "Kiran", 50000));
		System.out.println(employees);
		System.out.println();
		
		System.out.println("Top Element: " + employees.top());
		
		System.out.println("Popping: " + employees.pop());
		System.out.println(employees);
		System.out.println();
	}
}