package me.hitwcc.ex1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class GraphicDiaplay extends JPanel{

	private Point[] points;
	private Point p0;
	double x_,y_;
	List<Point> list=new ArrayList<Point>();	
	
	//图形显示构造函数，参数为点集
	public GraphicDiaplay(Point[] ps){
		this.points=ps;
	}
	//方法：点的绘制，点的极角计算，凸包的绘制
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.black); //普通点绘制为黑色
		for (int i = 0; i < points.length; i++) 
			if (points[i].isInCh()==false) 	
				g.fillOval((int)points[i].getX(), (int)points[i].getY(), 4, 4);	
				
		g.setColor(Color.red);//标记为凸包的点绘制成红色的点		
		for (int i = 0; i < points.length; i++) 
			if (points[i].isInCh()==true) 
				g.fillOval((int)points[i].getX(), (int)points[i].getY(), 5, 5);	
		
		for (int i = 0; i < points.length; i++) 
			if (points[i].isInCh()==true) 
				list.add(points[i]);			
		
		int l=list.size();//点的个数
		//将点按照横坐标从小到达排序存储
		for (int i = 0; i < l-1; i++) 
			for (int j = i+1; j < l; j++) 
				if (list.get(i).getX()>list.get(j).getX()) 
					list.get(i).exchange(list.get(j));
	
		p0=list.get(0);
		//将p0赋值为 y坐标最小点 
		for (int i = 1; i < l; i++)  			
			if (p0.getY()>list.get(i).getY()) 
				p0=list.get(i);			
				
		p0.exchange(list.get(0));  //list中的第一个点变为纵坐标最小的点p0
		p0=list.get(0);//将p0的点改回纵坐标最小的点
		
		// 计算极角大小 ，将每个点的极角标记出来
		for (int i = 1; i < l; i++) { 		
			x_=list.get(i).getX()-p0.getX();
			y_=list.get(i).getY()-p0.getY();
			list.get(i).setAngle((double)(Math.atan2(y_,x_)*180/Math.PI));
		}
		
		list.get(0).setAngle(0);//纵坐标最小点的极角为0
		
		//将点按照极角大小进行递增排序，由小到大
		for (int i = 0; i < l-1; i++) 
			for (int j = i+1; j < l; j++) 
				if (list.get(i).getAngle()>list.get(j).getAngle()) 
					list.get(i).exchange(list.get(j));
			
        //将list中存储的最大凸包的点使用红色线连接起来
		for (int i = 0; i < l-1; i++) 		
			g.drawLine((int)list.get(i).getX(),(int)list.get(i).getY(),(int)list.get(i+1).getX(),(int)list.get(i+1).getY());
		g.drawLine((int)list.get(l-1).getX(),(int)list.get(l-1).getY(),(int)list.get(0).getX(),(int)list.get(0).getY());
	}

}
