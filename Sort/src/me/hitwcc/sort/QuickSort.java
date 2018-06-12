package me.hitwcc.sort;

import java.util.Arrays;

public class QuickSort {
	public static int[] BubbleSort(int[] target){
		int n = target.length;
		System.out.println(n);
		if (n == 0){
			System.out.println("it is a null array!");;
		}else if (n == 1){
			return target;
		}else{
			for (int i = 1; i < n; i ++){
				for (int j = n - 1; j > i - 1; j--){
					if (target[j] < target[j - 1]){
						int temp = target[j];
						target[j] = target[j - 1];
						target[j - 1] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(target));
		}	
		return target;
	}
	public static int[] BubbleSort2(int[] target){
		int n = target.length;
		System.out.println(n);
		if (n == 0){
			System.out.println("it is a null array!");;
		}else if (n == 1){
			return target;
		}else{
			for (int i = 1; i < n; i ++){
				for (int j = 0; j < n - i; j ++){
					if (target[j] > target[j + 1]){
						int temp = target[j];
						target[j] = target[j + 1];
						target[j + 1] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(target));
		}	
		return target;
	}
	
	public static int[] InsertSort(int[] target){
		int n = target.length;
		System.out.println(n);
		if (n == 0){
			System.out.println("it is a null array!");;
		}else if (n == 1){
			return target;
		}else{
			for (int i = 1; i < n; i ++){
				for (int j = i; j > 0; j --){
					if (target[j] < target[j - 1]){
						int temp = target[j];
						target[j] = target[j - 1];
						target[j - 1] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(target));
		}	
		return target;
	}
	public static int[] SelectSort(int[] target){
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
	
	
	
	public static int Partition(int[] target, int left, int right){
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
	
	public static int[] quickSort(int[] target, int left, int right) {
		if (right > left){
			int partition_index = Partition(target,left,right);
			quickSort(target,left,partition_index - 1);
			quickSort(target,partition_index + 1,right);
			
		}
		//System.out.println(Arrays.toString(target));
		return target;
	}
	public static void main(String[] args){
		int[] a = {6, 7, 4, 8, 2, 1, 5, 25, 3};
/*		QuickSort.BubbleSort2(a);
		QuickSort.BubbleSort(a);
		QuickSort.InsertSort(a);
		QuickSort.SelectSort(a);*/
		System.out.println("quickSort:");
		QuickSort.quickSort(a,0,a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
