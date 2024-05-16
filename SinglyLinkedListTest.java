import beans.Employee;
import util.SinglyLinkedList;

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		Employee one = new Employee(12, "Dilip", 30000);
		Employee two = new Employee(15, "Kiran", 50000);
		Employee three = new Employee(8, "Gopal", 75000);
		
		SinglyLinkedList<Employee> firstList = new SinglyLinkedList<Employee>();
		System.out.println(firstList);
		System.out.println();
		firstList.addFirst(one);
		System.out.println(firstList);
		System.out.println();
		firstList.addFirst(two);
		System.out.println(firstList);
		System.out.println();
		firstList.addLast(three);
		System.out.println(firstList);
		System.out.println();

		SinglyLinkedList<Employee> secondList = null;
		try {
			secondList = firstList.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		
		System.out.println("Both the Lists are" + (firstList.equals(secondList) ? " Same" : " Not Same"));
		System.out.println();
		
		System.out.println("Removed element: " + firstList.removeFirst());
		System.out.println(firstList);
		System.out.println();
		
	}
}