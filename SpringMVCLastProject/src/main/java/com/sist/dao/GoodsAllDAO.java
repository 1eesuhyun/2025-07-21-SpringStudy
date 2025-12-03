package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsAllDAO {
	@Autowired
	private GoodsAllMapper mapper;
	/*
	 * @Select("SELECT no,goods_poster,goods_name,goods_price,num "
			+ "FROM(SELECT no,goods_poster,goods_name,goods_price,rownum as num "
			+ "FROM(SELECT no,goods_poster,goods_name,goods_price "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsAllVO> goodsAllListData(@Param("start")int start,@Param("end")int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsAllTotalPage();
	
	@Select("SELECT * FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsAllVO goodsAllDetailData(int no);
	 */
	public List<GoodsAllVO> goodsAllListData(int start,int end)
	{
		return mapper.goodsAllListData(start, end);
	}
	public int goodsAllTotalPage()
	{
		return mapper.goodsAllTotalPage();
	}
	public GoodsAllVO goodsAllDetailData(int no)
	{
		return mapper.goodsAllDetailData(no);
	}
}
