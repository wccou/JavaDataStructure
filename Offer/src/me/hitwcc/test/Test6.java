package me.hitwcc.test;

import java.util.Stack;

/**
 * 
 * Title:面试题6
 * Description:输入一个链表的头结点，从尾到头反过来打印每个节点的值
 * @author: wcc
 * @created: 2018年5月16日上午9:44:30
 */
public class Test6 {

	public Test6() {
		// TODO Auto-generated constructor stub
	}
	static class ListNode{
		int data;
		ListNode next;
	}
	/**
	 * 
	 * @description:使用栈的非递归实现
	 * @author: wcc
	 * @created: 上午9:59:48
	 * @param headNode
	 */
	public static void PrintListReverse(ListNode headNode) {
		if(headNode==null)
			System.out.println("null!");
		Stack<ListNode> stack=new Stack<ListNode>();
		while(headNode!=null){
			stack.push(headNode);
			headNode=headNode.next;
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().data);
		}
	}
	/**
	 * 
	 * @description:递归实现
	 * @author: wcc
	 * @created: 上午10:00:35
	 */
	public static void PrintListReverse1(ListNode headNode) {
		if(headNode==null)
			System.out.println("null!");
		if(headNode.next!=null)
			PrintListReverse1(headNode.next);
		System.out.println(headNode.data);
	}
	
	public static void main(String[] args) {
		ListNode node1=new ListNode();
		ListNode node2=new ListNode();
		ListNode node3=new ListNode();
		node1.data=1;
		node2.data=2;
		node3.data=3;
		node1.next=node2;
		node2.next=node3;
		PrintListReverse1(node1);
		System.out.println("*****************");
		PrintListReverse(node1);
	}

}
