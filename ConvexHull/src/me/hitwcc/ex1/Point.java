package me.hitwcc.ex1;



public class Point {
	private double x;
	private double y;
	private double angle;
	private boolean InCh;
	
	
	public void exchange(Point p) {
		double xt = p.x;
		double yt = p.y;
		double anglet = p.angle;
		boolean isInCHt = p.isInCh(); 

		p.x = this.x;
		p.y = this.y;
		p.angle = this.angle;
		p.setInCh(this.isInCh());

		this.x = xt;
		this.y = yt;
		this.angle = anglet;
		this.setInCh(isInCHt); 
	}
	
	/**
	 * 
	 * @description:构造函数 根据横纵坐标值
	 * @author: wcc
	 * @param x
	 * @param y
	 */
	public Point(double x, double y){
		this.x = x;
		this.y = y;
		this.angle = 0;
		this.InCh = true;
	}
	
	 // 求两点间距离	 
	double distance(Point p) {
		return (Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y)* (p.y - this.y)));
	}	
	
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}
	/**
	 * @return the inCh
	 */
	public boolean isInCh() {
		return InCh;
	}
	/**
	 * @param inCh the inCh to set
	 */
	public void setInCh(boolean inCh) {
		this.InCh = inCh;
	}
	/**
	 * @param angle the angle to set
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	

}
