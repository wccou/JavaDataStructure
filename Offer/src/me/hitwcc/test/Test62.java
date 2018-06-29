package me.hitwcc.test;

import java.util.LinkedList;

/**
 * 
 * Title:面试题62
 * Description:圆圈中最后剩下的数字
 * @author: wcc
 * @created: 2018年6月29日下午1:55:03
 */
public class Test62 {

	public Test62() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:使用链表 每次删除的数字的index都是往后数m-1个 需要注意取余来模拟环
	 * @author: wcc
	 * @created: 下午2:28:17
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
        
		LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
        	list.add(i);
        }
        int deleteNumber=0;
        while(list.size()>1){
        	deleteNumber=(deleteNumber+m-1)%list.size();
        	list.remove(deleteNumber);
        }
        return list.size()==1?list.get(0):-1;
    }
	/**
	 * 
	 * @description:环形链表法 先构造环形链表，然后每次删除第m个直到不能再删除
	 * @author: wcc
	 * @created: 下午2:46:45
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution1(int n, int m){
		if(m<=0||n<=0){
			return -1;
		}
		ListNode head=new ListNode(0);
		ListNode pre=head;
		for(int i=1;i<n;i++){
			ListNode temp=new ListNode(i);
			pre.next=temp;
			pre=temp;
		}
		pre.next=head;
		ListNode temp2=null;
		while(n!=1){
			temp2=head;
			for(int i=1;i<m-1;i++){
				temp2=temp2.next;
			}
			temp2.next=temp2.next.next;
			head=temp2.next;
			n--;
		}
		return head.val;
	}
}
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	
}
