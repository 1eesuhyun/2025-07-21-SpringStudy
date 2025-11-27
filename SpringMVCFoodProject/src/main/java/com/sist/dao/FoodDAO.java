package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	FoodMapper mapper;
	/*
	 * @Select("SELECT fno,hit,name,type,phone,address,content,theme,parking,images,TO_CHAR(regdate,'YYYY-MM-DD') AS dbday "
			+ "FROM(SELECT fno,hit,name,type,phone,address,content,theme,parking,images,ROWNUM AS num "
			+ "FROM(SELECT fno,hit,name,type,phone,address,content,theme,parking,images "
			+ "FROM menupan_food ORDER BY fno DESC)) "
			+ "WHERE num BETWEE #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/10.0 FROM menupan_food")
	public int foddTotalPage();
	 */
	public List<FoodVO> foodListData(int start,int end)
	{
		return mapper.foodListData(start, end);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	public int foodFindTotalPage(Map map)
	{
		return mapper.foodFindTotalPage(map);
	}
}
