package me.hitwcc.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Test01 {

	public Test01() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(211);
		list.add(list);
		System.out.println(list.size());
		String str = (String) list.get(0);
		System.out.println(list.get(0));
	}
}

class Dog{
	
}