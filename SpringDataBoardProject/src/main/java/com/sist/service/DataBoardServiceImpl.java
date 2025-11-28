package com.sist.service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBoardServiceImpl implements DataBoardService{
	@Autowired
	private DataBoardDAO dao;

	@Override
	public List<DataBoardVO> dataBoardList(int start) {
		// TODO Auto-generated method stub
		return dao.dataBoardList(start);
	}

	@Override
	public void dataBoardInsert(DataBoardVO vo) {
		// TODO Auto-generated method stub
		dao.dataBoardInsert(vo);
	}

	@Override
	public int dataBoardRowCount() {
		// TODO Auto-generated method stub
		return dao.dataBoardRowCount();
	}

	@Override
	public DataBoardVO dataBoardDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.dataBoardDetailData(no);
	}

	@Override
	public DataBoardVO dataBoardFileInfoData(int no) {
		// TODO Auto-generated method stub
		return dao.dataBoardFileInfoData(no);
	}

	@Override
	public String dataBoardGetPassword(int no) {
		// TODO Auto-generated method stub
		return dao.dataBoardGetPassword(no);
	}

	@Override
	public boolean dataBoardDelete(int no,String pwd) {
		// TODO Auto-generated method stub
		boolean bCheck=false;
		String db_pwd=dao.dataBoardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
            dao.dataBoardDelete(no);
		}
		return bCheck;
	}

	@Override
	public DataBoardVO dataBoardUpdateData(int no) {
		// TODO Auto-generated method stub
		return dao.dataBoardUpdateData(no);
	}

	@Override
	public boolean dataBoardUpdate(DataBoardVO vo) {
		// TODO Auto-generated method stub
		boolean bCheck=false;
		String db_pwd=dao.dataBoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			dao.dataBoardUpdate(vo);
		}
		return bCheck;
	}
}
