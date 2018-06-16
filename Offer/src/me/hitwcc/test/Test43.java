package me.hitwcc.test;
/**
 * 
 * Title:面试题43 1-n整数中1出现的次数
 * Description:
 * @author: wcc
 * @created: 2018年6月16日下午1:53:33
 */
public class Test43 {

	/**
	 * 
	 * @description:使用stringbuilder构造一个长字符串
	 * @author: wcc
	 * @created: 下午2:54:16
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		StringBuilder str = new StringBuilder();
		int count = 0;
	    for(int i=1;i<=n;i++){
	    	str.append(i);
	    }
	    for(int j=0;j<str.length();j++){
	    	if(str.charAt(j)=='1'){
	    		count++;
	    	}
	    }
	    return count;
    }

}
