package com.cts.dsa.util;

public interface List<E> {
	/*
	 * size(): returns the number of elements in the list
	 * isEmpty(): checks whether the list is empty or not
	 * add(index, element): inserts the element at the given index & returns the new element
	 * get(index): returns the element at the given index
	 * set(index, element): updates the element at the given index & returns the updated element
	 * remove(index): removes & returns the element at the given index
	 */
	public int size();
	public boolean isEmpty();
	public E add(E element);
	public E add(int index, E element) throws IndexOutOfBoundsException;
	public E get(int index) throws IndexOutOfBoundsException;
	public E set(int index, E element) throws IndexOutOfBoundsException;
	public E remove(int index)throws IndexOutOfBoundsException;
}