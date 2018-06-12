package me.hitwcc.test;
/**
 * 
 * Title:面试题15 二进制数中1的个数
 * Description:
 * @author: wcc
 * @created: 2018年5月24日下午7:27:32
 */
public class Test15 {

	public Test15() {
		// TODO Auto-generated constructor stub
	}
	
	public int count1(int number) {
		int flag=1;
		int count=0;
		while(flag!=0)
		{
			if((flag&number)!=0)
				count++;
			flag=flag<<1;
		}
		return count;
	}
	
	/**
	 * 
	 * @description:最优算法
	 * @author: wcc
	 * @created: 下午7:45:03
	 * @param number
	 * @return
	 */
	public int count(int number) {
		int count=0;
		while(number!=0){
			number=(number-1)&number;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Test15 test=new Test15();
		int n=test.count1(-5);
		System.out.println(n);
	}
}
