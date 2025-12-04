package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("main/main.do")
	public String main_main(Model model)
	{
		// Model => ������ ����(HttpServletRequest�� ��ü)
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main"; // main/main.jsp
	} 
	
}
