package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO dao;
	
	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.recipeListData(start, end);
	}

	//@Override
	//public RecipeDetailVO reciptDetailData(int no) {
		// TODO Auto-generated method stub
	//	return dao.reciptDetailData(no);
	//}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return dao.recipeTotalPage();
	}

	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindTotalPage(map);
	}

}
