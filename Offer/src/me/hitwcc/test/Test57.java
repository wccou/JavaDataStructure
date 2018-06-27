package me.hitwcc.test;

import java.util.ArrayList;

/**
 * 
 * Title:面试题27
 * Description:和为S的数字
 * @author: wcc
 * @created: 2018年6月27日上午10:45:41
 */
public class Test57 {

	public Test57() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:输入一个递增排序的数组和一个数字S，在数组中
	 * 				查找两个数，使得他们的和正好是S，只输出一组即可
	 * @author: wcc
	 * @created: 上午10:48:06
	 * @param array
	 * @param sum
	 * @return
	 */
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        if(array==null||array.length<2)
        	return list;
        int i=0;
        int j=array.length-1;
        while(i<j){
        	if(array[i]+array[j]==sum){
        		list.add(array[i]);
        		list.add(array[j]);
        		return list;
        	}else if(array[i]+array[j]>sum){
        		j--;
        	}else{
        		i++;
        	}
        }
        return list;
    }
	/**
	 * 
	 * @description:和为s的连续正数序列 例如1+2+3+4+5=4+5+6=7+8=15
	 * @author: wcc
	 * @created: 上午10:55:19
	 * @param sum
	 * @return
	 */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        for(int n=(int) Math.sqrt(2*sum);n>=2;n--){
        	if(((n&1)==1&&(sum%n==0))||((sum%n)*2==n)){
        		ArrayList<Integer> list=new ArrayList<Integer>();
        		for(int j=0,k=sum/n-(n-1)/2;j<n;j++,k++){
        			list.add(k);
        		}
        		ans.add(list);
        	}
        }
        return ans;
    }
}
