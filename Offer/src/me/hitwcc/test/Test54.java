package me.hitwcc.test;

import java.util.ArrayList;

public class Test54 {
	int count=0;
	TreeNode t=null;
	TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null)
        	return null;
        KthNode(pRoot.left, k);
        count++;
        if (count == k) t = pRoot;
        KthNode(pRoot.right, k);
        return t;

    }

	
	TreeNode KthNode1(TreeNode pRoot, int k)
    {
		if(pRoot==null||k<=0)
			return null;
		ArrayList<TreeNode> array=new ArrayList<TreeNode>();
		inOrder(pRoot,array);
		if(k>array.size())
			return null;
		return array.get(k-1);
    }
	private void inOrder(TreeNode pRoot, ArrayList<TreeNode> array) {
		if(pRoot==null)
			return;
		inOrder(pRoot.left, array);
		array.add(pRoot);
		inOrder(pRoot.right, array);
		
	}

}
