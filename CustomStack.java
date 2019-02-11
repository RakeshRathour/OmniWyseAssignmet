package com.omniwyse.OmniWyseAssignment2;

/**
 * 
 * @author Rakesh 
 * program to creating custom stack with all functionality
 *
 */
public class CustomStack {
	private int stackSize;
	private int[] stackArr;
	private int top;

	/**
	 * constructor to create stack with size
	 */
	public CustomStack(int size) {
		this.stackSize = size;
		this.stackArr = new int[stackSize];
		this.top = -1;
	}

	/**
	 * This method adds new entry to the top of the stack
	 */
	public void push(int entry) {
		if (this.isStackFull()) {
			System.out.println(("Stack is full. Increasing the capacity."));
			this.increaseStackCapacity();
		}
		System.out.println("Adding: " + entry);
		this.stackArr[++top] = entry;
	}

	private boolean isStackFull() {
		return (top == -1);
	}

	/**
	 * This method removes an entry from the top of the stack.
	 */
	public int pop() throws Exception {
		if (this.isStackEmpty()) {
			throw new Exception("Stack is empty. Can not remove element.");
		}
		int entry = this.stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	private void increaseStackCapacity() {

		int[] newStack = new int[this.stackSize * 2];
		for (int i = 0; i < stackSize; i++) {
			newStack[i] = this.stackArr[i];
		}
		this.stackArr = newStack;
		this.stackSize = this.stackSize * 2;
	}

	/**
	 * This method returns true if the stack is empty
	 */
	public boolean isStackEmpty() {
		return (top == -1);
	}

	/**
	 * This method returns size of stack
	 */
	public int size() {
		return stackSize;

	}

}
