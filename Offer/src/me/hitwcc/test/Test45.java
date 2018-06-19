package me.hitwcc.test;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * Title:面试题45 那数组排成最小的数
 * Description:
 * @author: wcc
 * @created: 2018年6月19日下午8:16:05
 */
public class Test45 {

	public Test45() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:自己新建一个比较器用来比较 比较规则如下： 若ab > ba 则 a > b，
	 *                                          若ab < ba 则 a < b，
	 *                                          若ab = ba 则 a = b；
	 * @author: wcc
	 * @created: 下午8:25:16
	 * @param numbers
	 * @return
	 */
	public String PrintMinNumber(int [] numbers) {
		if(numbers==null||numbers.length==0)
			return "";
		int length = numbers.length;
		String[] str = new String[length];
		for(int i=0;i<length;i++){
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new MyComparator());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length;i++){
			sb.append(str[i]);
		}
		return sb.toString();
    }

}

class MyComparator implements Comparator<String>{

	public int compare(String o1,String o2){
		String s1=o1+o2;
		String s2=o2+o1;
		return s1.compareTo(s2);
	}
	
}