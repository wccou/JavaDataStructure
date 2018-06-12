package me.hitwcc.test;
/**
 * 
 * Title:面试题26 树的子结构
 * Description:
 * @author: wcc
 * @created: 2018年5月31日下午4:35:45
 */
public class Test26 {

	public Test26() {
		// TODO Auto-generated constructor stub
	}
	public boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2) {
		boolean result=false;
		if(root1!=null&&root2!=null){
			if(root1.val==root2.val)
				result=doesTree1HaveTree2(root1,root2);
			if(!result){
				result=hasSubTree(root1.left, root2);
			}
			if(!result){
				result=hasSubTree(root1.right, root2);
			}
		}
		return result;
	}
	
	public boolean doesTree1HaveTree2(BinaryTreeNode root1,BinaryTreeNode root2) {
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(root1.val!=root2.val)
			return false;
		return doesTree1HaveTree2(root1.left, root2.left)
				&&doesTree1HaveTree2(root1.right, root2.right);
	}
}
