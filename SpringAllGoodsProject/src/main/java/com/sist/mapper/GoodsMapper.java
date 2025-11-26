package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_sub,goods_price "
			+ "FROM goods_all "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<GoodsVO> goodsFindData(Map map);
	@Select("SELECT COUNT(*) "
			+ "FROM goods_all "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int goodsFindCount(Map map);
}
