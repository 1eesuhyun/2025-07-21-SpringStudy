package com.sist.dao;

import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	/*
	 * @Select("SELECT no,hit,name,subject,TO_CHAR(regdate,'yyyy-mm-dd') as dbday "
			+ "FROM springDataBoard ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	public List<DataBoardVO> dataBoardList(int start);
	 */
	public List<DataBoardVO> dataBoardList(int start)
	{
		return mapper.dataBoardList(start);
	}
	/*
	 * @Insert("INSERT INTO springDataBoard VALUES("
			+ "sdb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount})")
	public void dataBoardInsert(DataBoardVO vo); // => 업로드
	 */
	public void dataBoardInsert(DataBoardVO vo)
	{
		mapper.dataBoardInsert(vo);
	}
	/*
	 * @Select("SELECT COUNT(*) FROM springDataBoard")
	   public int dataBoardRowCount();
	 */
	public int dataBoardRowCount()
	{
		return mapper.dataBoardRowCount();
	}
	/*
	 * @Update("UPDATE springDataBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT no,name,subject,content,hit,filename,filesize,filecount, "
			+ "TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
			+ "FROM springDataBoard "
			+ "WHERE no=#{no}")
	public DataBoardVO dataBoardDetailData(int no);
	 */
	public DataBoardVO dataBoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.dataBoardDetailData(no);
	}
	/*
	// 4. 수정
	// 5. 삭제(파일 제거)
	@Select("SELECT filename,filesize,filecount "
			+ "FROM springDataBoard "
			+ "WHERE no=#{no}")
	// 파일 정보
	public DataBoardVO dataBoardFileInfoData(int no);
	// 비밀번호
	@Select("SELECT pwd FROM springDataBoard "
			+ "WHERE no=#{no}")
	public String dataBoardGetPassword(int no);
	
	@Delete("DELETE FROM springDataBoard "
			+ "WHERE no=#{no}")
	public void dataBoardDelete(int no);
	 */
	public DataBoardVO dataBoardFileInfoData(int no)
	{
		return mapper.dataBoardFileInfoData(no);
	}
	public String dataBoardGetPassword(int no)
	{
		return mapper.dataBoardGetPassword(no);
	}
	public void dataBoardDelete(int no)
	{
		mapper.dataBoardDelete(no);
	}
	public DataBoardVO dataBoardUpdateData(int no)
	{
		return mapper.dataBoardDetailData(no);
	}
	public void dataBoardUpdate(DataBoardVO vo)
	{
		mapper.dataBoardUpdate(vo);
	}
}
