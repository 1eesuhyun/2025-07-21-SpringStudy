package com.sist.web;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// RestFul : 다른 프로그램과 연동(JavaScript)
// @GetMapping(SELECT) / @PostMapping(INSERT) / @PutMapping(UPDATE) / @DeleteMapping(DELETE)
// => web : @GetMapping(SELECT) / @PostMapping(INSERT)
// @RequestMapping(통합)
@CrossOrigin(origins="*")
public class GoodsAllRestController {
	@Autowired
	private GoodsAllService gservice;
	
	@GetMapping(value="goods/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String goods_list_vue(int page)
	   {
		   int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   List<GoodsAllVO> list=gservice.goodsAllListData(start, end);
		   int totalpage=gservice.goodsAllTotalPage();
		   
		   final int BLOCK=10;
		   int startPage=((page-1)/BLOCK*BLOCK)+1;
		   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		   
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   Map map=new HashMap();
		   map.put("list", list);
		   map.put("curpage", page);
		   map.put("startPage", startPage);
		   map.put("endPage", endPage);
		   map.put("totalpage", totalpage);
		   
		   // {curpage:1,totalpage:20...list:[{},{},{}]}
		   String json="";
		   try
		   {
			   ObjectMapper mapper=new ObjectMapper();
			   json=mapper.writeValueAsString(map);
		   }catch(Exception ex) {}
		   
		   return json;
	   }
	@GetMapping(value="goods/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String goods_detail_vue(int no)
	{
		GoodsAllVO vo=gservice.goodsAllDetailData(no);
		String strPrice=vo.getGoods_price();
		strPrice=strPrice.replaceAll("[^0-9]", "");
		vo.setPrice(Integer.parseInt(strPrice));
		
		String json="";
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			json=mapper.writeValueAsString(vo);
		}catch(Exception ex) {}
		return json;
	}
}
