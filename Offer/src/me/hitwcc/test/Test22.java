package me.hitwcc.test;
/**
 * 
 * Title:面试题22 链表中倒数第K个节点 双指针法 考虑鲁棒性
 * Description:
 * @author: wcc
 * @created: 2018年5月30日上午11:38:37
 */
public class Test22 {

	public Test22() {
		// TODO Auto-generated constructor stub
	}

	public ListNode findKthToTail(ListNode listHead,int k) {
		if(listHead==null)
			return null;
		if(k==0)
			return null;
		ListNode p1=listHead;
		ListNode p2=listHead;
		for(int i=0;i<k-1;i++){
			if(p1.next!=null)
				p1=p1.next;
			else
				return null;
		}
		while(p1.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p2;
		/*if(head==null||k==0){
			return null;
			}
			ListNode resultNode=null;
			ListNode headListNode=head;
			for(int i=0;i<k;++i){
			if(headListNode.next!=null){
			headListNode=headListNode.next;
			}else{
			return null;
			}
			}
			resultNode=head;
			while(headListNode!=null){
			resultNode=resultNode.next;
			headListNode=headListNode.next;
			}
			return resultNode;*/
	}
	public static void main(String[] args) {
		Test22 test=new Test22();
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
		a.val=1;
		b.val=2;
		c.val=3;
		d.val=4;
		e.val=5;
		f.val=6;
		System.out.println(test.findKthToTail(a, 5).val);
	}
}

