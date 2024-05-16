package util;

public class DoublyLinkedList<E> {
	
	private static class Node<E> {
		private Node<E> previous;
		private E element;
		private Node<E> next;
		public Node(Node<E> previous, E element, Node<E> next) {
			this.previous = previous;
			this.element = element;
			this.next = next;
		}
		public Node<E> getPrevious() { return previous; }
		public void setPrevious(Node<E> previous) { this.previous = previous; }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }
		@Override public String toString() {
			return "Node [previous=" + previous + ", element=" + element + ", next=" + next + "]";
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	public DoublyLinkedList() {
		head = new Node<E>(null, null, null);
		tail = new Node<E>(head, null, null);
		head.setNext(tail);
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	public E first() { return isEmpty() ? null : head.getNext().getElement(); }
	public E last()  { return isEmpty() ? null : tail.getPrevious().getElement(); }
	
	public void addFirst(E element) { addBetween(element, head, head.getNext()); }
	public void addLast(E element)  { addBetween(element, tail.getPrevious(), tail); }
	
	private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<E>(predecessor, element, successor);
		predecessor.setNext(newNode);
		successor.setPrevious(newNode);
		++size;
	}
	
	public E remove(Node<E> node) {
		Node<E> predecessor = node.getPrevious();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrevious(predecessor);
		--size;
		return node.getElement();
	}

	@Override public String toString() {
		return "DoublyLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}
}