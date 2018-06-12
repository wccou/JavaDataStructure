package me.hitwcc.test;
/**
 * 
 * Title:面试题13 机器人的运动范围行列坐标数位之和不能大于k
 * Description:
 * @author: wcc
 * @created: 2018年5月20日上午9:57:28
 */
public class Test13 {

	public Test13() {
		// TODO Auto-generated constructor stub
	}
	public static int MovingCount(int k,int rows,int cols) {
		if(k<0||rows<=0||cols<=0)
			return 0;
		boolean[] visited=new boolean[rows*cols];
		int count=0;
		count=CountCore(k,rows,cols,0,0,visited);
		return count;
	}
	
	public static int CountCore(int k,int rows,int cols,
			int row,int col,boolean[] visited) {
		int count=0;
		if(row>=0&&row<rows&&col>=0&&col<cols&&GetSum(row)+GetSum(col)<=k&&visited[row*cols+col]==false){
			visited[row*cols+col]=true;
			count=1+CountCore(k,rows,cols,row-1,col,visited)+CountCore(k,rows,cols,row+1,col,visited)
				   +CountCore(k,rows,cols,row,col-1,visited)+CountCore(k,rows,cols,row,col+1,visited);
		}
		return count;
	}
	
	public static int GetSum(int number) {
		int sum=0;
		while(number>0){
			sum=sum+number%10;
			number=number/10;
		}
		return sum;
		
	}
	

}
