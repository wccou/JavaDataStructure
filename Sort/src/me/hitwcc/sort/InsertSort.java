package me.hitwcc.sort;

import java.util.Arrays;

public class InsertSort {

	public static int[] insertSort(int[] target) {
		int n = target.length;
		if (n == 0){
			System.out.println("空数组！");	
		}else if(n == 1){
			System.out.println(Arrays.toString(target));
		}else{	
			for (int i = 0; i < n -1; i++){
				for (int j = i+1; j < n; j ++){
					if (target[i]>target[j]){
						int temp = target[i];
						target[i] = target[j];
						target[j] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(target));
		return target;
	}
	
	
	/**
	 * 
	 * @description:这个才是插入排序 默认第一个元素已经排好序 然后不停的拿出一个无序插入
	 * 到前面有序的数组中 因此外层有n-1次循环 内层循环是新元素和前面每一个有序的元素进行比较
	 * 如果前面的大于新元素 则交换位置 直至找到合适位置跳出内循环 （内循环不跳出也行）
	 * @author: wcc
	 * @created: 下午4:52:30
	 * @param target
	 * @return
	 */
	public static int[] insertSort2(int[] target){
		int n=target.length;
		if (n == 0){
			System.out.println("空数组！");	
		}else if(n == 1){
			System.out.println(Arrays.toString(target));
		}else{	
			for (int i=1;i<n;i++){
				for (int j = i;j>0;j--){
					if(target[j]<target[j-1]){
						int temp=target[j];
						target[j] = target[j-1];
						target[j-1]=temp;
					}else{
						break;
					}
					
					
				}
			}
		}
		System.out.println(Arrays.toString(target));
		return target;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] a = {1, 5, 5, 56, 2, 8, 3, 4};
		InsertSort.insertSort(a);
		InsertSort.insertSort2(a);
		//InsertSort.insertSort3(a);
	}
}
