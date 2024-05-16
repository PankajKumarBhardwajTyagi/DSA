package util;

public class SinglyLinkedListQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> list;
	
	public SinglyLinkedListQueue() {
		list = new SinglyLinkedList<E>();
	}

	@Override public int size() { return list.size(); }

	@Override public boolean isEmpty() { return list.isEmpty(); }

	@Override public void enqueue(E element) { list.addLast(element); }

	@Override public E dequeue() { return list.removeFirst(); }

	@Override public E first() { return list.first(); }

}