package me.hitwcc.queue;
import me.hitwcc.stack.LinkedStack;;
public class StackQueue<E> {
	private LinkedStack<E> stack1;//队列空间
	private LinkedStack<E> stack2;//缓冲区
	public StackQueue() {
		stack1 = new LinkedStack<E>();// TODO Auto-generated constructor stub
		stack2 = new LinkedStack<E>();
	}
	/**
	 * 
	 * @description:入队操作  先看stack2是否为空 若为空则直接对1进行压栈 若不为空，
	 * @author: wcc  先把2的元素倒回到1里，再对1进行压栈 注意2是缓冲区
	 * @created: 下午6:19:32
	 * @param data
	 * @throws Exception
	 */
	public void put(E data) throws Exception {
		if (!stack2.isEmpty()) {
			while (stack2.size() > 0 ) {
				stack1.push(stack2.pop().getData());
			}
		}
		stack1.push(data);
	}
	
	/**
	 * 
	 * @description:出队操作 先看stack2是否为空 若为空 先将1里的size-1个元素倒回到3里 再将1栈底元素弹出
	 * @author: wcc         若不为空则直接对2弹栈
	 * @created: 下午6:21:19
	 * @return
	 * @throws Exception
	 */
	public E pop() throws Exception {
		if (stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				while (stack1.size()>1) {
					stack2.push(stack1.pop().getData());
				}
				return stack1.pop().getData();
			}
			return null;
		}else{
			return stack2.pop().getData();
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (!stack1.isEmpty()) {
			return new StringBuffer(stack1.toString()).reverse().toString();
		}
		return stack2.toString();
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
