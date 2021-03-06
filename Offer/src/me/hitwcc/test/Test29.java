package me.hitwcc.test;

import java.util.ArrayList;

/**
 * 
 * Title:面试题29 顺时针打印矩阵
 * Description:较为复杂
 * @author: wcc
 * @created: 2018年6月4日下午6:27:21
 */
public class Test29 {

	public Test29() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	       ArrayList<Integer> result=new ArrayList<Integer>();
	       if(matrix==null){
	    	   return result;
	       }
	       int rows=matrix.length;
	       int columns=0;
	       if(rows>0){
	    	   columns=matrix[0].length;
	       }else{
	    	   return result;
	       }
	       int start=0;
	       while(columns>start*2&&rows>start*2){
	    	   printMatrixInCircle(matrix,rows,columns,start,result);
	    	   start++;
	       }
		return result;
    }
	public static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> print){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for(int i = start; i <= endX; i++){
            int num = matrix[start][i];
            print.add(num);
        }

        //从上到下打印一列
        if(start < endY){
           for(int i = start + 1; i <= endY; i++){
               int num = matrix[i][endX];
               print.add(num);
           } 
        }

        //从右到左打印一行
        if(start < endX && start < endY){
            for(int i = endX - 1; i >= start; i--){
                int num = matrix[endY][i];
                print.add(num);
            }
        }

        //从下到上打印一列
        if(start < endX && start < endY - 1){
            for(int i = endY - 1; i >= start+1; i--){
                int num = matrix[i][start];
                print.add(num);
            }
        }
    }
	
}
