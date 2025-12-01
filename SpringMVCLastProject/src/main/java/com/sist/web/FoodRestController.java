package com.sist.web;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// router
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
/*
 * 	DAO : 데이터베이스만 연동
 *  VO : 데이터베이스에 있는 값을 받아서 브라우저로 전송시 데이터를 묶어서 전송
 *  Service : DAO여러개를 묶어서 한번에 처리
 *            => 기타 처리
 *            => 비밀번호 암호화 / 복호화
 *            => 비밀번호 확인
 *  Controller : JSP를 제어
 *               => forward / redirect : 파일 변경
 *               => front : router
 *  RestController => 자바스크립트 연동 : JSON / 문자열
 *  -----------------------------------------------
 *   서버로서의 역할만 수행
 */
public class FoodRestController {
	// 스프링에 등록된 클래스중에 필요한 클래스 가지고 오기 @Autowired
	@Autowired
	private FoodService fservice;
	
	@GetMapping(value="food/list_vue.do",produces="text/plain;charset=UTF-8")
	public String food_list_vue(int page)
	{
		String result="";
		Map map=new HashMap();
		final int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<FoodVO> list=fservice.foodListData(start, end);
		int totalpage=fservice.foodTotalPage();
		
		// 블록별 
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		// JavaScript 전송
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(map);
			// jackson : 객체변환 객체 => JSON => Boot에는 탑재
		}catch(Exception ex) {}
		return result;
	}
	@GetMapping(value="food/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String food_detail_vue(int fno)
	{
		String result="";
		FoodVO vo=fservice.foodDetailData(fno);
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(vo);
		}catch(Exception ex) {}
		return result;
	}
	// DI / AOP / MVC / Transaction(MyBatis,JPA)
	@GetMapping(value="food/find_vue.do",produces="text/plain;charset=UTF-8")
	public String food_find_vue(int page,String address)
	{
		String result="";
		if(address==null)
			address="마포";
		Map map=new HashMap();
		final int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		map.put("start", start); // 메퍼안에 #{값}
		map.put("end", end);
		map.put("address", address);
		List<FoodVO> list=fservice.foodFindData(map);
		int totalpage=fservice.foodFindTotalPage(address);
		
		// 블록별 
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		// JavaScript 전송
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("address", address);
		
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(map);
			// jackson : 객체변환 객체 => JSON => Boot에는 탑재
		}catch(Exception ex) {}
		return result;
	}
}
