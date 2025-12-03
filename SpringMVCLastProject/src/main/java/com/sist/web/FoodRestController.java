package com.sist.web;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
// router
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "*") // vue:8081 / react : 3000
/*
 * 	DAO : �����ͺ��̽��� ����
 *  VO : �����ͺ��̽��� �ִ� ���� �޾Ƽ� �������� ���۽� �����͸� ��� ����
 *  Service : DAO�������� ��� �ѹ��� ó��
 *            => ��Ÿ ó��
 *            => ��й�ȣ ��ȣȭ / ��ȣȭ
 *            => ��й�ȣ Ȯ��
 *  Controller : JSP�� ����
 *               => forward / redirect : ���� ����
 *               => front : router
 *  RestController => �ڹٽ�ũ��Ʈ ���� : JSON / ���ڿ�
 *  -----------------------------------------------
 *   �����μ��� ���Ҹ� ����
 */
public class FoodRestController {
	// �������� ��ϵ� Ŭ�����߿� �ʿ��� Ŭ���� ������ ���� @Autowired
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
		
		// ��Ϻ� 
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		// JavaScript ����
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(map);
			// jackson : ��ü��ȯ ��ü => JSON => Boot���� ž��
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
		map.put("start", start); // ���۾ȿ� #{��}
		map.put("end", end);
		map.put("address", address);
		List<FoodVO> list=fservice.foodFindData(map);
		int totalpage=fservice.foodFindTotalPage(address);
		
		// ��Ϻ� 
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		// JavaScript ����
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
			// jackson : ��ü��ȯ ��ü => JSON => Boot���� ž��
		}catch(Exception ex) {}
		return result;
	}
	@GetMapping(value="food/type_vue.do",produces="text/plain;charset=UTF-8")
	public String food_type_vue(int page,String type)
	{
		String result="";
		Map map=new HashMap();
		final int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		map.put("start", start); // ���۾ȿ� #{��}
		map.put("end", end);
		map.put("type", type);
		List<FoodVO> list=fservice.foodTypeData(map);
		int totalpage=fservice.foodTypeTotalPage(type);
		
		// ��Ϻ� 
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		// JavaScript ����
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("type", type);
		
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(map);
			// jackson : ��ü��ȯ ��ü => JSON => Boot���� ž��
		}catch(Exception ex) {}
		return result;
	}
	
}
