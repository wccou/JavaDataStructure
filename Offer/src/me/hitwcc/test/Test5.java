package me.hitwcc.test;

import java.awt.List;
import java.util.ArrayList;

/**
 * 
 * Title:面试题5
 * Description:替换字符串中每个空格为“%20”
 * @author: wcc
 * @created: 2018年5月10日上午10:24:53
 */
public class Test5 {

	public Test5() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:
	 * @author: wcc
	 * @created: 下午9:56:06
	 * @param string 待处理字符串
	 * @param length 输入的字符串所能承受的最大长度
	 * @return
	 */
	public static char[] ReplaceBlank(char[] string,int length){
		int originLength=0;
		int numberOfBlank=0;
		int i=0;
		while(string[i]!='\0'){
			originLength++;
			if(string[i]==' ')
				numberOfBlank++;
			i++;
		}
		
		int newLength=originLength+numberOfBlank*2;
		int indexOfOrigin=originLength;
		int indexOfNew=newLength;
		while(indexOfOrigin>=0&&indexOfNew>=indexOfOrigin){
			if(string[indexOfOrigin]==' '){
				string[indexOfNew--]='0';
				string[indexOfNew--]='2';
				string[indexOfNew--]='%';
			}else{
				string[indexOfNew--]=string[indexOfOrigin];
			}
			indexOfOrigin--;
		}
		
		return string;
	}
	
	public static String ReplaceBlank1(String input) {
		if(input==null)
			return null;
		StringBuffer outputBuffer=new StringBuffer();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==' '){
				outputBuffer.append("%20");
			}else{
				outputBuffer.append(input.charAt(i));
			}
		}
		return new String(outputBuffer);
	}
	
	public static void main(String[] args) {
		//char[] string={'w',' ','r',' ','h','!','\0','0','0','0','0','0','0','0','0','0'};
		String string="we are happy!";
		
		string =ReplaceBlank1(string);
		System.out.println(string);
	}

}
