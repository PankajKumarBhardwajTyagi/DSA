package util;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>{
	private static final int CAPACITY = 5; // default array capacity
	private E[] data; // generic array for storage
	private int top = -1; // position of the top element in the stack
	
	public ArrayStack() { 
		data = (E[]) new Object[CAPACITY]; // constructs the array of stack with default CAPACITY
	}
	
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity]; // constructs the array of stack with the user-defined capacity
	}

	@Override public void push(E element) throws RuntimeException {
		if(size() == data.length) throw new RuntimeException("Stack is Full");
		data[++top] = element;
	}

	@Override public E pop() throws RuntimeException { 
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		E element = data[top];
		data[top] = null;
		--top;
		return element; 
	}

	@Override public E top() throws RuntimeException { 
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		return data[top]; 
	}

	@Override public int size() { return top + 1; }

	@Override public boolean isEmpty() { return top == -1; }

	@Override public String toString() { return "ArrayStack [data=" + Arrays.toString(data) + ", top=" + top + "]"; }
}