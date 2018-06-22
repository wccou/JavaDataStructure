package me.hitwcc.test;

import java.util.HashMap;

/**
 * 
 * Title:面试题50 
 * Description:第一个只出现一次的字符
 * @author: wcc
 * @created: 2018年6月22日下午4:49:22
 */
public class Test50 {

	public Test50() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:比较简单，用一个哈希表来存储字符出现的次数，这一题可以简化为一个数组来存
	 * @author: wcc
	 * @created: 下午5:03:15
	 * @param str
	 * @return
	 */
	public int FirstNotRepeatingChar(String str) {
		if(str==null||str.length()==0)
			return -1;
		int[] num=new int[256];
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			num[ch]++;
		}
		for(int i=0;i<str.length();i++){
			if(num[str.charAt(i)]==1){
				return i;
			}
		}
        return -1;
    }
	/**
	 * 
	 * @description:使用hashmap做
	 * @author: wcc
	 * @created: 下午5:05:59
	 * @param str
	 * @return
	 */
	public int FirstNotRepeatingChar1(String str) {
		if(str==null||str.length()==0)
			return -1;
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(map.containsKey(ch)){
				int time=map.get(ch);
				time++;
				map.put(ch, time);
			}else{
				map.put(ch, 1);
			}
		}
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(map.get(ch)==1){
				return i;
			}
		}
        return -1;
    }
}
