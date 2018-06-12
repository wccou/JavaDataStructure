package me.hitwcc.test;
/**
 * 
 * Title:面试题23 链表中环的入口节点 双指针法
 * Description:
 * @author: wcc
 * @created: 2018年5月30日下午3:08:09
 */
public class Test23 {
	public Test23() {
		// TODO Auto-generated constructor stub
	}
	
	public ListNode meetNode(ListNode head){
		if(head==null||head.next==null)
			return null;
		ListNode slow=head;
		ListNode fast=head;
		while(slow.next!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
				return fast;
		}
		return null;
	}
	
	public ListNode entryNodeOfLoop(ListNode head){
		ListNode meetNode=meetNode(head);
		if(meetNode==null)
			return null;
		int i=1;
		//System.out.println(i);
		ListNode meet=meetNode;
		while(meet.next!=meetNode){
			i++;
			//System.out.println(i);
			meet=meet.next;
		}
		System.out.println(i);
		ListNode p1=head;
		ListNode p2=head;
		for(int j=0;j<i;j++){
			p1=p1.next;
		}
		while(p1!=p2){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
	}
	/**
	 * 
	 * @description:方法2 找到环中任意一点之后 再让p1从头结点出发 p2从环中相遇点出发
	 * 				 再次相遇的就是入口点
	 * @author: wcc
	 * @created: 下午3:50:01
	 * @param head
	 * @return
	 */
	public ListNode entryOfLoop(ListNode head){
		ListNode meetNode=meetNode(head);
		if(meetNode==null)
			return null;
		ListNode p1=head;
		ListNode p2=meetNode;

		while(p1!=p2){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		Test23 test=new Test23();
		ListNode a=new ListNode();
		ListNode b=new ListNode();
		ListNode c=new ListNode();
		ListNode d=new ListNode();
		ListNode e=new ListNode();
		ListNode f=new ListNode();
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		e.next=f;
		f.next=c;
		a.val=1;
		b.val=2;
		c.val=3;
		d.val=4;
		e.val=5;
		f.val=6;
		System.out.println(test.entryOfLoop(a).val);
	}
}
