package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;
public interface BoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM(SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM(SELECT no,subject,name,regdate,hit "
			+ "FROM springboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start")int start,@Param("end")int end);
	
	@Select("SELECT COUNT(*) FROM springboard")
	public int boardTotalPage();
	
	@Insert("INSERT INTO springboard VALUES( "
			+ "sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	// 디테일
	@Update("UPDATE springboard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM springboard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	// 수정
	@Update("UPDATE springboard SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	@Select("SELECT no,name,subject,content "
			+ "FROM springboard "
			+ "WHERE no=#{no}")
	public BoardVO boardUpdateData(int no);
	// 삭제
	@Select("SELECT pwd FROm springboard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Delete("DELETE FROM springboard WHERE no=#{no}")
	public void boardDelete(int no);
}
