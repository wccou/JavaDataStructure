package me.hitwcc.test;
/**
 * 
 * Title:面试题24 翻转链表
 * Description:
 * @author: wcc
 * @created: 2018年5月30日下午3:54:19
 */
public class Test24 {

	public Test24() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:非递归法
	 * 
	 * @author: wcc
	 * @created: 下午4:17:33
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head){
		ListNode reverseHead=null;
		ListNode node=head;
		ListNode pre=null;
		while(node!=null){
			ListNode next=node.next;
			if(next==null)
				reverseHead=node;
			node.next=pre;
			pre=node;
			node=next;
		}
		return reverseHead;
	}
	/**
	 * 
	 * @description:递归法
	 * @author: wcc
	 * @created: 下午4:22:07
	 * @param head
	 * @return
	 */
	public ListNode reverseList1(ListNode head){
		if(head==null||head.next==null)
			return head;
		ListNode reverseHead=reverseList1(head.next);
		head.next.next=head;
		head.next=null;
		return reverseHead;
	}
	
}
