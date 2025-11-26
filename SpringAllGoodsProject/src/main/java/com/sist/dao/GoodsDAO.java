package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	/*
	 * @Select("SELECT no,goods_name,goods_subject,goods_price "
			+ "FROM goods_all "
			+ "WHERE ${column} '%'||#{ss}||'%'")
	public List<GoodsVO> goodsFindData(Map map);
	@Select("SELECT COUNT(*) "
			+ "FROM goods_all "
			+ "WHERE ${column} '%'||#{ss}||'%'")
	public int goodsFindCount(Map map);
	 */
	public List<GoodsVO> goodsFindData(Map map)
	{
		return mapper.goodsFindData(map);
	}
	public int goodsFindCount(Map map)
	{
		return mapper.goodsFindCount(map);
	}
}
