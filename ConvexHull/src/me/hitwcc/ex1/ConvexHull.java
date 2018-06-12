package me.hitwcc.ex1;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Random;
import java.util.Stack;



import java.util.List;
//import me.hitwcc.stack.*;
/**
 * 
 * Title:凸包问题的几种解法
 * Description:
 * @author: wcc
 * @created: 2018年4月17日上午10:33:13
 */
public class ConvexHull {
	static ArrayList<Point> hullSet = new ArrayList<Point>();
	/**
	 * 
	 * @description:蛮力法1求解凸包问题： 判断所有点是否都在直线同一侧  
	 * @author: wcc
	 * @created: 下午4:24:36
	 * @param A
	 * @return
	 */
	public static Point[] BetterBruteForce(Point[] A){
		Point[] resultPoint = new Point[A.length];
		int len = 0;
		for(int l = 0; l < A.length; l ++)
			A[l].setInCh(false);
		for(int i = 0; i < A.length; i ++){

			if(A[i].isInCh())
				continue;
			for(int j = 0; j < A.length; j ++){
				if( i == j )
					continue;
				double a = A[j].getY() - A[i].getY();
				double b = A[i].getX() - A[j].getX();
				double c = A[i].getX() * A[j].getY() - A[j].getX() * A[i].getY();
				int[] result = new int[A.length];
				
				for(int k = 0; k < A.length; k ++){
					if(i==k ||j==k)
						continue;
					double cal = a * (A[k].getX()) + b * (A[k].getY()) - c;
					if(cal >= 0){
						result[k] = 1;
					}else{
						result[k] = 0;
					}
				}
				
				
				if(Judge(result)){
					resultPoint[len] = A[i];
					A[i].setInCh(true);
					len ++;
					break;
				}
				A[i].setInCh(false);
				
			}
		}
		Point[] result1 = new Point[len];
        for(int m = 0;m < len;m++)
            result1[m] = resultPoint[m];
		return result1;
	}
	/**
	 * 
	 * @description:蛮力法求解凸包问题的辅助函数 用来判断所有的点是否在当前直线的同侧
	 * @author: wcc
	 * @created: 下午4:25:11
	 * @param B
	 * @return
	 */
	public static boolean Judge(int[] B){
		int sum = 0;
		for(int i = 0; i < B.length; i ++){
			sum = sum + B[i];
		}
		if(sum == B.length || sum == 0){
			return true;
		}
		return false;
		
	}
	
