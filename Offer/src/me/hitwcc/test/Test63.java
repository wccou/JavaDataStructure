package me.hitwcc.test;
/**
 * 
 * Title:面试题63 
 * Description:股票的最大利润
 * @author: wcc
 * @created: 2018年6月29日下午2:50:46
 */
public class Test63 {

	public Test63() {
		// TODO Auto-generated constructor stub
	}
	public int maxProfit(int[] prices){
		if(prices==null||prices.length<=1)
			return 0;
		int min=prices[0];
		int maxProfit=prices[1]-min;
		for(int i=2;i<prices.length;i++){
			if(prices[i-1]<min){
				min=prices[i-1];
			}
			int currentProfit=prices[i]-min;
			if(currentProfit>maxProfit)
				maxProfit=currentProfit;
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		int[] a=new int[]{9,11,8,5,7,12,16,14};
		System.out.println(new Test63().maxProfit(a));
	}
}
