package me.hitwcc.stack;

import java.util.LinkedList;

/**
 * 
 * Title:使用java的链表实现栈 很方便
 * Description:
 * @author: wcc
 * @created: 2017年12月6日下午5:46:27
 */
public class LinkedListStack<E> {
	private LinkedList<E> stack;
	/**
	 * 
	 * @description:构造函数
	 * @author: wcc
	 */
	public LinkedListStack() {
		stack = new LinkedList<E>();
	}
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	public void push(E element) {
		stack.addFirst(element);
	}
	public E pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("栈已空！");
		}
		return stack.pop();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return stack.toString();
	}
	public static void main(String[] args) throws Exception {
		LinkedListStack<String> stack = new LinkedListStack<String>();
		stack.push("wcc");
		stack.push("is");
		stack.push("god");
		stack.push("！");
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
	
}
