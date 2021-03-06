package me.hitwcc.test;
/**
 * 
 * Title:面试题42 连续子数组的最大和
 * Description:
 * @author: wcc
 * @created: 2018年6月15日上午10:34:45
 */
public class Test42 {

	public Test42() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:非动态规划方法
	 * @author: wcc
	 * @created: 上午10:40:14
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null)
        	return 0;
        int currentSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
        	if(currentSum<=0){
        		currentSum = array[i];
        	}else{
        		currentSum = currentSum + array[i];
        	}
        	if(currentSum>greatestSum)
        		greatestSum = currentSum;
        }
        return greatestSum;
    }
	/**
	 * 
	 * @description:动态规划算法   
	 *   F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
	 *   F（i）=max（F（i-1）+array[i] ， array[i]）
	 * @author: wcc
	 * @created: 上午10:47:41
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray1(int[] array) {
        if(array==null)
        	return 0;
		int[] dp = new int[array.length];
		dp[0]=array[0];
		int greatSum=dp[0];
		for(int i=1;i<array.length;i++){
			dp[i]=(dp[i-1]+array[i])>array[i]?(dp[i-1]+array[i]):array[i];
			if(greatSum<dp[i]){
				greatSum=dp[i];
			}
		}
        return greatSum;
    }
	
	
}
