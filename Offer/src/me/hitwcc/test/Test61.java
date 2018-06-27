package me.hitwcc.test;

import java.util.Arrays;

/**
 * 
 * Title:扑克牌中的顺子
 * Description:从扑克牌中随机抽出5张 判断是否是连续的 大小王可看做任意
 * @author: wcc
 * @created: 2018年6月27日下午4:41:21
 */
public class Test61 {

	public Test61() {
		// TODO Auto-generated constructor stub
	}
    public boolean isContinuous(int [] numbers) {
    	if(numbers==null||numbers.length<5)
    		return false;
    	int numberOfZero=0;
    	int numberOfGap=0;
    	Arrays.sort(numbers);
    	for(int i=0;i<numbers.length;i++){
    		if(numbers[i]==0)
    			numberOfZero++;
    	}
    	for(int i=0;i<numbers.length-1;i++){
    		if(numbers[i]!=0&&numbers[i]==numbers[i+1])
    			return false;
    		if(numbers[i]!=0)
    			numberOfGap+=numbers[i+1]-numbers[i]-1;
    	}
    	if(numberOfZero>=numberOfGap)
    		return true;
    	return false;
    }
    public static void main(String[] args) {
		Test61 test=new Test61();
		int[] a=new int[]{0,2,3,4,6};
		System.out.println(test.isContinuous(a));
	}
}
