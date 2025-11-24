package com.sist.main3;

import java.util.*;
// ì»¨í…Œ?´?„ˆ => Factory Pattern
public class ApplicationContext {
	private Map clsMap = new HashMap();
	public ApplicationContext() {
		clsMap.put("a", new A());
		clsMap.put("b", new B());
		clsMap.put("c", new C());
	}
	
	public Print getBean(String key) {
		return (Print)clsMap.get(key);
	}
}
