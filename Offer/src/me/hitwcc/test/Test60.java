package me.hitwcc.test;
/**
 * 
 * Title:面试题60
 * Description:n个骰子的点数
 * @author: wcc
 * @created: 2018年6月27日下午3:59:11
 */
public class Test60 {

	public Test60() {
		// TODO Auto-generated constructor stub
	}
	public String[] printProbability(int n){
		if(n<=0)
			return null;
		int total=(int) Math.pow(6, n);
		String[] result=new String[6*n-n+1];
		
		int[][] dp=new int[n+1][6*n+1];
		for(int i=1;i<=6;i++){
			dp[1][i]=1;
		}
		for(int i=2;i<=n;i++){
			for(int j=i;j<=6*n;j++){
				dp[i][j]=0;
				for(int m=1;m<j&&m<=6;m++){
					dp[i][j]+=dp[i-1][j-m];
				}
			}
		}
		for(int k=n;k<=6*n;k++){
			result[k-n]=dp[n][k]+"/"+total;
		}
		return result;
	}
	public static void main(String[] args) {
		String[] result = new Test60().printProbability(3);
        System.out.println(result.length);
        for (String val : result)
            System.out.print(val + ",");
	}
}
