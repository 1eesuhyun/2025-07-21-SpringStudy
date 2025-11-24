package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] xml= {"student-app.xml","member-app.xml","sawon-app.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		
		Member m=(Member)app.getBean("mem");
		System.out.println("번호:"+m.getNo());
		System.out.println("이름:"+m.getName());
		System.out.println("성별:"+m.getSex());
		
		System.out.println("===================");
		Student s=(Student)app.getBean("std");
		System.out.println("학번:"+s.getHakbun());
		System.out.println("이름:"+s.getName());
		System.out.println("성별:"+s.getSex());
		
		System.out.println("===================");
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println("사번:"+sa.getSabun());
		System.out.println("이름:"+sa.getName());
		System.out.println("성별:"+sa.getSex());
	}

}
