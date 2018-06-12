package me.hit.wcc.ex3;

import java.util.HashSet;
import java.util.Random;

public class CreateSets {


	/**
	 * 
	 * @description:生成母集合X 简单的以1~n的整数填充
	 * @author: wcc
	 * @created: 下午2:23:02
	 * @param n
	 * @return
	 */
	public static HashSet<Integer> CreateX(int n){
		HashSet<Integer> X=new HashSet<Integer>();
		for(int i=0;i<n;i++){
			X.add(i+1);
		}
		return X;
	}
	/**
	 * 
	 * @description:生成子集合族 按照指导书生成
	 * @author: wcc
	 * @created: 下午4:11:21
	 * @param size
	 * @param numbers
	 * @return
	 */
	public static HashSet<HashSet<Integer>> createSets(int size, int numbers){
		HashSet<HashSet<Integer>> sets = new HashSet<HashSet<Integer>>();
		HashSet<Integer> set1 = new HashSet<Integer>();//第一个子集
		HashSet<Integer> allset = new HashSet<Integer>();//用来存放已有集合的并集
		Random rd = new Random();
		//S1
		while(set1.size() <= 20)//子集s0：随机选X中的20个点放入其中，
			set1.add(rd.nextInt(size)); //随机生成1到size 的int 随机数		
		sets.add(set1);//s0加入子集sets中
		allset.addAll(set1);//子集s1中的元素加入
		//S2以及之后的集合
		HashSet<Integer> set = new HashSet<Integer>();
		while(allset.size() < size -20){
			int n = rd.nextInt(20) + 1;
			int x = rd.nextInt(n) + 1;
			set = new HashSet<Integer>();
			
			while(set.size() <= x) 
				set.add(rd.nextInt(size)+1);
			
			while(set.size() <= n){
				int num = rd.nextInt(size)+1; 
				while(allset.contains(num))
					num = rd.nextInt(size)+1;				
				set.add(num);
			}//从x-s中选n-x个元素
			sets.add(set);//加入子集族sets中
			allset.addAll(set);//子集中的元素加入并集合
		}
	
		//有限集中未包含的元素计入一个子集中，并将该子集加入
		for(int i = 1; i < size+1; i++)
			if(!allset.contains(i))
				set.add(i);	
		sets.add(set);
		//（2）生成其余集合
		while(sets.size() < numbers){
			set = new HashSet<Integer>();
			int n = rd.nextInt(5) + 1;
			while(set.size() <= n)//随机生成n个数加入子集set中，
				set.add(rd.nextInt(size)+1);			
			sets.add(set);//子集加入sets
		}
		return sets;
	}

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		HashSet<HashSet<Integer>> result=createSets(1000, 1000);
		System.out.println(result);
		Object[] obj = result.toArray();//先讲set集合转为Object对象数组（向上转型）  
        HashSet<Integer> temp[] = new HashSet[obj.length];  
        for (int i = 0; i < obj.length; i++)  
            temp[i] = (HashSet<Integer>) obj[i];//将Object对象数组转为整型数组（强制向下转型）  
		HashSet<Integer> a=new HashSet<Integer>();
		for(int j=0;j<result.size();j++){
			a.addAll(temp[j]);
		}
		System.out.println(a);
		

}
}
