package me.hitwcc.learn;

public class TestReplaceAll {

	public TestReplaceAll() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String classFile = "com.jd.". replaceAll("\\.", "/") + "MyClass.class";
	    System.out.println(classFile);
	}
}
