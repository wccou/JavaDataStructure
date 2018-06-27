package me.hitwcc.test;
/**
 * 
 * Title:面试题56
 * Description:数组中数字出现的次数相关题目
 * @author: wcc
 * @created: 2018年6月27日上午9:40:50
 */
public class Test56 {

	public Test56() {
		// TODO Auto-generated constructor stub
	}
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length <2)
        	return;
        int temp=0;
        for(int i=0;i<array.length;i++){
        	temp=temp^array[i];
        }
        int index=findFirst1(temp);
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
        	if(isBit1(array[i],index)){
        		num1[0]^=array[i];
        	}else{
        		num2[0]^=array[i];
        	}
        }
    }
	private boolean isBit1(int i, int index) {
		boolean flag=((i>>index)&1)==1;
		return flag;
	}
	private int findFirst1(int temp) {
		int index=0;
		while(((temp&1)==0)&&index<32){
			temp=temp>>1;
			index++;
		}
		return index;
	}
}
