package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rdao;

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rdao.recipeListData(start, end);
	}

	@Override
	public int recipeCount() {
		// TODO Auto-generated method stub
		return rdao.recipeCount();
	}
	
}
