package me.hitwcc.test;
/**
 * 
 * Title:面试题48
 * Description:最长不含重复字符的子字符串的长度  假设字符只包括a-z
 * @author: wcc
 * @created: 2018年6月21日下午3:06:24
 */
public class Test48 {
/**
 * 
 * @description:动态规划的思想：dp[i]表示以第i个字符为结尾的不包含重复字符的最长子字符串的长度
 * 				1）若当前字符第一次出现，则最长非重复子字符串长度f(i) = f(i-1)+1。 
 * 				2）若当前字符不是第一次出现，则首先计算当前字符与它上次出现位置之间的距离d。若d大于f(i-1)，即说明前一个非重复子字符串中没有包含当前字符，则可以添加当前字符到前一个非重复子字符串中，所以，f(i) = f(i-1)+1。若d小于或等于f(i-1)，即说明前一个非重复子字符串中已经包含当前字符，则不可以添加当前字符，所以，f(i) = d。
 * @author: wcc
 * @created: 下午3:57:12
 * @param string
 * @return
 */
	private static int findLongestSubstringLength(String string){
		if(string==null||string.length()==0)
			return 0;
		int[] dp=new int[string.length()];
		for(int i=1;i<string.length();i++){
			dp[i]=0;
		}
		int[] position=new int[26];
		for(int i=0;i<26;i++){
			position[i]=-1;//初始化为-1 代表没出现过
		}
		dp[0]=1;     //很关键 初始化dp[0]=1 因为显然dp[0]=1
		position[string.charAt(0)-'a']=0;//同时更新该字符上次出现的位置
		for(int i=1;i<string.length();i++){
			int temp=string.charAt(i)-'a';
			int prePosition=position[temp];
			int distance=i-prePosition;
			//System.out.println("上："+prePosition);
			if(prePosition<0||distance>dp[i-1]){
				dp[i]=dp[i-1]+1;
				//System.out.println(dp[i]);
			}else{
				dp[i]=distance;
				//System.out.println(dp[i]);
			}
			position[temp]=i;
		}
		int max=dp[0];
		for(int i=0;i<string.length();i++){
			
			if(dp[i]>max){
				max=dp[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(findLongestSubstringLength("arabcacfr")); //4
		System.out.println(findLongestSubstringLength("bbb")); //1
        System.out.println(findLongestSubstringLength("")); //0
	}
}
