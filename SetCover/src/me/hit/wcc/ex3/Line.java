package me.hit.wcc.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//import java.util.HashSet;
/**
 * 
 * Title:
 * Description:线性规划法
 * @author: wcc
 * @created: 2018年4月26日下午3:44:46
 */

public class Line {
	/**
	 * 
	 * @description:书上舍入法的实现
	 * @author: wcc
	 * @created: 下午3:44:36
	 * @param X
	 * @param F
	 * @return
	 */
	public static HashSet<HashSet<Integer>> HashSetConverRounding(HashSet<Integer> X, HashSet<HashSet<Integer>> F){
		HashSet<HashSet<Integer>> C = new HashSet<>();
		
		List<Double> xOpt = getLPOpt(X, F);//求解线性规划
		
		System.out.println(xOpt);
		int f = getMaxf(X, F);//求出最大频率
		int i = 0;
		for(HashSet<Integer> set:F){
			if(xOpt.get(i)>1d/f){
				C.add(set);
			}
			i++;
		}
		return C;
	}
	
	/**
	 * 
	 * @description:输出元素在F中出现的最大频率
	 * @author: wcc
	 * @created: 下午4:00:45
	 * @param X
	 * @param F
	 * @return
	 */
	private static int getMaxf(HashSet<Integer> X, HashSet<HashSet<Integer>> F) {
		int  max = 0;
		for(Integer e:X){
			int f = 0;
			for(HashSet<Integer> set:F){
				if(set.contains(e)){
					f++;
				}
			}
			if(f>max){
				max = f;
			}
		}
		return max;
	}
	
	/**
	 * 
	 * @description:使用线性规划求解
	 * @author: wcc
	 * @created: 下午4:05:50
	 * @param X
	 * @param F
	 * @return
	 */
	private static List<Double> getLPOpt(HashSet<Integer> X, HashSet<HashSet<Integer>> F) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(Integer e:X){
			i = 0;
			for(HashSet<Integer> set:F){
				if(set.contains(e)){
					sb.append(i);
					sb.append(",");
				}
				i++;
				
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("|");
		}
		sb.deleteCharAt(sb.length()-1);
		String[] args = {"python", "LP.py"};  //载入python程序的路径
	
		String result = execPy(args, sb.toString());

		List<Double> list = str2List(result);
		return list;

	}
	/**
	 * 
	 * @description:关键辅助函数 调用python求解线性规划问题
	 * @author: wcc
	 * @created: 下午4:09:31
	 * @param args
	 * @param str
	 * @return
	 */
	public static String execPy(String[] args, String str){
		StringBuilder sb = new StringBuilder();
		try {
			Process pr = Runtime.getRuntime().exec(args);//新建一个进程处理python 此时python等待输入
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));//相对于java声明一个输出流 对于python即是输入
			bw.write(str);
			bw.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			
			while(null != (line = br.readLine())){
				sb.append(line);
				sb.append("\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @description:string转list
	 * @author: wcc
	 * @created: 下午4:05:21
	 * @param str
	 * @return
	 */
	private static List<Double> str2List(String str) {
		List<Double> list = new ArrayList<>();
		String subStr = str.substring(1, str.length()-2);
		String[] strArry = subStr.split(",");
		for(String s:strArry){
			list.add(Double.parseDouble(s.trim()));
		}
		return list;
	}
	
/*	public static void main(String[] args) {
		HashSet<Integer> X = CreateSets.CreateX(1000);
		System.out.println("44444");
		HashSet<HashSet<Integer>> F = CreateSets.createSets(1000, 1000);
		System.out.println("555555");
		long start = System.currentTimeMillis();
		HashSet<HashSet<Integer>> C=SetConver.HashSetConverRounding(X, F);
		System.out.println("线性规划算法选取的子集"+C.size()+"个:\n"+C);
		long end = System.currentTimeMillis();
		long time=end-start;
		System.out.println("线性规划算法运行时间："+time+"ms");
	}*/
}
