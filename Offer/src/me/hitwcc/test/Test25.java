package me.hitwcc.test;
/**
 * 
 * Title:合并两个有序链表 递归法和非递归法
 * Description:
 * @author: wcc
 * @created: 2018年5月31日下午3:40:49
 */
public class Test25 {

	public Test25() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:非递归法  主要问题在于要把合并后的头结点保存下来，不能把合并后的头结点作为工作指针
	 * 				否则运行结束将会指向链表的尾部
	 * @author: wcc
	 * @created: 下午4:01:24
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode merge(ListNode head1,ListNode head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		ListNode mergeHead=null;
		if(head1.val<head2.val){
			mergeHead=head1;
			mergeHead.next=merge(head1.next,head2);
		}else{
			mergeHead=head2;
			mergeHead.next=merge(head1,head2.next);
		}
		return mergeHead;
	}
	
	public ListNode merge1(ListNode head1,ListNode head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		ListNode mergeHead=null;
		if(head1.val<head2.val){
			mergeHead=head1;
			head1=head1.next;
		}else{
			mergeHead=head2;
			head2=head2.next;
		}
		ListNode temp=mergeHead;//工作指针
		while( head1!=null && head2!=null){
			if(head1.val<head2.val){
				temp.next=head1;
				head1=head1.next;
				temp=temp.next;
			}else{
				temp.next=head2;
				head2=head2.next;
				temp=temp.next;
			}
		}
		if(head1==null){
			temp.next=head2;
		}
		if(head2==null){
			temp.next=head1;
		}
		return mergeHead;
	}

}