	/**
	 * 
	 * @description:蛮力法2求解凸包问题：PPT上用是否在三角形内部来判断
	 * @author: wcc
	 * @created: 下午2:29:35
	 * @param A
	 * @return
	 */
	public static List<Point> BruteForce(Point[] points){
		int length = points.length;
		boolean flag;
		for(int i = 0; i < length; i ++){
			if(!points[i].isInCh()){
				continue;
			}
			flag = false;
			for(int j = 0; j < length; j ++){
				if(flag)
					break;
				if(i == j || !points[j].isInCh())
					continue;
				for(int k = 0; k < length;  k ++){
					if(flag)
						break;
					if(i == k || j == k || !points[k].isInCh())
						continue;
					for(int l = 0; l < length; l ++){
						if(flag)
							break;
						if(i == l || j == l || k == l || !points[l].isInCh())
							continue;
						Point P = points[i];
						Point A = points[j];
						Point B = points[k];
						Point C = points[l];
						flag = inTriangle(P,A,B,C);
						if(flag)
							P.setInCh(false);
					}
				}
			}
		}
		List<Point> result = new ArrayList<Point>();
		for(int i=0;i<length;i++){
			if(points[i].isInCh())
				result.add(points[i]);
		}
		return result;
		
	}
	/**
	 * 
	 * @description:蛮力法2的辅助函数 用来判断P点是否在三角形ABC内部
	 * @author: wcc
	 * @created: 下午7:44:12
	 * @param P
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public static boolean inTriangle(Point P,Point A,Point B,Point C){
		Vector v0 = new Vector(A,P);
		Vector v1 = new Vector(B,P);
		Vector v2 = new Vector(C,P);
		double r1 = v0.CrossProduct(v1);
		double r2 = v1.CrossProduct(v2);
		double r3 = v2.CrossProduct(v0);
		if ((r1 > 0 && r2 > 0 && r3 > 0) || (r1 < 0 && r2 < 0 && r3 < 0)) // 在三角形内部
			return true;
		else if (r1 == 0 && ((r2 > 0 && r3 > 0) || (r2 < 0 && r3 < 0))) // 在三角形的边上
			return true;
		else if (r2 == 0 && ((r1 > 0 && r3 > 0) || (r1 < 0 && r3 < 0)))
			return true;
		else if (r3 == 0 && ((r1 > 0 && r2 > 0) || (r1 < 0 && r2 < 0)))
			return true;
		else
			return false;
		
	}	
	
	/**
	 * 
	 * @description:使用Graham_scan算法求解凸包问题
	 * @author: wcc
	 * @created: 下午4:32:51
	 * @param A
	 * @return
	 * @throws Exception 
	 */
	public static Stack<Point> Graham_scan(Point[] A) throws Exception{
		Point p0 = FindYmin(A);
		angle(A, p0);

		Sort(A,p0);
		/*System.out.println("排序后：");
		for(int i = 0; i < A.length; i ++)
			System.out.println("("+A[i].getX()+","+A[i].getY()+")"+"角度：" + A[i].getAngle());*/
		Stack<Point> stack = new Stack<Point>();
		stack.push(A[0]);
		stack.push(A[1]);
		stack.push(A[2]);
		for(int i = 3; i < A.length; i ++){
			while(PanDuan(stack,A[i]) ){
				Point t = stack.pop();
				t.setInCh(false);
			}
			stack.push(A[i]);
		}
		return stack;
	}
	//PanDuan(p0, temp[i], stack.top(), stack.nextToTop())
	/**
	 * 
	 * @description:Graham_scan的辅助函数 判断是否是左转点
	 * @author: wcc
	 * @created: 下午7:46:23
	 * @param stack
	 * @param e
	 * @return
	 */
	public static boolean PanDuan(Stack<Point> stack, Point e){
		Point p2 = stack.peek();
		stack.pop();
		Point p1 = stack.peek();
		stack.push(p2);
		double delta_x1 = p2.getX() - p1.getX();
		double delta_y1 = p2.getY() - p1.getY();
		double delta_x2 = e.getX() - p1.getX();
		double delta_y2 = e.getY() - p1.getY();
		double result = delta_x1*delta_y2 - delta_y1*delta_x2;
		if (result <= 0){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @description:排序
	 * @author: wcc
	 * @created: 下午7:48:56
	 * @param A
	 * @param p0
	 * @return
	 */
	public static Point[] Sort(Point[] A, Point p0){
		Point[] temp = new Point[A.length];
		temp = quickSort(A, 0, A.length-1);
		return temp;
	}
	/**
	 * 
	 * @description:以p0为参考计算角度
	 * @author: wcc
	 * @created: 下午7:49:20
	 * @param A
	 * @param p0
	 */
	public static void angle(Point[] A, Point p0){
		for(int i = 0; i < A.length; i ++){
			if(A[i] != p0){
				double j = A[i].getX() - p0.getX();  
				double k = A[i].getY() - p0.getY();  
		        double m = Math.sqrt(j * j + k * k); // 得到顶点i 到第一顶点的线段长度  
		        if (k < 0)  
		            j = (-1) * Math.abs(j);  
		        double h = Math.acos(j / m); // 得到该线段与x轴的角度
		        A[i].setAngle(h);
			}
			
		}
		/*System.out.println("排序前：");
		for(int i = 0; i < A.length; i ++)
			System.out.println("("+A[i].getX()+","+A[i].getY()+")"+"角度：" + A[i].getAngle());*/
	}
	/**
	 * 
	 * @description:快排的划分函数
	 * @author: wcc
	 * @created: 下午7:50:01
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	public static int Partition(Point[] target, int left, int right){
		double base = target[left].getAngle();
		int base_index = left;
		while(left < right){
			while(left < right && target[right].getAngle() >= base)
				right --;
			while(left < right && target[left].getAngle() <= base)
				left ++;
			Point temp = target[right];
			target[right] = target[left];
			target[left] = temp;
		}
		Point temp = target[left];
		target[left] = target[base_index];
		target[base_index] = temp;
		return left;
	}
	/**
	 * 
	 * @description:根据角度快排
	 * @author: wcc
	 * @created: 下午7:50:20
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	public static Point[] quickSort(Point[] target, int left, int right) {
		if (right > left){
			int partition_index = Partition(target,left,right);
			quickSort(target,left,partition_index - 1);
			quickSort(target,partition_index + 1,right);
			
		}
		//System.out.println(Arrays.toString(target));
		return target;
	}
	
	
	
	
	
	/**
	 * 
	 * @description:Graham_scan辅助函数  寻找Y值最小的点
	 * @author: wcc
	 * @created: 下午4:47:40
	 * @param A
	 * @return
	 */
	public static Point FindYmin(Point[] A){
		Point YminPoint = A[0];
		for(int i = 1; i < A.length; i ++){
			if(YminPoint.getY() > A[i].getY()){
				YminPoint = A[i];
			}
			continue;
		}
		return YminPoint;
	}
	
	/**
	 * 
	 * @description:分治算法：按照横坐标大小划分为左右两部分，各自求解 然后再对合并之后的使用Graham_scan算法
	 * @author: wcc
	 * @created: 下午8:24:39
	 * @param points
	 * @return
	 * @throws Exception
	 */
	public static Point[] DivideConquer(Point[] points) throws Exception{
		int length=points.length;
		if(length<=3)
			return points;
		//按照横坐标排序 为了之后的划分
		for (int i = 0; i < length-1; i++) 
			for (int j = i+1; j < length; j++) 
				if (points[i].getX()>points[j].getX()) 
					points[i].exchange(points[j]);	
		Point[] pointsL,pointsR;//0 to length/2-1    length/2 to length-1
		pointsL=DividePoints(points,0,(length/2-1));
		pointsR=DividePoints(points,length/2,length-1);
		Point[] mergedPoints=MergeTwoPoints(pointsL,pointsR);
		Graham_scan(mergedPoints);
		return mergedPoints;
	}
	/**
	 * 
	 * @description:合并两个点集
	 * @author: wcc
	 * @created: 下午1:37:21
	 * @param a
	 * @param b
	 * @return
	 */
	public static Point[] MergeTwoPoints(Point[] a,Point[] b){
		int lengtha=a.length;
		int lengthb=b.length;
		Point[] points=new Point[lengtha+lengthb];
		for (int i = 0; i < lengtha; i++) 
			points[i]=a[i];		
		for (int i = 0; i < lengthb; i++) 
			points[i+lengtha]=b[i];		
		return points;
		
	}
	/**
	 * 
	 * @description:划分点集
	 * @author: wcc
	 * @created: 下午1:38:02
	 * @param points
	 * @param left
	 * @param right
	 * @return
	 */
	public static Point[] DividePoints(Point[] points,int left,int right){
		Point[] result=new Point[right-left+1];
		for (int i = 0; i < right-left+1; i++) 
			result[i]=points[left+i];		
		return result;	
	}
	
	
	
	/**
	 * 
	 * @description:优化的分治法 上下划分
	 * @author: wcc
	 * @created: 下午1:45:30
	 * @param points
	 */
	public static void BetterDivideConquer(Point[] points) {
		int length = points.length;
		ArrayList<Point> SU, SL;
		SU = new ArrayList<Point>();
		SL = new ArrayList<Point>();
		
		// 按x坐标排序，得到最小最大值
		for (int i = 0; i < length - 1; i++) 
			for (int j = i + 1; j < length; j++) 
				if (points[i].getX() > points[j].getX()) 
					points[i].exchange(points[j]);
			
		int max = length - 1;
		int min = 0;
		if (points[min] == null)
			System.out.println(" ******");
		//最大最小x坐标存储到hullset中
		hullSet.add(points[min]);
		hullSet.add(points[max]);
		// 将点集分为上下两部分
		for (int i = 0; i < length; i++) {
			if (points[i].isInCh() == false || i == max || i == min) 	
				continue;
			if (Cross_Product(points[max], points[i], points[min]) > 0)//点在最小最大点线段的上面
				SU.add(points[i]);
			else  //点在最小最大点线段的下面
				SL.add(points[i]);
		}
		Divide(points[min], points[max], SU);//上面点集进行分治求解凸包
		Divide(points[max], points[min], SL);//下面点集进行分治求解凸包
		//合并时，由于此划分使用点集的最大最小点进行划分，此划分界线仅有两点且均在左右凸包上，因此直接合并两边的凸包点即使所求最大凸包
		for (int i = 0; i < length; i++) 
			points[i].setInCh(false);	
		for (int i = 0; i < hullSet.size(); i++) //凸包点存到hullset中
			hullSet.get(i).setInCh(true);		
	}	
    //分治求解凸包
	public static void Divide(Point p0, Point p1, ArrayList<Point> list) {
		Point pMax = null;
		ArrayList<Point> LNodelist, RNodelist;
		double cpMax = 0;
		//找到在在线段p1p0上面的点pMax及值
		for (int i = 0; i < list.size(); i++) {
			if (Cross_Product(p1, list.get(i), p0) > cpMax) {
				cpMax = Cross_Product(p1, list.get(i), p0);
				pMax = list.get(i);
			}
		}
		if (pMax != null) {
			hullSet.add(pMax);//点加入凸包集中
			list.remove(pMax);//从点集中移除
			LNodelist = get_List(p0, pMax, list);//p0pMax左侧的点集，上
			RNodelist = get_List(pMax, p0, list);//p0pMax右侧的点集，下
			Divide(p0, pMax, LNodelist);//递归求上面点集的凸包
			Divide(pMax, p1, RNodelist);//递归求下面点集的凸包
		}
	}
	//判断点的方位，相对与公共端点p0,p0p1和p0p2的方向,若＞０表示p0p1在p0p2的顺时针方向，否则表示p0p1在p0p2的逆时针方向
	public static double Cross_Product(Point p1, Point p2, Point p0) {
		return (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p1.getY() - p0.getY()) * (p2.getX() - p0.getX());
	}
	//分，找到在线段p0p1上面的点集
	public static ArrayList<Point> get_List(Point p0, Point p1, ArrayList<Point> list) {
		ArrayList<Point> Nodelist = new ArrayList<Point>();
		for (int i = 0; i < list.size(); i++) 
			if (Cross_Product(p1, list.get(i), p0) > 0)//点在线段p1p0上面
				Nodelist.add(list.get(i));		
		return Nodelist;
	}
	
	/**
	 * 
	 * @description:测试
	 * @author: wcc
	 * @created: 下午1:38:24
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		int length = 1000000;
		Point[] A = new Point[length];
		Random r = new Random();
		for(int i = 0; i < length; i ++){
			double x = r.nextInt(1000000)/10000.0;
			double y = r.nextInt(1000000)/10000.0;
			A[i] = new Point(x,y);
		}
		
		/*Point t = FindYmin(A);  // test FindYmin
		System.out.println("Y最小的点为：("+t.getX()+","+t.getY()+")");
		angle(A, t);
		for(int i = 0; i < A.length; i ++)
			System.out.println("("+A[i].getX()+","+A[i].getY()+")"+"角度：" + A[i].getAngle());
		System.out.println("-----------------------");
		Point[] temp = Sort(A,t);
		for(int i = 0; i < temp.length; i ++)
			System.out.println("排序后("+temp[i].getX()+","+temp[i].getY()+")"+"角度：" + temp[i].getAngle());
		Sort(A,t);*/
        /*Point[] result1 = ConvexPoint(A);
        System.out.println("集合A中满足凸包的点总共有" + result1.length + "个，分别为：");
        for(int i = 0;i < result1.length;i++)
            System.out.println("("+result1[i].getX()+","+result1[i].getY()+")"+"角度：" + result1[i].getAngle());*/
        Stack<Point> result = new Stack<Point>();
        result = Graham_scan(A);
        int sum = 0;
        System.out.println("Graham_scan算法结果：");
        while(!result.isEmpty()){
        	sum ++;
        	Point top = result.pop();
        	System.out.println("("+top.getX()+","+top.getY()+")"+"角度：" + top.getAngle());
        	
        }
        System.out.println("总共"+sum+"个元素。");
    }

}
