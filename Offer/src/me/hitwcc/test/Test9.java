package me.hitwcc.test;

import java.util.Stack;

/**
 * 
 * Title:面试题9：使用两个堆栈实现队列的入队和出队操作
 * Description: 注意队列是先进先出的 堆栈是先进后出的特点
 * @author: wcc
 * @created: 2018年5月17日下午4:21:24
 */
public class Test9<T> {
	private Stack<T> stack1=new Stack<T>();
	private Stack<T> stack2=new Stack<T>();
	
	public Test9() {
		// TODO Auto-generated constructor stub
	}
	
	public void appendTail(T t){
		stack1.push(t);
	}
	
	public T deleteHead() throws Exception{
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty())
			throw new Exception("队列为空不能删除！");
		return stack2.pop();
	}
	
	public static void main(String args[]) throws Exception
	{
		Test9<String> p7=new Test9<>();
		p7.appendTail("1");
		p7.appendTail("2");
		p7.appendTail("3");
		System.out.println(p7.deleteHead());
		System.out.println(p7.deleteHead());
		System.out.println(p7.deleteHead());


	}
}
