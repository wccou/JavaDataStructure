package me.hitwcc.list;

/** 
 * Title:链表的java实现
 * Description:链表结构包括两个要素：头结点head和链表大小size，以及链表的常用操作
 * @author: wcc
 * @created: 2017年12月5日上午9:53:09
 */
public class LinkedList<E> {
	private Node<E> head;
	private int size;
	
	public LinkedList(){
		this.head = new Node<E>(null);
		this.size = 0;
	}
	
	public Node<E> getHead(){
		return head;
	}
	
	/**
	 * 
	 * @description:返回链表长度  已测
	 * @author: wcc
	 * @created: 下午6:00:44
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 
	 * @description:向指定位置添加元素 返回新节点 已测
	 * @author: wcc
	 * @created: 上午10:21:27
	 * @param data
	 * @param index
	 * @return
	 */
	public Node<E> add(E data, int index) throws Exception {
		if (index > size) {
			throw new Exception("超出范围！");
		}
		Node<E> cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		Node<E> temp = cur.next; 
		Node<E> node = new Node<E>(data);
		cur.next = node;
		node.next = temp;
		size++;
		return node;
	}
	/**
	 * 
	 * @description:向尾部添加元素，返回新节点 已测
	 * @author: wcc
	 * @created: 上午10:41:21
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Node<E> add(E data) throws Exception {
		return add(data, size);
	}
	/**
	 * 
	 * @description:向链表尾部添加新节点 注意是节点 已测
	 * @author: wcc
	 * @created: 下午9:26:03
	 * @param node
	 */
	public void add(Node<E> node) {
		Node<E> cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;//向尾部添加节点
		while (node != null) { //修改链表大小
			size++;
			node = node.next;
		}
	}
	/**
	 * 
	 * @description:顺序打印输出链表 已测
	 * @author: wcc
	 * @created: 上午10:47:33
	 */
	public void print() {
		Node<E> cur = head.next;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}
	/**
	 * 
	 * @description:删除链表指定位置的元素 并返回该值  已测
	 * @author: wcc
	 * @created: 上午11:18:41
	 * @param index
	 * @return 被删除的节点的值
	 * @throws Exception
	 */
	public E remove(int index) throws Exception {
		if (index > size - 1 || index < 0) {
			throw new Exception("超出范围！");
		}
		Node<E> cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		Node<E> temp = cur.next;
		cur.next = temp.next;
		size--;
		
		return temp.data;
	}
	
	/**
	 * 
	 * @description:删除链表末尾元素 已测
	 * @author: wcc
	 * @created: 下午3:04:17
	 * @return
	 * @throws Exception
	 */
	public E remove() throws Exception { 
		return remove(size - 1);
	}
	
