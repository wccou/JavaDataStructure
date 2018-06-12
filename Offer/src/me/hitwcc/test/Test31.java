package me.hitwcc.test;

import java.util.Stack;

/**
 * 
 * Title:面试题31 栈的压入和弹出序列
 * Description:判断
 * @author: wcc
 * @created: 2018年6月6日下午2:51:10
 */
public class Test31 {

	public Test31() {
		// TODO Auto-generated constructor stub
	}
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	    //boolean possible = false;
	    if(pushA == null||popA == null){
	    	return false;
	    }
	    Stack<Integer> stack=new Stack<Integer>();
	    int popIndex=0;//标识弹出序列的位置
	    for(int i=0;i<pushA.length;i++){
	    	stack.push(pushA[i]);
	    	while(!stack.isEmpty()&&stack.peek()==popA[popIndex]){
	    		stack.pop();
	    		popIndex++;
	    	}
	    }
	    
		return stack.isEmpty();
	      
    }

}
