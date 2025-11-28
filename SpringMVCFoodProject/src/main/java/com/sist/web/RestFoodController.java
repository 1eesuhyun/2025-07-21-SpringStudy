package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 화면 제어(X) => Front로 데이터 전송
// 1. 일반 문자열, 2. 정수, 3. JSON
// JSON을 자동으로 구현
import com.sist.dao.*;
import com.sist.service.*;
import com.sist.vo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class RestFoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception
	{
		int curpage=page;
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<FoodVO> list=service.foodListData(start, end);
		int totalpage=service.foodTotalPage();
		
		final int BLOCK=10;
		/*
		 *  < 1 2 3 4 5 6 7 8 9 10 >
		 *  
		 */
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		Map map=new HashMap();
		map.put("curpage", curpage);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("list", list);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
