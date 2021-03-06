package me.hitwcc.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Title:面试题41 数据流中的中位数
 * Description:
 * @author: wcc
 * @created: 2018年6月14日下午5:02:44
 */
public class Test41 {

	private ArrayList<Integer> arr = new ArrayList<Integer>();
	public void Insert(Integer num) {
	    arr.add(num);
    }

    public Double GetMedian() {
        double middle = 0.0;
        int size = arr.size();
        if(size == 0)
        	return 0.0;
        Integer[] array = (Integer[]) arr.toArray(new Integer[size]);
        Arrays.sort(array);
        if(size%2==0){
        	middle = (array[size/2-1]+array[size/2])/2.0;
        }else{
        	middle = array[size/2];
        }
        
        
        return middle;
    }

}
