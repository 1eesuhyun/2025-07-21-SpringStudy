package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	/*
	 * @Select("FROM no,title,chef "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE '%'||#{rs}||'%'")
	public List<RecipeVO> recipeFindData(Map map);
	@Select("FROM COUNT(*) "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE '%'||#{rs}||'%'")
	public List<RecipeVO> recipeFindCount(Map map);
	 */
	public List<RecipeVO> recipeFindData(Map map)
	{
		return mapper.recipeFindData(map);
	}
	public int recipeFindCount(Map map)
	{
		return mapper.recipeFindCount(map);
	}
}
