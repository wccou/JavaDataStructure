package me.hitwcc.queue;

public class LinkedQueue<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	public LinkedQueue() {
		head = tail = new Node<E>(null);// TODO Auto-generated constructor stub
		
	}
	/**
	 * 
	 * @description:判断是否为空
	 * @author: wcc
	 * @created: 下午5:18:36
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 
	 * @description:返回队列大小
	 * @author: wcc
	 * @created: 下午5:19:10
	 * @return
	 */
	public int size() {
		return size;
	}
	/**
	 * 
	 * @description:入队操作 向队尾添加元素 移动尾指针
	 * @author: wcc
	 * @created: 下午5:17:24
	 * @param data
	 */
	public void put(E data) {
		Node<E> node = new Node<E>(data);
		tail.next = node;
		tail = node;
		size ++;
	}
	/**
	 * 
	 * @description:出队操作 删除队首元素并返回该值
	 * @author: wcc
	 * @created: 下午5:24:48
	 * @return
	 */
	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		E e = null;
		Node<E> temp = head.next;
		e = temp.data;
		head.next = temp.next;

		temp.data = null;
		temp.next = null;
		size --;
		return e;
	}
	/**
	 * 
	 * @description:仅返回队首元素值
	 * @author: wcc
	 * @created: 下午5:26:39
	 * @return
	 */
	public E peek() {
		if (this.isEmpty()) {
			return null;
		}
		Node<E> temp = head.next;
		E e = null;
		e = temp.data;
		return e;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Node<E> temp = head.next;
		StringBuffer sb = new StringBuffer();
		while (temp != null) {
			sb.append(temp.data).append(" ");
			temp = temp.next;
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception{
		LinkedQueue<String> queue = new LinkedQueue<String>();
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
