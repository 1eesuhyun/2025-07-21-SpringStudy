package com.sist.vo;

import lombok.Data;

@Data
public class MemberVO {
	/*
	 *  USERID       VARCHAR2(20)  
		USERPWD      VARCHAR2(300) 
		USERNAME     VARCHAR2(50)  
		SEX          VARCHAR2(10)  
		ENABLE       NUMBER        
		AUTHORITY    VARCHAR2(20)
	 */
	private String userid,userpwd,username,sex,authority;
	private int enable;
}
