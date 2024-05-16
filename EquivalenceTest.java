import util.SinglyLinkedList;

public class EquivalenceTest {
	public static void main(String[] args) {
		SinglyLinkedList<String> firstList = new SinglyLinkedList<String>();
		firstList.addFirst("Dilip");
		firstList.addFirst("Kiran");
		firstList.addLast("Gopal");

		SinglyLinkedList<String> secondList = new SinglyLinkedList<String>();
		secondList.addFirst("Dilip");
		secondList.addFirst("Kiran");
		secondList.addLast("Gopal");
		
		System.out.println("First List: " + firstList);
		System.out.println();
		System.out.println("Second List: " + secondList);
		System.out.println();
		
		System.out.println("Both the Lists are " + (firstList.equals(secondList) ? "Same" : "Not Same"));
		System.out.println();
	}
}