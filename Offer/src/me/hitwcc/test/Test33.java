package me.hitwcc.test;

import java.util.Arrays;

/**
 * 
 * Title:面试题33 二叉搜索树的后序遍历序列
 * Description:判断一个数组是不是某二叉搜索树的后序遍历序列
 * @author: wcc
 * @created: 2018年6月6日下午5:10:47
 */
public class Test33 {

	public Test33() {
		// TODO Auto-generated constructor stub
	}
	public boolean verifySequenceOfBST(int[] sequence) {
		if(sequence==null||sequence.length==0)
			return false;
		int length=sequence.length;
		int root=sequence[length-1];

		int i=0;
		for(;i<length-1;i++){
	
			if(sequence[i]>root){
				break;					
			}
		}
		int j=i;
		for(;j<length-1;j++){
			if(sequence[j]<root)
				return false;
		}
		boolean left=true;
		if(i>0)
			left=verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		boolean right=true;
		if(i<length-1)
			right=verifySequenceOfBST(Arrays.copyOfRange(sequence, i, length-1));

		return left&&right;
	}
}
