package me.hitwcc.test;
/**
 * 
 * Title:面试题8找出二叉树中序遍历的下一个节点
 * Description:树中的节点除了有左右指针以外还有个指向父节点的指针
 * @author: wcc
 * @created: 2018年5月17日下午3:03:10
 */
public class Test8 {

	public Test8() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:分两种情况：1.当该节点有右子树时，则从右孩子出发，沿着左子节点指针
	 * 							一直到叶子节点即为所求
	 * 							2.没有右子树时，如果该节点是其父节点的左孩子，则返回父
	 * 							节点，否则向上遍历其父节点的父节点，直到找到这样的节点
	 * 							返回其父节点。
	 * @author: wcc
	 * @created: 下午3:46:47
	 * @param pNode
	 * @return
	 */
	public static int GetNext(BinaryTreeNode pNode){
		if(pNode==null)
			return -1;
		if(pNode.right!=null){
			pNode=pNode.right;
			while(pNode.left!=null)
				pNode=pNode.left;
			return pNode.val;
		}
		while(pNode.parent!=null){
			if(pNode==pNode.parent.left)
				return pNode.parent.val;
			pNode=pNode.parent;
		}
		return -1;
	}
	
	public static void assemble(BinaryTreeNode node,
            BinaryTreeNode left,
            BinaryTreeNode right,
            BinaryTreeNode parent) {
		node.left = left;
		node.right = right;
		node.parent = parent;
	}
	
	/**                            1
	 *                 2                         3
	 *        4                5          6                7
	 *    8        9       10    11    12    13        14     15
	 */
	public static void main(String[] args) {
		BinaryTreeNode n1 = new BinaryTreeNode(1); // 12
        BinaryTreeNode n2 = new BinaryTreeNode(2); // 10
        BinaryTreeNode n3 = new BinaryTreeNode(3); // 14
        BinaryTreeNode n4 = new BinaryTreeNode(4); // 9
        BinaryTreeNode n5 = new BinaryTreeNode(5); // 11
        BinaryTreeNode n6 = new BinaryTreeNode(6); // 13
        BinaryTreeNode n7 = new BinaryTreeNode(7); // 15
        BinaryTreeNode n8 = new BinaryTreeNode(8); // 4
        BinaryTreeNode n9 = new BinaryTreeNode(9); // 2
        BinaryTreeNode n10 = new BinaryTreeNode(10); // 5
        BinaryTreeNode n11 = new BinaryTreeNode(11); // 1
        BinaryTreeNode n12 = new BinaryTreeNode(12); // 6
        BinaryTreeNode n13 = new BinaryTreeNode(13); // 3
        BinaryTreeNode n14 = new BinaryTreeNode(14); // 7
        BinaryTreeNode n15 = new BinaryTreeNode(15); // null
        
        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        assemble(n4, n8, n9, n2);
        assemble(n5, n10, n11, n2);
        assemble(n6, n12, n13, n3);
        assemble(n7, n14, n15, n3);
        assemble(n8, null, null, n4);
        assemble(n9, null, null, n4);
        assemble(n10, null, null, n5);
        assemble(n11, null, null, n5);
        assemble(n12, null, null, n6);
        assemble(n13, null, null, n6);
        assemble(n14, null, null, n7);
        assemble(n15, null, null, n7);
        
        System.out.println(GetNext(n1));
        System.out.println(GetNext(n2));
        System.out.println(GetNext(n3));
        System.out.println(GetNext(n4));
        System.out.println(GetNext(n5));
        System.out.println(GetNext(n6));
        System.out.println(GetNext(n7));
        System.out.println(GetNext(n8));
        System.out.println(GetNext(n9));
        System.out.println(GetNext(n10));
        System.out.println(GetNext(n11));
        System.out.println(GetNext(n12));
        System.out.println(GetNext(n13));
        System.out.println(GetNext(n14));
        System.out.println(GetNext(n15));
	}
}
