package me.hitwcc.test;
/**
 * 
 * Title:，面试题47
 * Description:礼物的最大价值
 * @author: wcc
 * @created: 2018年6月20日下午3:40:11
 */
public class Test47 {

	public Test47() {
		// TODO Auto-generated constructor stub
	}
	public static int getMost(int[][] board) {
		if(board==null||board.length==0)
			return 0;
		int row=board.length;
		int column=board[0].length;
		int[][] dp=new int[row][column];
		dp[0][0]=board[0][0];
		for(int i=1;i<row;i++){
			dp[i][0]=dp[i-1][0]+board[i][0];
		}
		for(int i=1;i<column;i++){
			dp[0][i]=dp[0][i-1]+board[0][i];
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<column;j++){
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1])+board[i][j];
			}
		}
		return dp[row-1][column-1];
    }
	
	public static void main(String[] args) {
		int[][] board=new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		int result = getMost(board);
		System.out.println(result);
	}
}
