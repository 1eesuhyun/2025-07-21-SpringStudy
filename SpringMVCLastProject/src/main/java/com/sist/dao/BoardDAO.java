package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	/*
	 * @Update("UPDATE springboard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM springboard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	 */
	public BoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	/*
	 * @Select("SELECT pwd FROm springboard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Delete("DELETE FROM springboard WHERE no=#{no}")
	public void boardDelete(int no);
	 */
	public String boardGetPassword(int no)
	{
		return mapper.boardGetPassword(no);
	}
	public void boardDelete(int no)
	{
		mapper.boardDelete(no);
	}
	/*
	 * @Update("UPDATE springboard SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	@Select("SELECT no,name,subject,content "
			+ "FROM springboard "
			+ "WHERE no=#{no}")
	public BoardVO boardUpdateData(int no);
	 */
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardUpdateData(no);
	}
	public void boardUpdate(BoardVO vo)
	{
		mapper.boardUpdate(vo);
	}
}
