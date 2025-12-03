package com.sist.service;

import java.util.List;

import com.sist.vo.GoodsAllVO;

public interface GoodsAllService {
	public List<GoodsAllVO> goodsAllListData(int start,int end);
	
	public int goodsAllTotalPage();
	
	public GoodsAllVO goodsAllDetailData(int no);
	
}
