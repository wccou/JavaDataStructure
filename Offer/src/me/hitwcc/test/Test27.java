package me.hitwcc.test;

import java.util.Stack;

/**
 * 
 * Title:面试题27 二叉树镜像
 * Description:
 * @author: wcc
 * @created: 2018年6月1日下午2:25:33
 */
public class Test27 {

	public Test27() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:递归版
	 * @author: wcc
	 * @created: 下午2:45:01
	 * @param root
	 */
	public void mirror(BinaryTreeNode root) {
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		BinaryTreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		if(root.left!=null)
			mirror(root.left);
		if(root.right!=null)
			mirror(root.right);
	}
	
	public void mirror1(BinaryTreeNode root) {
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode node=stack.pop();
			if(node.left != null||node.right != null){
				BinaryTreeNode temp=node.left;
				node.left=node.right;
				node.right=temp;
			}
			
			if(node.left!=null)
				stack.push(node.left);
			if(node.right!=null)
				stack.push(node.right);
		}
	}
	
	
}
