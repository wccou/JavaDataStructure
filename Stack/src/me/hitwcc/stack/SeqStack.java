package me.hitwcc.stack;
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
		this(10);
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
}
