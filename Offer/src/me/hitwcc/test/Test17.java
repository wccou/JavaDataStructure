package me.hitwcc.test;
/**
 * 
 * Title:面试题17 打印1到最大的n位数
 * Description:
 * @author: wcc
 * @created: 2018年5月24日下午9:26:26
 */
public class Test17 {

	public Test17() {
		// TODO Auto-generated constructor stub
	}
	public void print1ToMaxOfNDigits(int n){
		if(n<=0)
			return;
       char[] number=new char[n];
       for(int i=0;i<n;i++){
    	   number[i]='0';
       }
       while(!addOne(number)){
    	   printNumber(number);
       }


    }
    
	public boolean addOne(char[] number) {
		for(int i=number.length-1;i>=0;i--){
			if((number[i]-'0'+1)>=10){
				number[i]='0';
				if(0==i){	
					return true;
				}
			}
			else{
				number[i]=(char)((number[i]-'0'+1)+'0');
				break;
			}
		}
		return false;
	}
	
	public void printNumber(char[] number) {
		boolean flag=true;
		for(int i=0;i<number.length;i++){
			if(number[i]!='0'&&flag)
				flag=false;
			if(!flag)
				System.out.print(number[i]);
		}
		System.out.println();
	}
	
	
	public void print1ToMaxOfNDigits2(int n) {
		char[] number=new char[n];
		for(int i=0;i<n;i++){
			number[i]='0';
		}
		print1ToMaxOfN2(number,0);
	}
	
	public void print1ToMaxOfN2(char[] number,int index) {
		if(index==number.length){
			printNumber(number);
			return;
		}
		for(int i=0;i<10;i++){
			number[index]=(char)(i+'0');
			print1ToMaxOfN2(number,index+1);
		}
		
	}
	
	
    public static void main(String[] args) {
    	Test17 test=new Test17();
    	test.print1ToMaxOfNDigits2(3);
	}
}
