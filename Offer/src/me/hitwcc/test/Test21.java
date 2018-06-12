package me.hitwcc.test;
/**
 * 
 * Title:面试题21 调整数组顺序使奇数位于偶数前面 双指针法 
 * Description:
 * @author: wcc
 * @created: 2018年5月30日上午10:51:55
 */
public class Test21 {

	public Test21() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @description:不考虑偶数偶数之间和奇数奇数之间相对位置
	 * @author: wcc
	 * @created: 上午11:11:39
	 * @param data
	 */
	public void soultion(int[] data){
		int begin=0;
		int end=data.length-1;
		while(begin<=end){
			while(begin<end&&(data[begin]&1)==1)
				begin++;
			while(begin<end&&(data[end]&1)==0)
				end++;
			if(begin<end){
				int temp=data[begin];
				data[begin]=data[end];
				data[end]=temp;
			}
		}
	}
	
	public void solution2(int[] data){
		for(int i=0;i<data.length;i++){
			for(int j=i;j>=1;j--){
				if(data[j]%2==1&&data[j-1]%2==0){
					int temp=data[j];
					data[j]=data[j-1];
					data[j-1]=temp;
				}
			}
			
		}
	}
}
