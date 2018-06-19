package me.hitwcc.test;
/**
 * 
 * Title:面试题46
 * Description:面试题46：把数字翻译成字符串
 * @author: wcc
 * @created: 2018年6月19日下午9:11:03
 */
public class Test46 {

	public Test46() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:采用动规的方法 由底向上计算：f(r)表示以r为开始（r最小取0）到最右端
	 * 所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。
	 * 递推公式为 f(i) = f(i+1)+g(i,i+1)*f(i+2)；当第i位和第i+1位的两位数字拼接一起在10-25
	 * 范围内时，函数g(i,i+1)的值为1，否则为0
	 * @author: wcc
	 * @created: 下午9:11:37
	 * @param number
	 * @return
	 */
	public static int NumberToString(int number) {
		if(number<0)
			return 0;
		return NumberToString(Integer.toString(number));
	}
	private static int NumberToString(String string) {
		int length = string.length();
		int[] count=new int[length+1];
		count[length-1]=1;
		count[length]=1;
		for(int i=length-2;i>=0;i--){
			int result=(string.charAt(i)-'0')*10+(string.charAt(i+1)-'0');
			System.out.println(result);
			if(result>=10&&result<=25){
				count[i]=count[i+1]+count[i+2];
			}else{
				count[i]=count[i+1];
			}
		}
		return count[0];
	}
	public static void main(String[] args) {
		int result = NumberToString(12258);
		System.out.println(result);
	}

}
