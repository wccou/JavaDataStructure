package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA = (HelloWorld)context.getBean("dd");
		objA.setMessage("i am object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld)context.getBean("dd");
		objB.getMessage();
	}

}
