package me.hitwcc.test;
/**
 * 
 * Title:面试题56
 * Description:数组中数字出现的次数相关题目
 * @author: wcc
 * @created: 2018年6月27日上午9:40:50
 */
public class Test56 {

	public Test56() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:数组中只出现一次的两个数字
	 * @author: wcc
	 * @created: 上午10:14:12
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length <2)
        	return;
        int temp=0;
        for(int i=0;i<array.length;i++){
        	temp=temp^array[i];
        }
        int index=findFirst1(temp);
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
        	if(isBit1(array[i],index)){
        		num1[0]^=array[i];
        	}else{
        		num2[0]^=array[i];
        	}
        }
    }
	private boolean isBit1(int i, int index) {
		boolean flag=((i>>index)&1)==1;
		return flag;
	}
	private int findFirst1(int temp) {
		int index=0;
		while(((temp&1)==0)&&index<32){
			temp=temp>>1;
			index++;
		}
		return index;
	}
	/**
	 * 
	 * @description:在一个数组中除了一个数字只出现一次外，
	 * 				其他数字都出现了三次 找出只出现一次的那个数字
	 * @author: wcc
	 * @created: 上午10:20:21
	 * @param array
	 * @return
	 */
	public int FindNumsAppearOnce(int[] array){
		if(array==null||array.length<=0)
			return -1;
		int[] bitTime=new int[32];
		/*for(int i=0;i<array.length;i++){
			bitTime[i]=0;
		}*/
		int result=0;
		for(int i=0;i<32;i++){
			for(int j=0;j<array.length;j++){
				bitTime[i] +=(array[j]>>i)&1;
			}
			result |=(bitTime[i]%3)<<i;
		}
		return result;
	}
	public static void main(String[] args) {
		Test56 test=new Test56();
		int[] a=new int[]{1,1,1,5,3,3,3,4,4,4};
		int result=test.FindNumsAppearOnce(a);
		System.out.println(result);
	}
	
}
