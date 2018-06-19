package me.hitwcc.test;

import java.util.Stack;

/**
 * 
 * Title:包含min函数的栈 
 * Description:min函数复杂度同样要为1 主要注意push操作时对minStack的操作
 * @author: wcc
 * @created: 2018年6月5日下午4:20:28
 */
public class Test30 {
	private Stack<Integer> minStack = new Stack<Integer>();
	private Stack<Integer> dataStack = new Stack<Integer>();
	public void push(int node){
		dataStack.push(node);
		if(minStack.isEmpty()||node<=minStack.peek()){
			minStack.push(node);
		}else{
			minStack.push(minStack.peek());
		}
	}
	public void pop(){
		if(!(dataStack.isEmpty()||minStack.isEmpty())){
			dataStack.pop();
			minStack.pop();
		}
	}
	public int top(){
		if(dataStack.isEmpty())
			return (Integer) null;
		return dataStack.peek();
	}
	public int min(){
		if(minStack.isEmpty())
			return (Integer) null;
		return minStack.peek();
	}
	

}
