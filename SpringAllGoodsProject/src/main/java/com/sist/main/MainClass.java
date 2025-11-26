package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.mapper.*;
import com.sist.service.GoodsService;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		Scanner scan=new Scanner(System.in);
		System.out.print("검색 할 상품 입력(1.상품명,2.내용,3.가격):");
		String column="";
		int cate=scan.nextInt();
		String[] strColumn= {"","goods_name","goods_sub","goods_price"};
		System.out.print("검색어 입력:");
		String ss=scan.next();
		Map map=new HashMap();
		map.put("column", strColumn[cate]);
		map.put("ss", ss);
		
		GoodsService gs=(GoodsService)app.getBean("goods");
		int count=gs.goodsFindCount(map);
		List<GoodsVO> list=gs.goodsFindData(map);
		System.out.println("검색 결과:"+count+"건");
		for(GoodsVO vo:list)
		{
			System.out.println(vo.getGoods_name()+" "+vo.getGoods_price()+" "+vo.getGoods_sub());
		}
		
	}

}
