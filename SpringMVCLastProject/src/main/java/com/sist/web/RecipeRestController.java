package com.sist.web;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.service.RecipeService;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 데이터베이스 : MySQL : (MyBatis, JAP) 
// 언어 : (Java, Kotlin) ,Python Front(Vue / React)
// Docker / AWS / Git(Action)
@RestController
@CrossOrigin(origins="*")
public class RecipeRestController {
	// 데이터베이스 => service
	@Autowired
	private RecipeService rservice;
	
	@GetMapping(value="recipe/list_vue.do",produces="text/plain;charset=UTF-8")
	public String recipe_list_vue(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<RecipeVO> list=rservice.recipeListData(start, end);
		int count=rservice.recipeCount();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		// 블록별
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("count", count);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		String json="";
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			json=mapper.writeValueAsString(map);
		}catch(Exception ex) {}
		
		return json;
	}
}
