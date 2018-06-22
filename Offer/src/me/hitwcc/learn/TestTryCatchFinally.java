package me.hitwcc.learn;

public class TestTryCatchFinally {
	static int i = 0 ;
    static int test(){
        try {
            return i;
        } catch (Exception e) {
            return -1;
        }finally{
        	i++;
            //return i;
        }
    }
	public TestTryCatchFinally() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println(test());
		float i=0.1f;
		Float j=new Float(0.1);
		System.out.println(i==j);
		
	}
}
