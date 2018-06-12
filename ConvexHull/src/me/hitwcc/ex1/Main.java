package me.hitwcc.ex1;

import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;



@SuppressWarnings("unused")
public class Main {

	
	public static void main(String[] args) throws Exception{
		int length = 1000;
		Point[] A = new Point[length];
		Point[] B = new Point[length];
		Point[] C = new Point[length];
		Point[] D = new Point[length];
		Point[] E = new Point[length];
		
		Random r = new Random();
		for(int i = 0; i < length; i ++){
			double x = r.nextInt(1000000)/1000.0;
			double y = r.nextInt(1000000)/1000.0;
			A[i] = new Point(x,y);
		}
		
		for(int i = 0; i < length; i ++){
			B[i]=A[i];
			C[i]=A[i];
			D[i]=A[i];
			E[i]=A[i];
		}

/*		long start1 = System.currentTimeMillis();
		//ConvexHull.BruteForce(A);
		//ConvexHull.BetterBruteForce(A);
		//ConvexHull.Graham_scan(A);
		//ConvexHull.DivideConquer(A);
		ConvexHull.BetterDivideConquer(A);
		long end1 = System.currentTimeMillis();

		long time1 = end1-start1;
	
		System.out.println("运行时间："+time1+"ms.");
	
        JFrame Frame1 = new JFrame();
		GraphicDiaplay aa = new GraphicDiaplay(A);
		Frame1.setSize(1500, 1500);
		Frame1.setVisible(true);
		Frame1.add(aa);
		Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
*/		
		
		

		
		/*long start2 = System.currentTimeMillis();
        ConvexHull.BruteForce(B);
        long end2 = System.currentTimeMillis();
		
		long start1 = System.currentTimeMillis();
		ConvexHull.BetterBruteForce(A);
		long end1 = System.currentTimeMillis();
*/
        long start3 = System.currentTimeMillis();
        ConvexHull.Graham_scan(C);
        long end3 = System.currentTimeMillis();
 
        long start4 = System.currentTimeMillis();
		ConvexHull.DivideConquer(D);
		long end4 = System.currentTimeMillis();
		
		long start5 = System.currentTimeMillis();
		ConvexHull.BetterDivideConquer(D);
		long end5 = System.currentTimeMillis();

/*		long time1 = end1-start1;
		long time2 = end2-start2;*/
		long time3 = end3-start3;
		long time4 = end4-start4;
		long time5 = end5-start5;
		
/*		System.out.println("原始的暴力法的运行时间："+time2+"ms.");
		System.out.println("改进的暴力法运行时间："+time1+"ms.");*/
		System.out.println("Graham_scan算法的运行时间："+time3+"ms.");
		System.out.println("分治算法的运行时间："+time4+"ms.");
		System.out.println("优化的分治算法的运行时间："+time5+"ms.");
		
/*        JFrame Frame1 = new JFrame("优化暴力法");
		GraphicDiaplay aa = new GraphicDiaplay(A);
		Frame1.setSize(1500, 1500);
		Frame1.setVisible(true);
		Frame1.add(aa);
		
		JFrame Frame2 = new JFrame("原始暴力法");
		GraphicDiaplay bb = new GraphicDiaplay(B);
		Frame2.setSize(1500, 1500);
		Frame2.setVisible(true);
		Frame2.add(bb);*/
		
		JFrame Frame3 = new JFrame("Graham_scan算法");
		GraphicDiaplay cc = new GraphicDiaplay(C);
		Frame3.setSize(1500, 1500);
		Frame3.setVisible(true);
		Frame3.add(cc);
		
		JFrame Frame4 = new JFrame("分治算法");
		GraphicDiaplay dd = new GraphicDiaplay(D);
		Frame4.setSize(1500, 1500);
		Frame4.setVisible(true);
		Frame4.add(dd);
		
		JFrame Frame5 = new JFrame("优化的分治算法");
		GraphicDiaplay ee = new GraphicDiaplay(D);
		Frame5.setSize(1500, 1500);
		Frame5.setVisible(true);
		Frame5.add(ee);

		Frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}
