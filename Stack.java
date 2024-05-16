package util;

public interface Stack<E> {
	public void push(E element); // inserts the element at the top of the stack
	public E pop() throws RuntimeException; // remove & returns the element from the top of the stack
	public E top() throws RuntimeException; // returns, but doesn't remove the element from the top of the stack
	public int size(); // returns the size of the stack
	public boolean isEmpty(); // checks whether the stack is empty
}