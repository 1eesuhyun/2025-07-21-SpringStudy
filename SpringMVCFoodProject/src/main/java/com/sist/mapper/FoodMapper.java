package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,hit,name,type,phone,address,content,theme,parking,images,TO_CHAR(regdate,'YYYY-MM-DD') AS dbday "
			+ "FROM(SELECT fno,hit,name,type,phone,address,content,theme,parking,images,ROWNUM AS num "
			+ "FROM(SELECT fno,hit,name,type,phone,address,content,theme,parking,images "
			+ "FROM menupan_food ORDER BY fno DESC)) "
			+ "WHERE num BETWEE #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/10.0 FROM menupan_food")
	public int foodTotalPage();
	
}
