package me.hitwcc.test;
/**
 * 
 * Title:面试题37 序列化二叉树
 * Description:请实现两个函数，分别用来序列化和反序列化二叉树
 * @author: wcc
 * @created: 2018年6月8日下午3:12:30
 */
public class Test37 {
	int index=-1;
	String Serialize(TreeNode root) {
		StringBuilder sb=new StringBuilder();
		if(root==null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
        
	}
	TreeNode Deserialize(String str) {
		index++;
		if(index>=str.length()){
			return  null;
		}
		String[] strr=str.split(",");
		TreeNode node=new TreeNode(0);//新建一个节点
		if(!strr[index].equals("#")){
			node=new TreeNode(Integer.valueOf(strr[index]));
			node.left=Deserialize(str);
			node.right=Deserialize(str);
		}
		return node;
	       
	}
}
