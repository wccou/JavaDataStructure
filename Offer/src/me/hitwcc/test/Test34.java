package me.hitwcc.test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Title:面试题34 二叉树中和为某一值的路径 使用栈数据结构
 * Description:
 * @author: wcc
 * @created: 2018年6月7日下午12:03:19
 */
public class Test34 {

	public Test34() {
	
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode root,int target) {
        ArrayList<ArrayList<Integer>> pathList=new ArrayList<ArrayList<Integer>>();
		if(root==null)
        	return pathList;
		Stack<Integer> stack=new Stack<Integer>();
		int remainTarget=target;
		FindPath(root,remainTarget,stack,pathList);
		return pathList;
    }
	
	public void FindPath(BinaryTreeNode root,int remainTarget,Stack<Integer> path,
						 ArrayList<ArrayList<Integer>> pathList) {
		if(root==null)
            return;
		if(root.left==null&&root.right==null){
			if(root.val==remainTarget){
				ArrayList<Integer> list=new ArrayList<Integer>();
				for(int i:path){
					list.add(i);
				}
				list.add(root.val);
				pathList.add(list);
			}
		}else{
			path.push(root.val);
			FindPath(root.left,remainTarget-root.val,path,pathList);
			FindPath(root.right,remainTarget-root.val,path,pathList);
			path.pop();
		}
	}

}
