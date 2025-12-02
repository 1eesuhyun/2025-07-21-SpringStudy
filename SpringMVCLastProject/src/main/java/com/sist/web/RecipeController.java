package com.sist.web;
import java.util.*;
import com.sist.dao.*;
import com.sist.service.RecipeService;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	@Autowired
	//@Qualifier("recipeServiceImpl")
	private RecipeService rservice;
	
	@GetMapping("recipe/list.do")
	public String recipe_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<RecipeVO> list=rservice.recipeListData(start, end);
		int count=rservice.recipeCount();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		// 블록별
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalpage", totalpage);
		/*
		 * 	class Model
		 * 	{
		 * 		HttpServletRequest request
		 * 		클래스 캡슐화
		 * 		public void addAttribute(String key,Object obj)
		 * 		{
		 * 			request.setAttribute(key,obj)
		 * 		}
		 * 	}
		 */
		model.addAttribute("main_jsp", "../recipe/list.jsp");
		return "main/main";
	}
}
