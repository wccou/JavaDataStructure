package me.hitwcc.test;
/**
 * 
 * Title:面试题18
 * Description:删除链表的节点（删除某节点和删除重复节点（将重复的都删掉，不用保留一个））
 * @author: wcc
 * @created: 2018年5月26日下午5:34:22
 */
public class Test18 {

	public Test18() {
		// TODO Auto-generated constructor stub
	}
	
	public void deleteNode(ListNode head,ListNode deleteNode) {
		if(head==null||deleteNode==null)
			return;
		if(head==deleteNode)//如果要删的是头结点
			head=null;
		if(deleteNode.next==null){//如果要删的是尾节点
			ListNode tempNode=head;
			while(tempNode.next.next!=null){
				tempNode=tempNode.next;
			}
			tempNode.next=null;
		}else{//要删的是中间的节点
			ListNode temp=deleteNode.next;
			deleteNode.val=temp.val;
			deleteNode.next=temp.next;
		}
	}
	/**
	 * 
	 * @description:递归法求解 很巧妙
	 * @author: wcc
	 * @created: 下午4:40:34
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead==null||pHead.next==null)
			return pHead;
		if(pHead.val==pHead.next.val){
			ListNode pNode=pHead.next;
			while(pNode!=null&&pNode.val==pHead.val){
				pNode=pNode.next;
			}
			return deleteDuplication(pNode);
		}else{
			pHead.next=deleteDuplication(pHead.next);
			return pHead;
		}
		
    }
	/**
	 * 
	 * @description:正常方法
	 * @author: wcc
	 * @created: 下午4:40:51
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication2(ListNode pHead) {
		if(pHead==null||pHead.next==null)
			return pHead;
		ListNode first=new ListNode();//为了避免删除头结点 新建一个节点指向头结点
		first.next=pHead;
		ListNode current=pHead;//当前考察的节点
		ListNode start=first;//重复的节点的前一个节点
		while(current!=null&&current.next!=null){
			if(current.val==current.next.val){
				int value=current.val;
				while(current!=null&&current.val==value){
					current=current.next;
				}
				start.next=current;
			}else{
				start=current;
				current=current.next;
			}
		}
		return first.next;
	}
	
	public static void main(String[] args) {
		ListNode head=new ListNode();
		ListNode second=new ListNode();
		ListNode third=new ListNode();
		head.next=second;
		second.next=third;
		head.val=1;
		second.val=2;
		third.val=3;
		Test18 p13=new Test18();
		p13.deleteNode(head, second);
		System.out.println(head.next.val);
		}
}

