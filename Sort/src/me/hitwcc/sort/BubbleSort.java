package me.hitwcc.sort;

import java.util.Arrays;

/**
 * 
 * Title:冒泡排序
 * Description:每次比较相邻两个 然后根据交换结果交换位置 大的沉到下面
 * @author: wcc
 * @created: 2018年3月17日下午4:53:33
 */
public class BubbleSort {

	public static int[] bubbleSort(int[] target) {
		int n = target.length;
		if ( n == 0) {
			System.out.println("空数组！");
		}
		else if( n == 1) {
			System.out.println(Arrays.toString(target));
			return target;
		}
		else {
			for ( int i = 1; i < n; i++) {
				for ( int j = 0; j < n - i; j ++ ) {
					if (target[j] > target[j+1]) {
						int temp = target[j];
						target[j] = target[j+1];
						target[j+1] = temp;
						
					}
				}
			}
			System.out.println(Arrays.toString(target));
		}
		return target;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:优化的冒泡 加一个标志位，当某一趟冒泡排序没有元素交换时，则冒泡结束，元素已经有序，可以有效的减少冒泡次数。
	 * @author: wcc
	 * @created: 下午9:59:44
	 * @param target
	 * @return
	 */
	public static int[] bubbleSortMy(int[] target) {
		if(target==null||target.length ==0)
			return null;
		int n=target.length;
		if(n==1){
			return target;
		}else {
			boolean flag=true;
			for(int i=0;i<n-1&&flag;i++) {
				flag=false;
				for(int j=n-1;j>i;j--) {
					if(target[j]<target[j-1]) {
						int temp = target[j];
						target[j] = target[j-1];
						target[j-1] = temp;
						flag=true;
					}
				}
			}
			System.out.println(Arrays.toString(target));
		}
		return target;
	}
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,10,11,4};
		BubbleSort.bubbleSortMy(a);
	}

}
