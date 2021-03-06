package me.hitwcc.test;

import java.util.ArrayList;

/**
 * 
 * Title:面试题40 
 * Description:最小的k个数  考虑是否可修改输入的数组 是否是海量数据 有不同的解法
 * @author: wcc
 * @created: 2018年6月14日下午3:07:46
 */
public class Test40 {

	public Test40() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:根据partition思想 缺点是修改了数组  海量数据不行
	 * @author: wcc
	 * @created: 下午4:10:03
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
		ArrayList<Integer> res = new ArrayList<Integer>();
	    if(input==null||input.length==0||k>input.length||k<=0){
	    	return res;
	    }
	    int start = 0;
	    int end = input.length-1;
	    int index = Partition(input,start,end);
	    while(index!=(k-1)){
	    	if(index>(k-1)){
	    		index = Partition(input,start,index-1);
	    	}
	    	else{
	    		index = Partition(input,index+1,end);
	    	}
	    }
	    for(int i=0;i<k;i++){
	    	res.add(input[i]);
	    }
	    return res;
	}
	private int Partition(int[] target, int left, int right) {
		int base = target[left];
		int base_index = left;
		while(left < right){
			while(left < right && target[right] >= base)//left<right的判断 不可少
				right --;
			while(left < right && target[left] <= base)//left<right的判断 不可少
				left ++;
			int temp = target[right];
			target[right] = target[left];
			target[left] = temp;
		}
		int temp = target[right];
		target[right] = base;
		target[base_index] = temp;
		return left;
	}
}
