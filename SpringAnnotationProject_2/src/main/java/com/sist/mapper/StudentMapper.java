package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
	// insert
	@SelectKey(keyProperty = "hakbun",resultType = int.class, before = true, 
			statement = "SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student")
	@Insert("INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	// select
	@Select("SELECT * FROM student ORDER BY hakbun")
	public List<StudentVO> studentListData();
	// update
	@Update("UPDATE student SET "
			+"kor=#{kor},eng=#{eng},math=#{math} "
			+ "WHERE hakbun=#{hakbun}")
	public void studentUpdateData(StudentVO vo);
	// delete
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDeleteData(int hakbun);
	// select
	@Select("SELECT * FROM student WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
}
