package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired
	private FoodDAO fdao;
	
	@GetMapping("list.do")
	public String food_list(String page,Model model)
	{
		return "";
	}
}
