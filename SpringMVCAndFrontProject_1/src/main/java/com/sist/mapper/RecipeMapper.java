package com.sist.mapper;
// 메소드 선언 => 자동 구현(SQL) => JPA
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

public interface RecipeMapper {
	@Select("SELECT no,title,poster,chef,num "
			+ "FROM(SELECT no,title,poster,chef,rownum as num "
			+ "FROM(SELECT no,title,poster,chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT "
			+ "SELECT no FROM recipeDetail) "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	// 두 쿼리의 공통 부분만 가지고 오는 쿼리문 INTERSECT(공통값만 가지고오는 연산자)
	public List<RecipeVO> recipeListData(@Param("start")int start,@Param("end")int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT "
			+ "SELECT no FROM recipeDetail) ")
	public int recipeTotalPage();
	// => openSession(true) / session.close(), session.commit()
	// 1. return형, 2. 매개변수
	
	//@Select("SELECT no,poster,title,chef,chef_poster,chef_profile,info1,info2,info3,content,foodmake "
	//		+ "FROM recipedetail WHERE no=#{no}")
	//public RecipeDetailVO recipeDetailData(int no);
	
	@Update("UPDATE recipe SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public int hitIncrement(int no);
	
	@Select("SELECT no,title,poster,chef,num "
			+ "FROM(SELECT no,title,poster,chef,rownum as num "
			+ "FROM(SELECT no,title,poster,chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT "
			+ "SELECT no FROM recipeDetail) "
			+ "AND ${column} LIKE '%'||#{fd}||'%' "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT "
			+ "SELECT no FROM recipeDetail) AND ${column} LIKE '%'||#{fd}||'%'")
	public int recipeFindTotalPage(Map map);
}
