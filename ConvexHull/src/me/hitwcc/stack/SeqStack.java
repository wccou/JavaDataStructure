package me.hitwcc.stack;

import java.util.Arrays;

/**
 * 
 * Title:顺序栈
 * Description:底层使用数组实现
 * @author: wcc
 * @created: 2017年12月6日下午5:03:26
 */
public class SeqStack<E> {
	private Object[] stack;//数组
	private int top;  //栈顶指针
	private int maxSize;//最大容量
	public SeqStack() {
		this(100000);
	}
	/**
	 * 
	 * @description:构造函数可以指定容量的
	 * @author: wcc
	 * @param maxSize
	 */
	public SeqStack( int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		this.stack = new Object[maxSize];
	}
	/**
	 * 
	 * @description:判断是栈否为空
	 * @author: wcc
	 * @created: 下午5:15:39
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	/**
	 * 
	 * @description:push操作
	 * @author: wcc
	 * @created: 下午5:23:47
	 * @param element
	 * @throws Exception
	 */
	public void push(E element) throws Exception {
		if (top == maxSize - 1) {
			throw new Exception("栈已满！");
		}
		top++;
		stack[top] = element;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() throws Exception {
		if (top == -1 ) {
			throw new Exception("栈为空");
		}
		E element = (E)stack[top];
		stack[top] = null;
		top --;
		return element;
	}
	@SuppressWarnings("unchecked")
	public E top()throws Exception{
		if(top>=0)
			return (E)stack[top];
		else 
			throw new Exception("栈为空");
	}
	@SuppressWarnings("unchecked")
	public E nextToTop()throws Exception{
		if(top > 0)
			return (E)stack[top - 1];
		else 
			throw new Exception("栈为空");
	}
	/* (non-Javadoc)打印栈
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SeqStack [stack=" + Arrays.toString(stack) + "]";
	}
	
	
	public static void main(String[] args) throws Exception {
		SeqStack<String> stack = new SeqStack<String>(6);
		stack.push("wcc");
		stack.push("is");
		stack.push("god");
		stack.push("！");
		System.out.println(stack.top());
	
		System.out.println(stack.nextToTop());
	
	}
}
