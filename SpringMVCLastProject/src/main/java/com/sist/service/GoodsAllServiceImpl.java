package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GoodsAllDAO;
import com.sist.vo.GoodsAllVO;

@Service
public class GoodsAllServiceImpl implements GoodsAllService{
	@Autowired
	private GoodsAllDAO gdao;

	@Override
	public List<GoodsAllVO> goodsAllListData(int start, int end) {
		// TODO Auto-generated method stub
		return gdao.goodsAllListData(start, end);
	}

	@Override
	public int goodsAllTotalPage() {
		// TODO Auto-generated method stub
		return gdao.goodsAllTotalPage();
	}

	@Override
	public GoodsAllVO goodsAllDetailData(int no) {
		// TODO Auto-generated method stub
		return gdao.goodsAllDetailData(no);
	}
}
