package com.sist.web;
import com.sist.service.*;
import java.util.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsAllController {
	@Autowired
	private GoodsAllService gservice;
	
	@GetMapping("goods/list.do")
	   public String goods_list(Model model) // route
	   {
		   model.addAttribute("main_jsp", "../goods/list.jsp");
		   return "main/main";
	   }
	@GetMapping("goods/detail.do")
	public String goods_detail(int no,Model model)
	{
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		return "main/main";
	}
}