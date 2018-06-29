package me.hitwcc.test;

import java.util.LinkedList;

/**
 * 
 * Title:面试题62
 * Description:圆圈中最后剩下的数字
 * @author: wcc
 * @created: 2018年6月29日下午1:55:03
 */
public class Test62 {

	public Test62() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:使用链表 每次删除的数字的index都是往后数m-1个 需要注意取余来模拟环
	 * @author: wcc
	 * @created: 下午2:28:17
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
        
		LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
        	list.add(i);
        }
        int deleteNumber=0;
        while(list.size()>1){
        	deleteNumber=(deleteNumber+m-1)%list.size();
        	list.remove(deleteNumber);
        }
        return list.size()==1?list.get(0):-1;
    }
}
