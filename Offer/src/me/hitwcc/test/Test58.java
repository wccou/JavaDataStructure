package me.hitwcc.test;
/**
 * 
 * Title:面试题58 翻转单词顺序
 * Description:
 * @author: wcc
 * @created: 2018年6月27日下午2:07:22
 */
public class Test58 {

	public Test58() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:翻转句子中的顺序，但单词内字符的顺序不变，
	 * 				句子中单词以空格隔开，为简单起见。标点符号
	 * 				和普通字母一样处理，例如输入”i am a student”.
	 * 				则输出”student a am I”.
	 * @author: wcc
	 * @created: 下午2:26:08
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
        if(str==null)
        	return null;
        if(str.trim().equals(""))
        	return str;
        String[] temp=str.split(" ");
        StringBuffer result=new StringBuffer();
        for(int i=temp.length-1;i>=0;i--){
        	result.append(temp[i]);
        	if(i>0){
        		result.append(" ");
        	}
        }
        return result.toString();
    }
	/**
	 * 
	 * @description:不使用自带函数  先整体翻转 再对每个单词翻转
	 * @author: wcc
	 * @created: 下午2:52:24
	 * @param str
	 * @return
	 */
	public String ReverseSentence1(String str){
		if(str==null)
			return null;
		char[] chars=str.toCharArray();
		System.out.println(chars);
		int length=chars.length;
		reverse(chars,0,length-1);
		System.out.println(chars);
		int start=0;
		for(int i=0;i<length;i++){
			if(chars[i]==' '){
				reverse(chars,start,i-1);
				start=i+1;
			}
		}
		reverse(chars,start,length-1);
		return new String(chars);
	}
	private void reverse(char[] chars, int i, int j) {
		while(i<j){
			char temp=chars[j];
			chars[j]=chars[i];
			chars[i]=temp;
			i++;
			j--;
		}
		
	}
	/**
	 * 
	 * @description:左旋转字符串
	 * @author: wcc
	 * @created: 下午3:14:21
	 * @param str
	 * @param n
	 * @return
	 */
    public String LeftRotateString(String str,int n) {
        if(str==null)
        	return null;
        if(n>str.length())
            return "";
        StringBuffer sb=new StringBuffer(str.substring(0, n));
        StringBuffer sb1=new StringBuffer(str.substring(n));
        sb1.append(sb);
        return sb1.toString();
    }
	
	public static void main(String[] args) {
		Test58 test=new Test58();
		String str=new String("I am a student.");
		String a=test.ReverseSentence1(str);
		System.out.println(a);
	}
}
