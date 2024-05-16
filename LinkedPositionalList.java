package com.cts.dsa.util;

public class LinkedPositionalList<E> implements PositionalList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	public LinkedPositionalList() {
		head = new Node<E>(null, null, null);
		tail = new Node<E>(head, null, null);
		head.setNext(tail);
	}

	@Override public int size() { return size; }

	@Override public boolean isEmpty() { return size == 0; }
	
	private Position<E> addBetween(Node<E> before, E element, Node<E> after) {
		Node<E> newNode = new Node<E>(before, element, after);
		before.setNext(newNode);
		after.setPrevious(newNode);
		++size;
		return newNode;
	}

	@Override public Position<E> addFirst(E element) { return addBetween(head, element, head.getNext()); }

	@Override public Position<E> addLast(E element) { return addBetween(tail.getPrevious(), element, tail); }
	
	private Node<E> validate(Position<E> position) throws RuntimeException {
		if(!(position instanceof Node)) throw new RuntimeException("Invalid position");
		Node<E> node = (Node<E>) position; // safe cast
		if(node.getNext() == null) throw new RuntimeException("position no longer in the List");
		return node;
	}

	@Override public Position<E> addBefore(Position<E> position, E element) throws RuntimeException {
		Node<E> node = validate(position);
		return addBetween(node.getPrevious(), element, node);
	}

	@Override public Position<E> addAfter(Position<E> position, E element) throws RuntimeException {
		Node<E> node = validate(position);
		return addBetween(node, element, node.getNext());
	}

	@Override public Position<E> first() { return head.getNext(); }

	@Override public Position<E> last() { return tail.getPrevious(); }

	@Override public Position<E> before(Position<E> position) throws RuntimeException {
		Node<E> node = validate(position);
		return node.getPrevious();
	}

	@Override public Position<E> after(Position<E> position) throws RuntimeException {
		Node<E> node = validate(position);
		return node.getNext();
	}

	@Override public E set(Position<E> position, E element) throws RuntimeException {
		Node<E> node = validate(position);
		node.setElement(element);
		return element;
	}

	@Override public E remove(Position<E> position) throws RuntimeException {
		Node<E> node = validate(position);
		Node<E> before = node.getPrevious();
		Node<E> after = node.getNext();
		before.setNext(after);
		after.setPrevious(before);
		--size;
		E answer = node.getElement();
		node.setElement(null);
		node.setPrevious(null);
		node.setNext(null);
		return answer;
	}

	@Override public String toString() {
		return "LinkedPositionalList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}

}