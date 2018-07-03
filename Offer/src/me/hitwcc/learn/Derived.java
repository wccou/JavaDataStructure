package me.hitwcc.learn;
/**
 * 
 * Title:娴嬭瘯鐖剁被娌℃湁鏃犲弬鏋勯�犲嚱鏁板苟涓斿瓙绫讳腑涓嶆樉绀鸿皟鐢ㄧ埗绫荤殑鏈夊弬鏋勯�犲嚱鏁�
 * Description:
 * @author: wcc
 * @created: 2018骞�7鏈�2鏃ヤ笅鍗�7:50:21
 */
class Base{
    public Base(String s){
        System.out.print("B");
    }
}

public class Derived extends Base{

	public Derived (String s) {
		super("s");//测试父类没有无参构造器时 必须显示调用父类有参构造器
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }

}
