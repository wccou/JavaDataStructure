package me.hitwcc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Title:面试题32 从上到下打印二叉树 层次遍历
 * Description:
 * @author: wcc
 * @created: 2018年6月6日下午3:23:15
 */
public class Test32 {

	public Test32() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:不分层打印
	 * @author: wcc
	 * @created: 下午4:25:40
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> printFromTopToBottom(BinaryTreeNode root) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(root==null)
			return list;
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode temp=queue.remove();
			list.add(temp.val);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		return list;
	}
	/**
	 * 
	 * @description:分层打印二叉树
	 * @author: wcc
	 * @created: 下午4:26:17
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> printFromTopToBottom1(BinaryTreeNode root) {
		if(root==null)
			return new ArrayList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();		
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		ArrayList<Integer> lineResult = new ArrayList<>();
		int nextLevel=0;
		int toBePrinted=1;
		while(!queue.isEmpty()){
			BinaryTreeNode temp=queue.remove();
			lineResult.add(temp.val);
			toBePrinted--;
			if(temp.left!=null){
				queue.add(temp.left);
				nextLevel++;
			}
				
			if(temp.right!=null){
				queue.add(temp.right);
				nextLevel++;
			}
			if(toBePrinted==0){
				list.add(lineResult);
				lineResult = new ArrayList<>();
				toBePrinted=nextLevel;
				nextLevel=0;
			}
				
		}
		return list;
	}
	/**
	 * 
	 * @description:之字形打印二叉树
	 * @author: wcc
	 * @created: 下午5:01:42
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer> > printFromTopToBottom3(BinaryTreeNode root) {
		if(root==null)
			return new ArrayList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();		
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		ArrayList<Integer> lineResult = new ArrayList<>();
		int nextLevel=0;
		int toBePrinted=1;
		boolean leftToRight=true;
		while(!queue.isEmpty()){
			BinaryTreeNode temp=queue.remove();
			lineResult.add(temp.val);
			toBePrinted--;
			if(temp.left!=null){
				queue.add(temp.left);
				nextLevel++;
			}
				
			if(temp.right!=null){
				queue.add(temp.right);
				nextLevel++;
			}
			if(toBePrinted==0){
				if(leftToRight){
					list.add(lineResult);
				}else{
					Collections.reverse(lineResult);
					list.add(lineResult);
				}
				leftToRight=!leftToRight;
				lineResult = new ArrayList<>();
				toBePrinted=nextLevel;
				nextLevel=0;
			}
				
		}
		return list;
	}
	
	public static void main(String args[])
	{
	BinaryTreeNode root1=new BinaryTreeNode();
	BinaryTreeNode node1=new BinaryTreeNode();
	BinaryTreeNode node2=new BinaryTreeNode();
	BinaryTreeNode node3=new BinaryTreeNode();
	BinaryTreeNode node4=new BinaryTreeNode();
	BinaryTreeNode node5=new BinaryTreeNode();
	BinaryTreeNode node6=new BinaryTreeNode();
	root1.left=node1;
	root1.right=node2;
	node1.left=node3;
	node1.right=node4;
	node4.left=node5;
	node4.right=node6;
	root1.val=8;
	node1.val=8;
	node2.val=7;
	node3.val=9;
	node4.val=2;
	node5.val=4;
	node6.val=7;
	Test32 test=new Test32();
	System.out.println(test.printFromTopToBottom3(root1));
	}
}
