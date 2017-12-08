package me.hitwcc.queue;

import java.util.Arrays;

public class SeqQueue<E> {
	private Object[] queue; //数组实现队列 先进先出的特性
	private int size; //队列当前大小
	private int maxSize;//队列的最大容量
	public SeqQueue(int maxSize) {//构造函数 指定最大容量
		this.maxSize = maxSize;// TODO Auto-generated constructor stub
		queue = new Object[maxSize];
		size = 0;
	}
	/**
	 * 
	 * @description:判断是否已经满
	 * @author: wcc
	 * @created: 下午4:45:14
	 * @return
	 */
	public boolean isFull() {
		return size == maxSize;
	}
	/**
	 * 
	 * @description:判断是否为空
	 * @author: wcc
	 * @created: 下午4:45:21
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 
	 * @description: 入队 添加元素到队列尾部
	 * @author: wcc
	 * @created: 下午4:42:50
	 * @param data
	 * @throws Exception
	 */
	public void put(E data) throws Exception {
		if (this.isFull()) {
			throw new Exception("队列已满！");
		}
		queue[size] = data;
		size ++;
	}
	/**
	 * 
	 * @description:出队 删除队首元素并返回队首元素
	 * @author: wcc
	 * @created: 下午4:47:13
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E pop() {
		if (!this.isEmpty()) {
			E temp = (E) queue[0];
			for (int i = 0; i < size - 1; i++) {
				queue[i] = queue[i + 1];
			}
			queue[size - 1] = null;
			size --;
			return temp;
		}
		return null;
	}
	/**
	 * 
	 * @description:仅返回队首元素 不删除
	 * @author: wcc
	 * @created: 下午4:55:53
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		if (! this.isEmpty()) {
			return (E) queue[0];
		}
		return null;
	}
	/**
	 * 
	 * @description:返回队列大小
	 * @author: wcc
	 * @created: 下午4:57:49
	 * @return
	 */
	public int size() {
		return size;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SeqQueue [queue=" + Arrays.toString(queue) + "]";
	}
	
	public static void main(String[] args) throws Exception{
		SeqQueue<String> queue = new SeqQueue<String>(12);
		System.out.println(queue.size());
		queue.put("wcc");
		queue.put("is");
		queue.put("god");
		queue.put("aa");
		queue.pop();
		System.out.println(queue.size());
		System.out.println(queue.toString());
		queue.pop();
		System.out.println(queue.size());
		System.out.println(queue.toString());
		System.out.println();
		System.out.println(queue.peek());
	}

}
