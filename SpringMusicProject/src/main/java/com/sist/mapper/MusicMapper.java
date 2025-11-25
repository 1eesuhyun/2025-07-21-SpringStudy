package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface MusicMapper {
	@Select("SELECT no,title,singer,album "
			+ "FROM genie_music "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<MusicVO> MusicFindData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM genie_music "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int MusicFindCount(Map map);
}
