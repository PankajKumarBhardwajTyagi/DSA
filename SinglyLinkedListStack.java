package util;

public class SinglyLinkedListStack<E> implements Stack<E> {
	
	private SinglyLinkedList<E> list;
	
	public SinglyLinkedListStack() {
		list = new SinglyLinkedList<E>();
	}

	@Override public int size() { return list.size(); }

	@Override public boolean isEmpty() { return list.isEmpty(); }

	@Override public void push(E element) { list.addFirst(element); }

	@Override public E pop() throws RuntimeException {
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		return list.removeFirst();
	}

	@Override public E top() throws RuntimeException {
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		return list.first();
	}

	@Override public String toString() { return "SinglyLinkedListStack [list=" + list + "]"; }	

}