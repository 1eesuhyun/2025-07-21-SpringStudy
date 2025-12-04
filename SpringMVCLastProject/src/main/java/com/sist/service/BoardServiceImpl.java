package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bdao;

	@Override
	public List<BoardVO> boardListData(int start, int end) {
		// TODO Auto-generated method stub
		return bdao.boardListData(start, end);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return bdao.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bdao.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return bdao.boardDetailData(no);
	}

	@Override
	public String boardDelete(int no,String pwd) {
		// TODO Auto-generated method stub
		String result="no";
		String db_pwd=bdao.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			result="yes";
			bdao.boardDelete(no);
		}
		return result;
	}

	@Override
	public BoardVO boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return bdao.boardUpdateData(no);
	}

	@Override
	public String boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		String result="no";
		String db_pwd=bdao.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result="yes";
			bdao.boardUpdate(vo);
		}
		return result;
	}
}
