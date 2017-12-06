package me.hitwcc.stack;

import java.util.Comparator;

/**
 * 
 * Title:自定义链式栈
 * Description:
 * @author: wcc
 * @created: 2017年12月6日下午7:16:13
 */
public class LinkedStack<E> {
	private Node<E> top;//栈顶元素
	private int size;
	
	private LinkedStack<E> min;//最小值栈 用来存放最小值 如果入栈元素比原来栈中的最小值还小，
							//将其保存在最小值栈中 否则只入栈，对最小值栈不做操作
	public LinkedStack() {
		// 构造函数
	}
	/**
	 * 
	 * @description:判断栈是否为空 根据size判断
	 * @author: wcc
	 * @created: 下午7:24:29
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 
	 * @description:push操作
	 * @author: wcc
	 * @created: 下午7:30:49
	 * @param data
	 */
	public void push(E data) {
		Node<E> node = new Node<E>(data); //新建节点
		node.next = top;
		top = node;
		size ++;
	}
	/**
	 * 
	 * @description:pop操作
	 * @author: wcc
	 * @created: 下午7:34:42
	 * @return
	 * @throws Exception
	 */
	public Node<E> pop() throws Exception {
		if (this.isEmpty()){
			throw new Exception("已经是栈底啦！");
		}
		Node<E> node = top;
		top = node.next;
		node.next = null;
		size --;
		return node;
	}
	/**
	 * 
	 * @description:弹出栈顶元素
	 * @author: wcc
	 * @created: 下午8:02:29
	 * @return
	 */
	public Node<E> peek() {
		if (isEmpty()){
			return null;
		}
		return top;
	}
	
	/**
	 * 
	 * @description:维护最小值栈的push
	 * @author: wcc
	 * @created: 下午8:05:24
	 * @param data
	 * @param c
	 */
	public void push(E data, Comparator<E> c) {
		push(data);
		if (min == null) {
			min = new LinkedStack<E>();
			min.push(data);
		}else if(c.compare(this.peek().data, min.peek().data) < 0) {
			min.push(data);
		}
		
	}
	public Node<E> pop(Comparator<E> c) throws Exception {
		Node<E> temp = this.pop();
		if (temp != null && min.peek() != null) {
			if (c.compare(temp.data, min.peek().data) >= 0) {
				return min.pop();
			}
		}
		return temp;
	}
	public Node<E> min() {
		if (min.peek() == null) {
			return null;
		}else{
			return min.peek();
		}
	}
	
	/**
	 * 
	 * @description:打印栈
	 * @author: wcc
	 * @created: 下午7:46:21
	 */
	public void print() {
		Node<E> node = top;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @description:返回栈的大小
	 * @author: wcc
	 * @created: 下午7:37:24
	 * @return
	 */
	public int size() {
		return this.size;
	}
	/**
	 * 
	 * @description:返回最小值栈
	 * @author: wcc
	 * @created: 下午7:38:29
	 * @return
	 */
	public LinkedStack<E> getMin() {
		return this.min;
	}
	/**
	 * 
	 * @description:设置最小值栈
	 * @author: wcc
	 * @created: 下午7:39:31
	 * @param min
	 */
	public void setMin(LinkedStack<E> min) {
		this.min = min;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Node<E> node = top;
		StringBuffer sb = new StringBuffer();//stringbuffer线程安全 且适合经常改变的字符串变量 占内存小
		while(node != null) {
			sb.append(node.data).append(" ");
			node = node.next;
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2)
					return 1;
				else if(o1 < o2)
					return -1;
				else
					return 0;
			}
		};
		
		stack.push(7,c);
		stack.push(6,c);
		stack.push(8,c);
		stack.push(5,c);
		stack.push(3,c);
		
		System.out.println("原栈(最左边元素是栈顶元素)：");
		stack.print();
		System.out.println();
		
		System.out.println("弹出栈顶元素：");
		System.out.println(stack.peek());
		System.out.println("栈中的最小值：" + stack.min());
		System.out.println();

		System.out.println("弹出并删除栈顶元素后的链表：");
		stack.pop(c);
		stack.print();
		System.out.println("栈中的最小值：" + stack.min());
		System.out.println();
	}
	
	
}
