package me.hitwcc.test;
/**
 * 
 * Title:面试题44 数字序列中某一位的数字
 * Description:
 * @author: wcc
 * @created: 2018年6月16日下午2:55:10
 */
public class Test44 {

	/**
	 * 
	 * @description:代码写的较乱 
	 * @author: wcc
	 * @created: 下午7:43:25
	 * @param index
	 * @return int
	 */
	public int digitalAtIndex(int index) {
		index++;
		if(index<0)
			return -1;
		int s=10;
		int j=0;
		for(int i=1;;i++){
		    if(index>s){
		    	s=(int) (s+9*Math.pow(10,i)*(i+1));
		    	
		    }else{
		    	j=i;
		    	break;
		    }
		}

		int sum=(int) (s-9*Math.pow(10,j-1)*j);
		sum=index-sum;

		int indexOfJBit=sum/j;
		int actualIndexInJBit=sum%j;

		int number=0;
		if(actualIndexInJBit!=0){
			number=(int) (Math.pow(10,j-1)+indexOfJBit);
		}else{
			number=(int) (Math.pow(10,j-1)+indexOfJBit-1);
		}
		
		char[] result= Integer.toString(number).toCharArray();
		if(actualIndexInJBit==0){
			System.out.println(result[result.length-1]);
			return Integer.parseInt(String.valueOf(result[result.length-1]));
		}
		else{
			System.out.println(result[actualIndexInJBit-1]);
			return Integer.parseInt(String.valueOf(result[actualIndexInJBit-1]));
		
		}
	}
	public static void main(String[] args) {
		Test44 test=new Test44();
		int ee= test.digitalAtIndex(1001);
		System.out.println(ee);
	}

}
