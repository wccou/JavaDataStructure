package me.hitwcc.test;
/**
 * 
 * Title:面试题20 表示数值的字符串
 * Description:
 * @author: wcc
 * @created: 2018年5月30日上午9:41:03
 */
public class Test20 {

	public Test20() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isNumeric(char[] str){
		if(str==null||str.length==0)
			return false;
		int index=0;
		if(str[index]=='+'||str[index]=='-')
			index++;
		if(index>=str.length)
			return false;
		while(index<str.length){//跳过符号位后的数字
			if(isNum(str[index]))
				index++;
			else{
				break;
			}
		}
		//此时的index不是数字 该判断index是不是小数点
		if(index<str.length){
			if(str[index]=='.'){
				index++;
				if(index>=str.length) return true;
				if(str[index]=='e'||str[index]=='E')
					return false;//小数点后紧跟字母eE返回false
				if(!isNum(str[index]))
					return false;
				while(index<str.length){
					if(!isNum(str[index])){
						break;
					}
					index++;
				}
				if(index>=str.length)
					return true;
				else if(str[index]=='e'||str[index]=='E')
					return isExpon(str,index);
				else return false;
			}else if(str[index]=='e'||str[index]=='E'){
				return isExpon(str,index);
			}else{
				return false;
			}
		}
		return true;
	}
	
	public boolean isNum(char ch){
		if(ch>='0'&&ch<='9'){
			return true;
		}
		return false;
	}
	
	public boolean isExpon(char[] str,int index){
		if(str[index]!='e'&&str[index]!='E'){
			return false;
		}
		index++;
		if(index>=str.length)
			return false;
		if(str[index]=='+'||str[index]=='-'){
			index++;
		}
		if(index>=str.length) return false;
		while(index<str.length){
			if(!isNum(str[index])){
				break;
			}
			index++;
		}
		return index==str.length?true:false;
		
	}

}
