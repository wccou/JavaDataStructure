package me.hitwcc.sort;

import java.util.Arrays;

public class MergeSort {
	/**
	 * 
	 * @description:
	 * @author: wcc
	 * @created: 下午4:47:04
	 * @param target 待排序数组
	 * @param left 起始位置
	 * @param right 结束位置
	 * @return
	 */
	public static int [] mergeSort(int[] target, int left, int right) {
		if (left < right){
			int mid = (left + right)/2;
			mergeSort(target, left, mid);
			mergeSort(target, mid + 1, right);
			merge(target, left, mid, right);
		}
		return target;
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
	 */
	public static void merge(int[] target, int left, int mid, int right){
		int [] temp = Arrays.copyOf(target, target.length);
		int s1 = left;
		int s2 = mid + 1;
		int index = left;
		while (s1 <= mid && s2 <= right){
			if(temp[s1] <= temp[s2]){
				target[index++] = temp[s1++];
			}else{
				target[index++] = temp[s2++];
			}
		}
		while(s1 <= mid){
			target[index++] = temp[s1++];
		}
		while(s2 <= right){
			target[index++] = temp[s2++];
		}
	}

	
	public static void main(String[] args){
		int[] a = {6, 7, 4, 8, 2, 1};
		MergeSort.mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
