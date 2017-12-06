package me.hitwcc.list;
/**
 * 
 * Title: l链表节点类
 * Description: 链表基本元素 数据和下一节点
 * @author: wcc
 * @created: 2017年12月5日上午9:51:22
 * @param <T>
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
	public Node(T data){
		this.data = data;
		this.next = null;
	}
	@Override
	public String toString(){
		return data.toString();
	}
}
