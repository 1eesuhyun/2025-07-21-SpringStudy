package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.MusicDAO;
import com.sist.vo.MusicVO;

@Service
public class MusicServiceImpl implements MusicService{
	@Autowired
	private MusicDAO mDAO;
	
	@Override
	public List<MusicVO> MusicFindData(Map map) {
		// TODO Auto-generated method stub
		return mDAO.MusicFindData(map);
	}

	@Override
	public int MusicFindCount(Map map) {
		// TODO Auto-generated method stub
		return mDAO.MusicFindCount(map);
	}

}
