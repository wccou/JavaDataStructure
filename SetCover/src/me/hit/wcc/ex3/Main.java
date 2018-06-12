package me.hit.wcc.ex3;

import java.util.HashSet;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		HashSet<Integer> X = CreateSets.CreateX(5000);
		//System.out.println("44444");
		HashSet<HashSet<Integer>> F = CreateSets.createSets(5000, 5000);
		//System.out.println("555555");
		long start = System.currentTimeMillis();
		HashSet<HashSet<Integer>> C=Greedy.GreedySet(X, F);
		//HashSet<HashSet<Integer>> C=Line.HashSetConverRounding(X, F);
		System.out.println("选取的子集"+C.size()+"个:\n"+C);
		//System.out.println("选取的子集"+D.size()+"个:\n"+D);
		long end = System.currentTimeMillis();
		long time=end-start;
		System.out.println("运行时间："+time+"ms");
	}

}
