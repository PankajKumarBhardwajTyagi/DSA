package util;

public class SinglyLinkedList<E> implements Cloneable {
	
	private static class Node<E> { // Nested Class representing a Node
		private E element; // reference to the data
		private Node<E> next; // reference to the address of the next Node
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }
		@Override public String toString() {
			return "Node [element=" + element + ", next=" + next + "]";
		}
	}
	
	private Node<E> head = null; // head Node of the list (or null if empty)
	private Node<E> tail = null; // tail Node of the list (or null if empty)
	
	private int size = 0; // number of nodes in the list
	
	public SinglyLinkedList() {} // creates an initial empty list
	
	// Access Methods
	
	public int size() { return size; } // returns the number of nodes in the list
	
	public boolean isEmpty() { return size == 0; } // checks whether the list is empty
	
	public E first() { return isEmpty() ? null : head.getElement(); } // returns the first element
	
	public E last() { return isEmpty() ? null : tail.getElement(); } // returns the last element
	
	// Update Methods
	
	/*
	 * Algorithm addFirst(element):
	 * 	newNode = Node(element) 	// create a new node instance storing the reference to the element
	 *  newNode.next = head 		// set new node's next to the reference the old head node
	 *  head = newNode 				// set the head to the reference of the new node
	 *  size = size + 1 			// increment the node count
	 */
	//     [Dilip, head]
	public void addFirst(E element) {
		//             head->    [Kiran, address of Dilip]
		head = new Node<E>(element, head); 	// create and link a new Node
		if(isEmpty()) tail = head; 			// if the List is Empty & Node is the only element, new node becomes the tail also
		++size;
	}
	
	/*
	 * Algorithm addLast(element):
	 *  newNode = Node(element)		// create a new node instance storing the reference to the element
	 *  newNode.next = null;		// set new node's next to the reference of the null object
	 *  tail.next = newNode;		// set the old tail node to point to the new node
	 *  tail = newNode;				// set the tail to the reference of the new node
	 *  size = size + 1;			// increment the node count
	 */
	public void addLast(E element) {
		Node<E> newNode = new Node<E>(element, null);	// The newNode eventually will be the tail
		if(isEmpty()) head = newNode;	// if the List is Empty, new Node becomes the head also
		else tail.setNext(newNode);		// the previous last Node tail points to the newNode
		tail = newNode;					// newNode becomes the tail
		++size;
	}
	
	/* 
	 * Algorithm removeFirst():
	 *  if head == null then
	 *  	the list is empty
	 *  head = head.next	// make head to the next node (or null)
	 *  size = size - 1		// decrease the node count
	 */
	public E removeFirst() {
		if(isEmpty()) return null;			// nothing to remove - return null
		E element = head.getElement();		// head element to remove
		head = head.getNext();				// head points to the 2nd Node: next of head
		--size;								// Decreases the count
		if(isEmpty()) tail = null;			// if the List is empty then tail points to null
		return element;						// return the removed element
	}

	@Override public String toString() {
		return "SinglyLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}

	@Override public boolean equals(Object object) {
		if(object == null) return false; // if the object null, cannot be compared
		if(getClass() != object.getClass()) return false; // if both classes are different, cannot be compared
		SinglyLinkedList other = (SinglyLinkedList) object; // safe-cast
		if(size != other.size) return false; // if sizes are different, cannot be compared
		// Obtain the heads of both the lists
		Node firstNode = head;
		Node secondNode = other.head;
		// Iterate thru the list until firstNode != null
		while(firstNode != null) {
			// if both the corresponding elements are not equal, returns false
			if(!firstNode.getElement().equals(secondNode.getElement())) return false; 
			// Shift both the nodes to the next element
			firstNode = firstNode.getNext();
			secondNode = secondNode.getNext();
		}
		return true; // if we reach this, equivalence is success
	}
	
	@Override public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// Always use the inherited Object.clone() to create the initial copy
		SinglyLinkedList<E> clonedObject = (SinglyLinkedList<E>) super.clone(); // safe-cast
		if(size > 0) { // chain of nodes
			clonedObject.head = new Node<E>(head.getElement(), null); // obtain the head of the clone
			Node<E> walk = head.getNext(); // walk thru the remaining nodes of the original list
			Node<E> clonedTail = clonedObject.head; // get the current node
			while(walk != null) { // walk thru the nodes until null
				Node<E> newNode = new Node<E>(walk.getElement(), null); // create a node with current element
				clonedTail.setNext(newNode); // link previous node to this node
				clonedTail = newNode; 
				walk = walk.getNext(); // get the next node
			}
		}
		return clonedObject;
	}
 }