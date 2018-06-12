package me.hitwcc.test;
/**
 * 
 * Title:面试题10 斐波那契数列
 * Description:体会通常情况下，递归的效率比循环要低很多
 * @author: wcc
 * @created: 2018年5月18日下午2:21:49
 */
public class Test10 {

	public Test10() {
		// TODO Auto-generated constructor stub
	}
	public static long Fibonacci(int n) {
		long[] result;
		result=new long[n];
		result[0]=0;
		result[1]=1;
		if(n<=2)
			return result[n-1];
		for(int i=2;i<n;i++)
			result[i]=result[i-1]+result[i-2];
		
		return result[n-1];
	}
	
	public static long Fibonacci1(int n) {
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	public static void main(String[] args) {
		System.out.println(Fibonacci(1000));
		System.out.println("*****************");
		System.out.println(Fibonacci1(100));
	}
}
