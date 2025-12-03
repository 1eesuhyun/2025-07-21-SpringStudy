package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
}
