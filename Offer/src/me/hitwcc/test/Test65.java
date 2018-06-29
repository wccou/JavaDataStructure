package me.hitwcc.test;

public class Test65 {

	public Test65() {
		// TODO Auto-generated constructor stub
	}
	public int sum(int a,int b){
		int sum=0;
		int carry=-1;
		while(carry!=0){
			sum=a^b;
			carry=(a&b)<<1;
			a=sum;
			b=carry;
		};
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(new Test65().sum(7, 8));
	}
}
