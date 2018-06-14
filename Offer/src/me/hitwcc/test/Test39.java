package me.hitwcc.test;
/**
 * 
 * Title:面试题39
 * Description:数组中出现次数超过一半的数字
 * @author: wcc
 * @created: 2018年6月14日下午2:32:37
 */
public class Test39 {

	public Test39() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:采用Partition的思想 该数字肯定是位于中间的数字 采用O(n)复杂度求第k大元素
	 * @author: wcc
	 * @created: 下午2:38:29
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<=0)
        	return 0;
        int start = 0;
        int end = array.length-1;
        int middle = array.length>>1;
        int index = Partition(array,start,end);
        while(index!=middle){
        	if(index>middle){
        		index = Partition(array,start,index-1);
        	}
        	else{
        		index = Partition(array,index+1,end);
        	}
        }
        int result = array[middle];
        int times = 0;
        for(int i=0;i<array.length;i++){
        	if(array[i]==result)
        		times++;
        }
        if(times*2<=array.length)
        	return 0;
        return result;
        
    }
	private int Partition(int[] target, int left, int right) {
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

}
