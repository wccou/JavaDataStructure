package me.hitwcc.test;
/**
 * 
 * Title:面试题12 矩阵中的路径 使用回溯法
 * Description:设计一个函数 判断一个矩阵中是否存在一条包含某字符串的路径
 *             路径可以从任一格开始，每一步均可以上下左右，但是不能再次进入相同格子
 * @author: wcc
 * @created: 2018年5月19日下午7:38:04
 */
public class Test12 {

	public Test12() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean HasPath(char[] matrix,int rows,int cols,char[] str) {
		if(matrix==null||rows<=0||cols<=0||matrix.length!=rows*cols||str==null)
			return false;
		int pathLength=0;
		boolean[] visited=new boolean[rows*cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(CorePath(matrix,rows,cols,str,i,j,pathLength,visited))
					return true;
			}
		}
		return false;
	}
	
	public static boolean CorePath(char[] matrix,int rows,int cols,char[]
			str,int row,int col,int pathLength,boolean[] visited) {
		boolean hasPath=false;
		if(pathLength==str.length)
			return true;
		if(row<rows&&row>=0&&col<cols&&col>=0&&matrix[row*cols+col]==str[pathLength]&&
				!visited[row*cols+col]){
			visited[row*cols+col]=true; 
			pathLength++;
			hasPath=CorePath(matrix, rows, cols, str, row-1, col, pathLength, visited)||
					CorePath(matrix, rows, cols, str, row+1, col, pathLength, visited)||
					CorePath(matrix, rows, cols, str, row, col-1, pathLength, visited)||
					CorePath(matrix, rows, cols, str, row, col+1, pathLength, visited);
			if(!hasPath){
				pathLength--;

				visited[row*cols+col]=false;
			}
		}
			
				
		
		return hasPath;
		
	}
	
	
	
	public static void main(String[] args) {  
        System.out.println(HasPath("ABCESFCSADEE".toCharArray(), 3, 4,  
                "ABCCED".toCharArray()));  
    } 

}
