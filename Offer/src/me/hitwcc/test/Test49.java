package me.hitwcc.test;
/**
 * 
 * Title:面试题49 
 * Description:丑数 只包含因子2,3,5的数字      暴力法和巧妙的方法
 * @author: wcc
 * @created: 2018年6月21日下午4:07:24
 */
public class Test49 {

	public Test49() {
		// TODO Auto-generated constructor stub
	}
	public static int getUglyNumber(int index) {
		if(index<0)
			return 0;
		int[] uglyArray=new int[index];
		uglyArray[0]=1;
		int multiply2=0;
		int multiply3=0;
		int multiply5=0;
		for(int i=1;i<index;i++){
			int min=min(uglyArray[multiply2]*2,uglyArray[multiply3]*3,uglyArray[multiply5]*5);
			uglyArray[i]=min;
			if(uglyArray[multiply2]*2 == uglyArray[i])  
                multiply2++;  
            if(uglyArray[multiply3]*3 == uglyArray[i])  
                multiply3++;  
            if(uglyArray[multiply5]*5 == uglyArray[i])  
                multiply5++;  
		}
		return uglyArray[index-1];
	}
	private static int min(int i, int j, int k) {
		int min=i<j?i:j;// TODO Auto-generated method stub
		return min<k?min:k;
	}
	public static void main(String[] args) {
		System.out.println(getUglyNumber(4));
	}
}