	/**
	 * 
	 * @description:删除链表里的重复元素，只保留一个 已测
	 * @author: wcc
	 * @created: 下午4:08:32
	 */
	public void deleteDuplicateNodes() {
		Node<E> cur = head.next;
		while (cur != null) {
			Node<E> temp = cur;
			while ( temp.next != null) {
				if (cur.data.equals(temp.next.data)) {//找到重复时 temp不动,继续往下找出所有重复
					Node<E> DupNode = temp.next;
					temp.next = DupNode.next;
					DupNode.next = null;
					size--;
				}
				else {     //没找到重复 temp++
					temp = temp.next;
				}
			}
			cur = cur.next;
		}
	}
	/**
	 * 
	 * @description:返回第k个元素值  已测
	 * @author: wcc
	 * @created: 下午5:08:30
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public E getK(int index) throws Exception {
		if (index > size) {
			throw new Exception("超出范围！");	
		}
		Node<E> node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.data;
	}
	/**
	 * 
	 * @description:返回倒数第K个元素 相当于返回正数第size-k+1个元素 已测
	 * @author: wcc
	 * @created: 下午5:22:26
	 * @param K
	 * @return
	 * @throws Exception
	 */
	public E getEndK(int K) throws Exception {
		if (K >size) {
			throw new Exception("超出范围！");
		}
		return getK(size - K + 1);
	}
	/**
	 * 
	 * @description:双指针法返回倒数第K个节点  两个指针相差K-1步 已测
	 * @author: wcc
	 * @created: 下午7:23:57
	 * @param K
	 * @return
	 * @throws Exception
	 */
	public Node<E> getEndK2(int K) throws Exception {
		if (K >size) {
			throw new Exception("超出范围！");
		}
		Node<E> p1 = head;
		Node<E> p2 = head;
		for(int i = 0; i < K - 1; i++) {//p1先走K-1步
			p1 = p1.next;
		}
		while (p1 != null && p1.next != null) {//当p1走到末尾时p2恰好走到倒数第K个元素
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2;
	}
	/**
	 * 
	 * @description:翻转链表  已测
	 * @author: wcc
	 * @created: 下午9:16:02
	 */
	public void reverseLinkedList() {
		Node<E> cur = head.next;
		Node<E> pre = null; // 反转后的链表
		while (cur != null) {
			Node<E> next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = pre;
		
	}
	/**
	 * 
	 * @description:递归的方法倒序打印 已测
	 * @author: wcc
	 * @created: 下午7:41:26
	 * @param head
	 */
	public void reversePrint(Node<E> head) {
		if (head.next != null) {
			reversePrint(head.next);
			System.out.print(head.next.data + " ");
		}
	}
	/**
	 * 
	 * @description:双指针法打印中间节点 按照序列号的就不写了 已测
	 * @author: wcc
	 * @created: 下午7:52:20
	 */
	public void middleNode() {
		Node<E> p1 = head.next;
		Node<E> p2 = head.next;
		while (p2 != null && p2.next != null && 
				p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		System.out.println(p1.data);
		if (p2.next != null) {
			System.out.println(p1.next.data);
		}
		
	}
	
	/**
	 * 
	 * @description:判断链表是否为空  已测
	 * @author: wcc
	 * @created: 下午7:25:23
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 
	 * @description:判断链表是否有环 待测
	 * @author: wcc
	 * @created: 下午8:21:37
	 * @return
	 */
	public boolean hasLoop(){
		Node<E> p1 = head;
		Node<E> p2 = head;
		while (p2 != null && p2.next != null && 
				p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @description:判断两个链表是否相交 取决于最后一个节点是否相同 已测
	 * @author: wcc 若两个链表相交 则从相交节点开始往后是共用的 即相交节点往后均相同
	 * @created: 下午8:30:31
	 * @param list23
	 * @return
	 */
	public boolean isIntersect(LinkedList<E> list2) {
		Node<E> p1 = head.next;
		Node<E> p2 = list2.getHead().next;
		while (p1.next != null) {
			p1 = p1.next;
		}
		while (p2.next != null) {
			p2 = p2.next;
		}
		
		return p1 == p2;
	}
	/**
	 * 
	 * @description:返回两链表的交点 已测
	 * @author: wcc
	 * @created: 下午8:57:41
	 * @param list2
	 * @return
	 */
	public Node<E> getIntersectPoint(LinkedList<E> list2) {
		Node<E> p1 = head.next;
		Node<E> p2 = list2.getHead().next;
		if (this.isIntersect(list2)) {//如果相交则继续 否则返回空
			int step = Math.abs(this.size - list2.size);  //计算两个链表的长度差 让长的先走step步，
			if (this.size > list2.size) {
				for (int i = 0; i < step; i++){
					p1 = p1.next;	
				}
			} else {
				p2 =p2.next;
			}                                             
			while (p1 != p2) {   //然后再同时移动，一旦指向同一节点即为节点
				p1 = p1.next;
				p2 = p2.next;
			}
			return p1;
		}
		return null;
	}
	/**
	 * 
	 * @description:在不知道头结点的情况下删除指定节点 已测
	 * @author: wcc
	 * @created: 下午9:13:49
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public boolean removeSpecifiedNode(Node<E> node) throws Exception {
		if (node == null || node.next == null) {
			return false;
		}
		Node<E> temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		temp.data = null;
		temp.next = null;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		LinkedList<String> list1 = new LinkedList<String>();
		list1.add("Rico");
		list1.add("Rico");
		list1.add("Livia");
		list1.add("TJU");
		list1.add("Livia");
		list1.add("NEU");
		list1.add("NEU");
		list1.add("Rico");
		list1.add("NEU");
		
		System.out.println("原链表：");
		list1.print();
		System.out.println();
		
		list1.remove();
		System.out.println("删除尾节点后的链表：");
		list1.print();
		
		System.out.println();
		
		list1.deleteDuplicateNodes();
		System.out.println("删除重复点后的链表：");
		list1.print();
		System.out.println();
		
		System.out.println("打印倒数第K个节点：");
		System.out.println(list1.getEndK2(2));
		System.out.println();
		
		list1.reverseLinkedList();
		System.out.println("反转链表：");
		list1.print();
		System.out.println();
		list1.reverseLinkedList();
		list1.print();
		System.out.println();
		
		System.out.println("倒序打印链表：");
		list1.reversePrint(list1.getHead());
		System.out.println();
		System.out.println();
		
		System.out.println("打印链表中间节点：");
		list1.middleNode();
		System.out.println();
		
		
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("书呆子");
		list2.add(list1.getEndK2(2));
		System.out.println("判断两链表是否相交：");
		list1.print();
		System.out.println();
		list2.print();
		System.out.println();
		System.out.println(list1.size() + " : " + list2.size());
		System.out.println("是否相交 : " + list1.isIntersect(list2));
		System.out.println("交点是 ： " + list1.getIntersectPoint(list2));
		System.out.println();
		
		list1.removeSpecifiedNode(list1.getEndK2(2));
		System.out.println("打印删除特定节点后的链表：");
		list1.print();
		
	}
	
}
