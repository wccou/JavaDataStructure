package me.hitwcc.test;
/**
 * 
 * Title:面试题11 旋转数组的最小数字
 * Description:
 * @author: wcc
 * @created: 2018年5月19日下午5:20:35
 */
public class Test11 {

	public Test11() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:采用二分查找的思想 
	 * @author: wcc
	 * @created: 下午5:35:49
	 * @param numbers
	 * @return
	 */
	public static int Min(int[] numbers) {
		int length=numbers.length;
		if(length==1)
			return numbers[0];
		int indexMin=0;
		int index1=0;
		int index2=length-1;
		while(numbers[index1]>=numbers[index2]){
			if((index2-index1)==1){
				indexMin=index2;
				break;
			}
			int indexMid=(index1+index2)/2;
			if(numbers[indexMid]>=numbers[index1])
				index1=indexMid;
			else if(numbers[indexMid]<=numbers[index2])
				index2=indexMid;
				
		}
		
		return numbers[indexMin];
	}
	public static void main(String[] args) {
		int[] a={1,1,1,0,1};
		System.out.println(Min(a));

		
	}

}
