package com.cts.dsa.util;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
	private static final int CAPACITY = 8;
	private E[] data;
	private int size = 0;
	
	public ArrayList() { data = (E[]) new Object[CAPACITY]; }
	public ArrayList(int capacity) { data = (E[]) new Object[capacity]; }

	@Override public int size() { return size; }

	@Override public boolean isEmpty() { return size == 0; }
	
	@Override public E add(E element) {
		if(size == data.length) resize(2 * data.length);
		return add(size, element);
	}
	
	private void resize(int capacity) {
		E[] newArray = (E[]) new Object[capacity];
		for(int index = 0; index < size; ++index) newArray[index] = data[index];
		data = newArray;
	}
	
	private void checkIndex(int index, int size) throws IndexOutOfBoundsException { 		
		if(index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index: " + index);
	}

	@Override public E add(int index, E element) throws IndexOutOfBoundsException {
		checkIndex(index, size);
		for(int position = size - 1; position >= index; --position) data[position + 1] = data[position];
		data[index] = element;
		++size;
		return element;
	}

	@Override public E get(int index) throws IndexOutOfBoundsException {
		checkIndex(index, size - 1);
		return data[index];
	}

	@Override public E set(int index, E element) throws IndexOutOfBoundsException {
		checkIndex(index, size - 1);
		data[index] = element;
		return element;
	}
	
	@Override public E remove(int index) throws IndexOutOfBoundsException {
		checkIndex(index, size - 1);
		E answer = data[index];
		for(int position = index; position < size - 1; ++position) data[position] = data[position + 1];
		data[size - 1] = null;
		--size;
		return answer;
	}
	
	@Override public String toString() {
		return "ArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
	}

}