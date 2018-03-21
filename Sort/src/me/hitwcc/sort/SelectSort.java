package me.hitwcc.sort;

import java.util.Arrays;

public class SelectSort {

	public static int[] selectSort(int[] target){
		int n = target.length;
		if (n == 0){
			System.out.println("it is a null array!");
		}else if(n == 1){
			System.out.println(Arrays.toString(target));
		}else{
			for (int i = 1; i < n; i ++){
				int minIndex = i - 1;
				for (int j = i; j < n; j ++){
					if (target[j] < target[minIndex]){
						minIndex = j;
					}
				}
				int temp = target[i - 1];
				target[i - 1] = target[minIndex];
				target[minIndex] = temp;
			}
			System.out.println(Arrays.toString(target));
		}
		
		return target;
	}

}
