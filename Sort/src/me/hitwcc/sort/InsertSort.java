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
	public static void main(String[] args) {
		int[] a = {1, 4, 5, 56, 2, 8, 3, 4};
		InsertSort.insertSort(a);
	}

}
