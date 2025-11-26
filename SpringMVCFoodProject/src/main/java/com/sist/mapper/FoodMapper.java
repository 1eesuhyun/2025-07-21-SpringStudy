package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,type,poster "
			+ "FROM(SELECT fno,name,type,poster,ROWNUM AS num "
			+ "FROM(SELECT fno,name,type,poster "
			+ "FROM menupan_food ORDER BY fno DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
	
}
