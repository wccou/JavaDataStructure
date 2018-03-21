package me.hitwcc.sort;

import java.util.Arrays;

public class RadixSort {

	public static int[] radixSort(int[] target, int r, int d) {
		int n = target.length;
		if (n == 0){
			System.out.println("it is a null array!");
		}else if(n == 1){
			System.out.println(Arrays.toString(target));
		}else{
			int[][] bucket = new int[r][n];//r个桶子（正常是0-9总共10个桶子），每个桶子里最多放n各元素,n为待排序数组的长度
			int number = 0; //获取对应位上的数字
			int divisor = 1; //每一轮的除数
			int[] count = new int[r];
			for (int i = 0; i < d; i ++){  
				//第i次分配
				for (int j = 0; j < n; j ++){
					number = (target[j]/divisor) % 10;
					bucket[number][count[number]] = target[j];
					count[number] = count[number] + 1;
				}
				//第i次回收
				int index = 0;
				for (int j = 0; j < r; j ++){
					for (int k = 0; k < count[j]; k ++){  //按照先进先出的顺序将桶子里的元素串起来并取出来
						target[index] = bucket[j][k];
						index ++;
					} 
					count[j] = 0;//!!!!!!!!很关键的一步 每一轮回收之后将计数归零
				}
				
				divisor = divisor*10;  //每一轮将除数乘以10
			}
		}
		return target;
	}
	public static int[] radixSort(int[] target, int r, int d, int n){
		if (target != null && target.length != 1 ) {
			int[][] bucket = new int[r][n];  // 一共有基数r个桶，每个桶最多放n个元素
			int digit;  // 获取元素对应位上的数字，即装入那个桶
			int divisor = 1;   // 定义每一轮的除数，1, 10, 100, ...
			int[] count = new int[r];   // 统计每个桶中实际存放元素的个数	
			for (int i = 0; i < d; i++) {  // d 位的元素，需要经过分配、收集d次即可完成排序		
				// 分配
				for (int ele : target) {   
					digit = (ele/divisor) % 10;  // 获取元素对应位上的数字(巧妙！！！)
					bucket[digit][count[digit]++] = ele; // 将元素放入对应桶，桶中元素数目加1
				}
				
				// 收集
				int index = 0;  // 目标数组的下标
				for (int j = 0; j < r; j++) {
					int k = 0;    // 用于按照先进先出顺序获取桶中元素
					while(k < count[j]){
						target[index++] = bucket[j][k++];  // 按照先进先出依次取出桶中的元素
					}
					count[j] = 0;  // 计数器归零
				}
				divisor *= 10;  	//用于获取元素对应位数字
			}
		}
		return target;
	}
	
	public static void main(String[] args){
		int[] a = {625, 725, 42, 8, 22, 1};
		RadixSort.radixSort(a, 10, 3);
		System.out.println(Arrays.toString(a));
	}

}
