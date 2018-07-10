/**
 * Title:Test00
 * Description:
 * @author: wcc
 * @created: 2018年7月10日上午10:01:45
 */
package me.hitwcc.learn;

/**
 * Title:Test00
 * Description:
 * @author: wcc
 * @created: 2018年7月10日上午10:01:45
 */
public class Test00 {
	 public static void main(String args[])
	  {
		 String str1 = new String("hello");
	        String str2 = new String("hello");
	        String str3 = "hello";
	        String str4 = "hello";
	        String str5 = "he"+"llo";
	        String str6 = "he";
	        String str7 = "llo";
	        System.out.println(str1==str2);
	        System.out.println(str1==str3);
	        System.out.println(str3==str4);
	        System.out.println(str3=="hello");
	        System.out.println(str4==(str6+str7));
	        System.out.println(str4==str5);
	  }
}
