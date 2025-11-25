package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.MusicVO;

public interface MusicService {
	public List<MusicVO> MusicFindData(Map map);
	public int MusicFindCount(Map map);
	
}
