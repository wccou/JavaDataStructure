package me.hitwcc.test;
/**
 * 
 * Title:面试题52 两个链表的第一个公共节点
 * Description:
 * @author: wcc
 * @created: 2018年6月23日下午8:02:42
 */
public class Test52 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1==null||pHead2==null)
			 return null;
		 int l1=0;
		 int l2=0;
		 int s=0;
		 ListNode temp1=pHead1;
		 ListNode temp2=pHead2;
		 
		 while(temp1!=null){
			 l1++;
			 temp1=temp1.next;
		 }
		 while(temp2!=null){
			 l2++;
			 temp2=temp2.next;
		 }
		 ListNode temp3=pHead1;
		 ListNode temp4=pHead2;
		 if((l1-l2)>0){
			 s=l1-l2;
			 for(int i=0;i<s;i++){
				 temp3=temp3.next;
			 }
		 }else{
			 s=l2-l1;
			 for(int i=0;i<s;i++){
				 temp4=temp4.next;
			 }
		 }
		 while(temp3!=temp4){
			 temp3=temp3.next;
			 temp4=temp4.next;
		 }
		 return temp3;
    }

}
