package me.hitwcc.test;

/**
 * 
 * Title:面试题3
 * Description:数组中重复的数字 数组长度为n 所有元素都在0到n-1范围
 * @author: wcc
 * @created: 2018年5月10日上午9:33:07
 */
public class Test3 {

	public Test3() {
		// TODO Auto-generated constructor stub
	}
	public static int duplicate(int[] numbers,int length){
		if(length<=0)
			return -1;
		for(int i=0;i<length;i++){
			if(numbers[i]<0||numbers[i]>length-1)
				return -1;
		}
		
		for(int i=0;i<length;i++){
			while(numbers[i]!=i){
				if(numbers[i]==numbers[numbers[i]]){
					return numbers[i];
				}
				else{
					int temp = numbers[numbers[i]];
					numbers[numbers[i]]=numbers[i];
					numbers[i]= temp;
					
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] a={3,6,1,0,2,5,3};
		int result= duplicate(a,a.length);
		System.out.println(result);
		
	}

}
