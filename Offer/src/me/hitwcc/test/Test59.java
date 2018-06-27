package me.hitwcc.test;

import java.util.ArrayList;

/**
 * 
 * Title:面试题59 
 * Description:队列的最大值
 * @author: wcc
 * @created: 2018年6月27日下午3:27:00
 */
public class Test59 {

	public Test59() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
	 * @author: wcc
	 * @created: 下午3:48:33
	 * @param num
	 * @param size
	 * @return
	 */
	public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(num==null||size==0||size>num.length)
        	return list;
        for(int i=0;i<=num.length-size;i++){
        	int max=num[i];
        	for(int j=i+1;j<i+size;j++){
        		if(num[j]>max)
        			max=num[j];
        	}
        	list.add(max);
        }
        return list;
    }
}
