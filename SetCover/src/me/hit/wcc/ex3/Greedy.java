package me.hit.wcc.ex3;

import java.util.HashSet;

/**
 * 
 * Title:
 * Description:贪心方法
 * @author: wcc
 * @created: 2018年4月26日下午3:45:20
 */
public class Greedy {

	public Greedy() {
		// TODO Auto-generated constructor stub
	}
	public static HashSet<HashSet<Integer>> GreedySet(HashSet<Integer> U,HashSet<HashSet<Integer>> S){
		HashSet<Integer> F=new HashSet<Integer>();
		F=U;
		HashSet<HashSet<Integer>> C =new HashSet<HashSet<Integer>>();
		while(F.size()>0){
			int number=0;
			HashSet<Integer> set=new HashSet<Integer>();
			for(HashSet<Integer> temp:S){
				int diffNumber=0;
				for (Integer i : temp) 
					if (F.contains(i))
						diffNumber++;
				if(diffNumber>number){
					number=diffNumber;
					set=temp;
				}
			}
			C.add(set);
			F.removeAll(set);
			S.remove(set);
		}
		return C;
	}
	
	/*public static void main(String[] args) {
		HashSet<Integer> X = CreateSets.CreateX(1000);
		//System.out.println("44444");
		HashSet<HashSet<Integer>> F = CreateSets.createSets(1000, 1000);
		//System.out.println("555555");
		long start = System.currentTimeMillis();
		HashSet<HashSet<Integer>> C=Greedy.GreedySet(X, F);
		System.out.println("贪心算法选取的子集"+C.size()+"个:\n"+C);
		long end = System.currentTimeMillis();
		long time=end-start;
		System.out.println("贪心算法运行时间："+time+"ms");
	}*/
	
}
