package me.hitwcc.test;
/**
 * 
 * Title:对称的二叉树
 * Description:采用递归的方法
 * @author: wcc
 * @created: 2018年6月1日下午3:27:38
 */
public class Test28 {

	public Test28() {
		// TODO Auto-generated constructor stub
	}
	public boolean isSymmetrical(BinaryTreeNode root){
		
		return isMirror(root,root);
	}
	public boolean isMirror(BinaryTreeNode root1,BinaryTreeNode root2){
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.val==root2.val)
			return isMirror(root1.left,root2.right)
				   &&isMirror(root1.right,root2.left);
		return false;
		
	}
	
}
