package com.cts.dsa.util;

// Functional interface: if an interface has only one method
public interface Position<E> {
	public E getElement() throws RuntimeException;
}