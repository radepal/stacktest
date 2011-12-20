package mito.stack;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Vector;

/**
 * Data structure based on the LIFO principle (last in first out).
 */
public class Stack {
	/**
	 * Maximum number of elements that can be stored on the stack (capacity).
	 */
	public static int MAX_SIZE = 100;
	
	protected int size = 0;
	protected List stack = new Vector();
	
	/** 
	 * @return <code>true</code> when the maximum number of elements
	 *         is stored on the stack, <code>false</code> otherwise.
	 */
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	/**
	 * @return <code>true</code> when the stack does not have any elements.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return <code>true</code> when the stack contains at least one element
	 *         and does not contain maximum number of elements.
	 */
	public boolean isLoaded() {
		return (size > 0) && (size < MAX_SIZE);
	}

	/**
	 * Adds a given element on top of the stack leaving previous elements below.
	 * 
	 * @param obj element to be added
	 * @throws IllegalStateException when trying to add to the full stack
	 */
	public void push(Object obj) throws IllegalStateException {
		if (isFull()) {
			throw new IllegalStateException("Stack is full.");
		}
		
		stack.add(obj);
		size++;
	}

	/**
	 * Removes and returns the current top element of the stack.
	 * 
	 * @return the current top element of the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public Object pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		size--;
		Object obj = stack.get(size);
		
		return obj; 		
	}
}
