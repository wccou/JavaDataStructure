package me.hitwcc.test;
/**
 * 
 * Title:面试题4
 * Description:二维数组中的查找 从左到右递增 从上到下递增
 * @author: wcc
 * @created: 2018年5月10日上午10:03:48
 */
public class Test4 {

	public Test4() {
		// TODO Auto-generated constructor stub
	}
	public static boolean Find(int[][] matrix,int row,int col,int number){
		if(row>0 && col>0){
			int r=0;
			int c=col-1;
			while(r<row && c>0){
				if(number==matrix[r][c]){
					return true;
				}
				else if(matrix[r][c]>number){
					c= c-1;
				}else{
					r=r+1;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] a={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		boolean result=Find(a,4,4,8);
		System.out.println(result);
	}

}
