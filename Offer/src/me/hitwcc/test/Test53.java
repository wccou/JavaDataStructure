package me.hitwcc.test;
/**
 * 
 * Title:面试题53
 * Description:在排序数组中查找数字
 * @author: wcc
 * @created: 2018年6月23日下午9:25:47
 */
public class Test53 {

	public Test53() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:数字在排序数组中出现的次数
	 * @author: wcc
	 * @created: 下午7:37:36
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int[] array,int k) {
		if(array==null||array.length ==0)
			return 0;
		int length=array.length-1;
		int firstK=getFirstK(array,k,0,length);
		int lastK=getLastK(array,k,0,length);
		if(firstK!=-1&&lastK!=-1)
			return lastK-firstK+1;
		return 0;
	}
	private int getFirstK(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		while(start<=end){
			if(array[mid]>k){
				end=mid-1;
			}else if(array[mid]<k){
				start=mid+1;
			}else if(mid-1>=0&&array[mid-1]==k){
				end=mid-1;
			}else{
				return mid;
			}
			mid=(start+end)/2;
		}
		return -1;
	}
	private int getLastK(int[] array, int k, int start, int end) {

		int mid=(start+end)/2;
		while(start<=end){
			if(array[mid]>k){
				
				end=mid-1;
			}else if(array[mid]<k){
				start=mid+1;
			}else if(mid+1<=array.length-1&&array[mid+1]==k){
				start=mid+1;
			}else{
				return mid;
			}
			mid=(start+end)/2;
		}
		return -1;
	}
	/**
	 * 
	 * @description:0~n-1中缺失的数字 长度为n-1的递增排序数组中的所有数字都是唯一的，都在0~n-1范围内，找出
	 * 缺失的那个   求和法
	 * @author: wcc
	 * @created: 下午9:45:54
	 * @param number
	 * @return
	 */
	public int findMissingNumber1(int[] number){
		int length=number.length;
		int sum=(1+length)*length/2;
		int sum1=0;
		for(int i=0;i<length;i++){
			sum1+=number[i];
		}
		return sum-sum1;
	}
	/**
	 * 
	 * @description:有序数组都要考虑二分查找法
	 * @author: wcc
	 * @created: 下午9:47:57
	 * @param number
	 * @return
	 */
	public int findMissingNumber2(int[] number){
		int length=number.length;
		int left=0;
		int right=length-1;
		while(left<=right){
			int mid=(right+left)>>1;
			if(number[mid]==mid){
				left=mid+1;
			}else if(number[mid-1]==mid-1||mid==0){
				return mid;
			}else{
				right=mid-1;
			}
		}
		if(left==length)
			return length;
		//System.out.println(left);
		return -1;
	}
	/**
	 * 
	 * @description:单调递增数组中数值和下标相等的元素
	 * @author: wcc
	 * @created: 下午9:52:23
	 * @param number
	 * @return
	 */
	public int getNumberSameAsIndex(int[] number){
		if(number==null||number.length<=0)
			return -1;
		int length=number.length;
		int left=0;
		int right=length-1;
		while(left<=right){
			int mid=(left+right)>>1;
			if(number[mid]==mid){
				return mid;
			}else if(number[mid]<mid){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Test53 test=new Test53();
		int[] a=new int[]{3,3,3,3,4,4};
		int[] b=new int[]{0,1,2,3,4,5};
		int[] c=new int[]{-3,-1,1,3,5};
		int s=test.GetNumberOfK(a, 4);
		int d=test.findMissingNumber2(b);
		int f=test.getNumberSameAsIndex(c);
		System.out.println(f);
	}
}
