package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Service("goods")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAO gDao;

	@Override
	public List<GoodsVO> goodsFindData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsFindData(map);
	}
	@Override
	public int goodsFindCount(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsFindCount(map);
	}
	
}
