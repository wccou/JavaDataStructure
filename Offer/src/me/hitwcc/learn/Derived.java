package me.hitwcc.learn;
/**
 * 
 * Title:测试父类没有无参构造函数并且子类中不显示调用父类的有参构造函数
 * Description:
 * @author: wcc
 * @created: 2018年7月2日下午7:50:21
 */
class Base{
    public Base(String s){
        System.out.print("B");
    }
}

public class Derived extends Base{

	public Derived (String s) {
		//super("s");
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }

}
