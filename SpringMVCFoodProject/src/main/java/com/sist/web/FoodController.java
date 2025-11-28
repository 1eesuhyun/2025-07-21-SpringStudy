package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.service.FoodService;
@Controller
public class FoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping("food/list.do")
	public String food_list(String page,Model model)
	{
		if(page==null)
			page="1";
		// 요청 처리
		int curPage=Integer.parseInt(page);
		final int rowSize=12;
		List<FoodVO> list=service.foodListData((curPage*rowSize)-(rowSize-1), (curPage*rowSize));
		int totalpage=service.foodTotalPage();
		
		final int BLOCK=12;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 결과값 전송
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list",list);
		model.addAttribute("curpage", curPage);
		model.addAttribute("totalpage", totalpage);
		return "food/list";
	}
	@RequestMapping("food/find.do")
	public String food_find(String page,String fd,String column,Model model)
	{
		if(page==null)
			page="1";
		if(fd==null)
			fd="감자";
		if(column==null)
			column="name";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		map.put("fd", fd);
		map.put("column", column);
		map.put("start", (curpage*12)-(11));
		map.put("end", curpage*12);
		
		List<FoodVO> list=service.foodFindData(map);
		int totalpage=service.foodFindTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("fd", fd);
		model.addAttribute("column", column);
		
		return "food/find";
	}
}
