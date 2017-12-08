package me.hitwcc.queue;

import me.hitwcc.stack.LinkedStack;

public class OptimizationStackQueue<E> {
	private LinkedStack<E> stack1;//队列空间
	private LinkedStack<E> stack2;//缓冲区
	public OptimizationStackQueue() {
		stack1 = new LinkedStack<E>();// TODO Auto-generated constructor stub
		stack2 = new LinkedStack<E>();
	}
	
	public void put(E data) {
		stack1.push(data);
	}
	/**
	 * 
	 * @description:删除队首元素并返回该值。 先判断Stack2是否为空，若为空则将1中元素全部倒回到2中，再对2进行弹栈
	 * @author: wcc  若不为空，直接对2进行弹栈操作
	 * @created: 下午6:50:36
	 * @return
	 * @throws Exception
	 */
	public E pop() throws Exception {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop().getData());
			}
		}
		return stack2.pop().getData();
	}
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (!stack2.isEmpty()) {
			sb.append(stack2.toString());
		}
		return sb.append(new StringBuffer(stack1.toString()).reverse().toString()).toString();
	}
	
	public static void main(String[] args) throws Exception{
		StackQueue<String> queue = new StackQueue<String>();

		queue.put("wcc");
		queue.put("is");
		queue.put("god");
		queue.put("aa");
		queue.pop();

		System.out.println(queue.toString());
		queue.pop();

		System.out.println(queue.toString());
		System.out.println();

	}
}
