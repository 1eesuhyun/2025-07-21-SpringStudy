package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,content,num "
			+ "FROM(SELECT fno,name,poster,content,rownum as num "
			+ "FROM(SELECT fno,name,poster,content "
			+ "FROM menupan_food "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start")int start,@Param("end")int end);
	
	@Select("SELECT CEIL (COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,poster,content,num "
			+ "FROM(SELECT fno,name,poster,content,rownum as num "
			+ "FROM(SELECT fno,name,poster,content "
			+ "FROM menupan_food "
			+ "AND ${column} LIKE '%'||#{fd}||'%'"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
}
