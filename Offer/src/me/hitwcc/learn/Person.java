package me.hitwcc.learn;


public class Person{
	private static int i=1;
    public int getNext(){
         return i++;
    }
    public static void main(String[] args) {  
    	String x="fmn";
    	x.toUpperCase();
    	String y=x.replace('f','F');
    	y=y+"wxy";
    	System.out.println(y);
     }
}

