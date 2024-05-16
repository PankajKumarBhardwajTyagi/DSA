import util.DoublyLinkedList;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addFirst("Dilip");
		list.addLast("Kiran");
		System.out.println(list);
		System.out.println();
	}
}