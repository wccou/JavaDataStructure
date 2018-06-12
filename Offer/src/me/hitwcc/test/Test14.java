package me.hitwcc.test;


public class Test14 {
	
	public static int maxProductAfterCutting(int length) {
		if(length<2)
			return 0;
		if(2==length)
			return 1;
		if(3==length)
			return 2;
		int[] result=new int[length+1];
		result[0]=0;
		result[1]=1;
		result[2]=2;
		result[3]=3;
		for(int i=4;i<=length;i++){
			int max=0;
			for(int j=1;j<=i/2;j++){
				int product=result[j]*result[i-j];
				if(product>max)
					max=product;
			}
			result[i]=max;
		}
		return result[length];
	}
    public static void main(String[] args) {
    	System.out.println(maxProductAfterCutting(7));
    }
}