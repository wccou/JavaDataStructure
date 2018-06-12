package me.hitwcc.test;
/**
 * 
 * Title:面试题16 数值的整数次方
 * Description:
 * @author: wcc
 * @created: 2018年5月24日下午8:33:40
 */
public class Test16 {

	public Test16() {
		// TODO Auto-generated constructor stub
	}
	public double power(double base,int exponent) {
		double result;
		if(equal(base,0.0)&&exponent<0)
			System.out.println("0的负数次幂没有意思！");
		if(exponent<0){
			result=1.0/powerWithUnsignedExponent(base,-exponent);
		}else{
			result=powerWithUnsignedExponent(base,exponent);
		}
		return result;
	}
	
	public double powerWithUnsignedExponent(double base,int exponent) {
		double result=1.0;
		int i=0;
		while(i<exponent){
			result=result*base;
			i++;
		}
			
		return result;
	}
	public boolean equal(double x,double y) {
		if((x-y)>-0.0000001&&(x-y)<0.0000001)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Test16 test=new Test16();
		double result=test.power(0, -3);
		System.out.println(result);
	}
}
