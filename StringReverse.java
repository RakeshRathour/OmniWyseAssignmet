package com.omniwyse.OmniWyseAssignment2;

import java.util.Scanner;

public class StringReverse {
	public String wordReverse() {
		System.out.println("Enter any word : ");
		String word = new Scanner(System.in).next();
		StringBuilder sb = new StringBuilder();
		int size = word.length();
		Stack stack = new Stack(size);
		for (int i = 0; i < size; i++) {
			stack.push(word.charAt(i));
		}
		while (!stack.isStackEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		StringReverse sr = new StringReverse();
		System.out.println("Your Reverse String is : " + sr.wordReverse());
	}

}

class Stack {
	private int stackSize;
	private char[] stackArr;
	private int top;

	/**
	 * constructor to create stack with size
	 * 
	 * @param size
	 */
	public Stack(int size) {
		this.stackSize = size;
		this.stackArr = new char[stackSize];
		this.top = -1;
	}

	/**
	 * This method adds new entry to the top of the stack
	 * 
	 * @param entry
	 */
	public void push(char entry) {
		this.stackArr[++top] = entry;
	}

	/**
	 * This method removes an entry from the top of the stack.
	 */
	public char pop() {
		char entry = this.stackArr[top--];
		return entry;
	}

	/**
	 * This method returns true if the stack is empty
	 * 
	 */
	public boolean isStackEmpty() {
		return (top == -1);
	}

}
