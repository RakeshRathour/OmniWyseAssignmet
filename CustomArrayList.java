package com.omniwyse.OmniWyseAssignment2;

/**
 * 
 * @author Rakesh 
 * program to create custom arraylist
 *
 */
public class CustomArrayList {

	private Object[] elements = new Object[10];
	private int elementCount = 0;

	// this method will add an element to at last of array
	public void add(Object obj) {
		if (size() == capacity()) {
			increaseCapacity();
		}
		elements[elementCount] = obj;
		elementCount++;
	}

	// increasing capacity
	protected void increaseCapacity() {
		int newCapacity = capacity() * 2;
		// new array creation with double capacity
		Object[] newArray = new Object[newCapacity];
		// copying the elements of previous array
		for (int i = 0; i < size(); i++) {
			newArray[i] = elements[i];
		}
		// changing array
		elements = newArray;
	}

	// this method will return the capacity of array
	protected int capacity() {

		return elements.length;
	}

	// this method return no of object we have stored inside an array
	protected int size() {

		return elementCount;
	}

	// checking given index is available in the array or not
	// if the given index exists between o and size() then retrieve and return
	public Object get(int index) {
		if ((index < 0) || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Enterd Index : " + index + "Size : " + size());
		}
		return elements[index];
	}

	// method for replacing object
	public void replace(int index, Object obj) {
		if ((index < 0) || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Enterd Index : " + index + "Size : " + size());
		}
		elements[index] = obj;
	}

	// removing/deleting element from the given array index
	public void remove(int index) {
		// move element from right to left one index from the given
		// index location
		if ((index < 0) || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Enterd Index : " + index + "Size : " + size());
		}
		while (index < size() - 1) {
			elements[index] = elements[index + 1];
			index++;
		}
		elements[index] = null;
		elementCount--;
	}

	// inserting an element to particular index
	// move element from left to right one index from size to given
	// index
	public void insert(int index, Object obj) {
		if ((index < 0) || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Enterd Index : " + index + "Size : " + size());
		}
		if (size() == capacity()) {
			increaseCapacity();
		}
		// moving element to next location
		for (int i = size() - 1; i > index; i--) {
			elements[i + 1] = elements[i];
		}

		elements[index] = obj;
		elementCount++;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < this.size(); i++) {
			sb.append(this.elements[i]);
			sb.append(",");
		} // for

		// deleting last semicolon
		int index = sb.lastIndexOf(",");
		if (index != -1) {
			sb.deleteCharAt(index);
		} // if
		sb.append("]");
		return sb.toString();
	}

	// deleting last element
	public static void main(String[] args) {
		CustomArrayList cl = new CustomArrayList();
		System.out.println("Initial Capacity : " + cl.capacity());
		System.out.println("Initial size : " + cl.size());
		cl.add("Rakesh");
		cl.add(10);
		System.out.println("After Insert size : " + cl.size());
		System.out.println("After Insert Capacity : " + cl.capacity());
	}

}
