package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	/*
	 * @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM(SELECT no,subject,name,hit,rownum as num "
			+ "FROM(SELECT no,subject,name,hit "
			+ "FROM springboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start")int start,@Param("end")int end);
	
	@Select("SELECT COUNT(*) FROM springboard")
	public int boardTotalPage();
	 */
	public List<BoardVO> boardListData(int start,int end)
	{
		return mapper.boardListData(start, end);
	}
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
}
