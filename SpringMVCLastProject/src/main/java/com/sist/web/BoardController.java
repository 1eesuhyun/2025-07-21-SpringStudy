package com.sist.web;
import com.sist.vo.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.BoardService;
@Controller
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("board/list.do")
	public String board_list(Model model)
	{
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
	@GetMapping("board/insert.do")
	public String board_insert(Model model)
	{
		model.addAttribute("main_jsp", "../board/insert.jsp");
		return "main/main";
	}
}