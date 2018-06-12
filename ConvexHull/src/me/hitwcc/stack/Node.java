package me.hitwcc.stack;
/**
 * 
 * Title:
 * Description:
 * @author: wcc
 * @created: 2017年12月6日上午11:17:39
 */
public class Node<T> {
	T data;
	Node<T> next;
	/**
	 * 
	 * @description:构造函数
	 * @author: wcc
	 * @param data
	 */

	public Node(T data) {
		this.data = data;// TODO Auto-generated constructor stub
		this.next = null;
	}
	/**
	 * 
	 * @description: 返回元素值
	 * @author: wcc
	 * @created: 上午11:19:45
	 * @return
	 */
	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	
	
}
