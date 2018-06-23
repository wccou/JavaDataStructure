package me.hitwcc.test;

import java.util.Arrays;



/**
 * 
 * Title:面试题51
 * Description:数组中的逆序对 基于归并排序
 * @author: wcc
 * @created: 2018年6月22日下午5:18:17
 */
public class Test51 {

	public Test51() {
		// TODO Auto-generated constructor stub
	}

	
	public static int mergeSort(int[] target, int left, int right) {
		if(target==null||target.length==0||target.length ==1)
			return 0;
		int leftCount = 0;
		int rightCount = 0;
		int mergeCount = 0;
		if (left < right){
			int mid = (left + right)/2;
			leftCount=mergeSort(target, left, mid);
			rightCount=mergeSort(target, mid + 1, right);
			mergeCount=merge(target, left, mid, right);
		}
		return leftCount+rightCount+mergeCount;
	}
	/**
	 * 
	 * @description:两路归并
	 * @author: wcc
	 * @created: 下午4:45:50
	 * @param target 数组
	 * @param left第一个数组的起始位置
	 * @param mid第一个数组的最后元素位置
	 * @param right第二个数组的最后元素位置
	 * @return 
	 */
	public static int merge(int[] target, int left, int mid, int right){
		int [] temp = Arrays.copyOf(target, target.length);
		int s1 = left;
		int s2 = mid + 1;
		int index = left;
		int count=0;
		while (s1 <= mid && s2 <= right){
			if(temp[s1] <= temp[s2]){
				target[index++] = temp[s1++];
			}else{
				target[index++] = temp[s2++];
				count+=mid-s1+1;
			}
		}
		while(s1 <= mid){
			target[index++] = temp[s1++];
		}
		while(s2 <= right){
			target[index++] = temp[s2++];
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {6, 7, 4, 8, 2, 1};
		System.out.println(mergeSort(a, 0, a.length-1));
	}

}


