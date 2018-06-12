package me.hitwcc.test;
/**
 * 
 * Title:面试题19
 * Description:正则表达式匹配问题
 * @author: wcc
 * @created: 2018年5月26日下午5:36:30
 */
public class Test19 {

	public Test19() {
		// TODO Auto-generated constructor stub
	}
	public boolean match(char[] str,char[] pattern) {
		if(str==null||pattern==null)
			return false;
		
		return matchCore(str,0,pattern,0);
	}
	
	public boolean matchCore(char[] str,int strIndex,
			char[] pattern,int patternIndex) {
		if(strIndex==str.length&&patternIndex==pattern.length)
			return true;
		if(strIndex!=str.length&&patternIndex==pattern.length)
			return false;
		if(patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
			if((strIndex!=str.length&&str[strIndex]==pattern[patternIndex])||(pattern[patternIndex]=='.'&&strIndex!=str.length)){
				return matchCore(str, strIndex, pattern, patternIndex+2)
						||matchCore(str, strIndex+1, pattern, patternIndex+2)
						||matchCore(str, strIndex+1, pattern, patternIndex);
			}else{
				return matchCore(str, strIndex, pattern, patternIndex+2);
			}
		}
		
		if(strIndex!=str.length&&(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.')){
			return matchCore(str, strIndex+1, pattern, patternIndex+1);
		}else{
			return false;
		}
		

	}
	
	public static void main(String[] args) {
		Test19 test=new Test19();
		char[] str={};
		char[] pattern={'.','*'};
		System.out.println(test.match(str,pattern));
		
	}

}
