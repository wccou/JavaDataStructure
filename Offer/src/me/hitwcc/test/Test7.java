package me.hitwcc.test;

import java.util.Arrays;

/**
 * 
 * Title:面试题7重建二叉树
 * Description:输入前序和中序遍历结果 重建该二叉树
 * @author: wcc
 * @created: 2018年5月16日上午10:06:35
 */
public class Test7 {
	public static class BinaryTreeNode{
		public int value;
		BinaryTreeNode leftNode;
		BinaryTreeNode rightNode;
	}
	
	public static BinaryTreeNode ConstructCore(int[] preorder,int[] inorder){
		if(preorder==null||inorder==null)
			return null;
		if(preorder.length!=inorder.length)
			System.out.println("长度不一样，非法的输入！");
		
		BinaryTreeNode root=new BinaryTreeNode();
		for(int i=0;i<inorder.length;i++){
			if(preorder[0]==inorder[i]){
				root.value=inorder[i];
				System.out.println(root.value);
				root.leftNode=ConstructCore(Arrays.copyOfRange(preorder, 1, i+1), 
				Arrays.copyOfRange(inorder, 0, i));
				root.rightNode=ConstructCore(Arrays.copyOfRange(preorder, i+1, preorder.length), 
				Arrays.copyOfRange(inorder, i+1, inorder.length));
			}
		}
		
		return root;
	}
	
	public Test7() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		BinaryTreeNode root=ConstructCore(pre, in);
		
		
	}

}
