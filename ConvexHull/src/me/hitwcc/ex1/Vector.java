package me.hitwcc.ex1;

public class Vector {
	double x,y;
	
	public Vector(Point a,Point b) {
		this.x = b.getX()-a.getX();
		this.y = b.getY()-a.getY();
		// TODO Auto-generated constructor stub
	}
	public double CrossProduct(Vector b){
		return x * b.y - y * b.x;
	}

}
