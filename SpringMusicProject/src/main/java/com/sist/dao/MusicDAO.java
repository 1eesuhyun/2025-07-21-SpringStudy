package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MusicMapper;
import com.sist.vo.MusicVO;

@Repository
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
/*
 * @Select("SELECT no,title,singer,album "
			+ "FROM genie_music "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<MusicVO> MusicFindData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM genie_music "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int MusicFindCount(Map map);
 */
	public List<MusicVO> MusicFindData(Map map)
	{
		return mapper.MusicFindData(map);
	}
	public int MusicFindCount(Map map)
	{
		return mapper.MusicFindCount(map);
	}
}
