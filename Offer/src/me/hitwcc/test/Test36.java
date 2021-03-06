package me.hitwcc.test;
/**
 * 
 * Title:面试题36 二叉搜索树转为双向链表
 * Description: 使用中序遍的递归方法
 * @author: wcc
 * @created: 2018年6月8日下午2:54:13
 */
public class Test36 {
	//双向链表的左头和右头
	TreeNode leftHead=null;
	TreeNode rightHead=null;
	public TreeNode Convert(TreeNode pRootOfTree){
		if(pRootOfTree==null) return null;//递归调用到叶子节点的左右节点时返回null
		Convert(pRootOfTree.left);
		//第一次运行时将会把最左叶子节点作为链表的第一个节点
		if(rightHead==null){
			leftHead=pRootOfTree;
			rightHead=pRootOfTree;
		}else{//把根节点插入到双向链表的右端并把rightHead向右移动
			rightHead.right=pRootOfTree;
			pRootOfTree.left=rightHead;
			rightHead=pRootOfTree;
		}
		Convert(pRootOfTree.right);
		return leftHead;//返回左头
	}
	

}


class TreeNode{
	int val=0;
	TreeNode left=null;
	TreeNode right=null;
	
	public TreeNode(int val){
		this.val=val;
	}
}