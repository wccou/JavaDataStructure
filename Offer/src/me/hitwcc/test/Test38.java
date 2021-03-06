package me.hitwcc.test;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 * Title:面试题38 字符串的排列
 * Description:
 * @author: wcc
 * @created: 2018年6月8日下午4:00:56
 */
public class Test38 {

	public Test38() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:递归法 剑指上的思想
	 * @author: wcc
	 * @created: 下午1:50:48
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str){
		ArrayList<String> res = new ArrayList<String>();
		if(str==null||str.length()==0)
			return res;
		char[] charArray = str.toCharArray();
		TreeSet<String> tempRes = new TreeSet<String>();
		PermutationCore(charArray,tempRes,0);
		res.addAll(tempRes);
		return res;
		
	}
	private void PermutationCore(char[] charArray, TreeSet<String> tempRes, int loc) {
		// TODO Auto-generated method stub
		if(charArray==null||charArray.length==0||loc<0){
			return;
		}
		if(loc==charArray.length-1){
			tempRes.add(String.valueOf(charArray));
		}
		else{
			for(int i=loc;i<charArray.length;i++){
				swap(charArray,i,loc);//将第一个字符与后面的字符交换 注意换了后再对后面进行全排列后还要再换回来
				PermutationCore(charArray,tempRes,loc+1);//对后面所有的字符进行全排列  
				swap(charArray,i,loc);//再将之前交换的字符交换回来，以便第一个字符再与其他字符交换  
			}
		}
	}
	private void swap(char[] charArray, int i, int loc) {
		char temp = charArray[i];
		charArray[i] = charArray[loc];
		charArray[loc] = temp;
	}

}
