package me.hitwcc.test;
/**
 * 
 * Title:面试题35 复杂链表的复制 时间复杂度O(n)
 * Description:
 * @author: wcc
 * @created: 2018年6月7日下午12:44:26
 */
public class Test35 {

	public Test35() {
		// TODO Auto-generated constructor stub
	}
	public RandomListNode Clone(RandomListNode pHead)
    {
		if(pHead==null)
			return null;
		
		//第一步
		cloneNodes(pHead);
		
		//第二步
		connectSiblingNodes(pHead);
		
		//第三步 拆分链表 奇数位置的是原始链表 偶数位置的为复制后的链表；
		RandomListNode clonedHead=reconnectNodes(pHead);
		
        return clonedHead;
    }
	
	public void cloneNodes(RandomListNode pHead){
		RandomListNode pNode=pHead;
		while(pNode!=null){
			RandomListNode pCloned=new RandomListNode(pNode.label);
			
			pCloned.next=pNode.next;
			pNode.next=pCloned;
			pCloned.random=null;
			pNode=pCloned.next;
		}
	}
	
	public void connectSiblingNodes(RandomListNode pHead){
		RandomListNode pNode=pHead;
		while(pNode!=null){
			RandomListNode pCloned=pNode.next;
			if(pNode.random!=null){
				pCloned.random=pNode.random.next;
			}
			pNode=pCloned.next;
		}
		
	}
	public RandomListNode reconnectNodes(RandomListNode pHead){
		RandomListNode pNode=pHead;
		RandomListNode clonedHead=null;
		RandomListNode clonedNode=null;
		if(pNode!=null){
			clonedHead=pNode.next;
			clonedNode=clonedHead;
			pNode.next=clonedNode.next;
			pNode=pNode.next;
		}
		while(pNode!=null){
			clonedNode.next=pNode.next;
			clonedNode=clonedNode.next;
			pNode.next=clonedNode.next;
			pNode=pNode.next;
		}
		return clonedHead;
		
	}
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}