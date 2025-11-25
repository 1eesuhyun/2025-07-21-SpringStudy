package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;
@Service
public class RecipeImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;
	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeFindData(map);
	}

	@Override
	public int recipeFindCount(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeFindCount(map);
	}
	
}
