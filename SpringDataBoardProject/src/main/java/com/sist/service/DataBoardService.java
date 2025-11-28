package com.sist.service;

import java.util.List;

import com.sist.vo.DataBoardVO;

public interface DataBoardService {
	public List<DataBoardVO> dataBoardList(int start);
	
	public void dataBoardInsert(DataBoardVO vo);
	
	public int dataBoardRowCount();
	
	public DataBoardVO dataBoardDetailData(int no);
	
	public DataBoardVO dataBoardFileInfoData(int no);
	
	public String dataBoardGetPassword(int no);
	
	public boolean dataBoardDelete(int no,String pwd);
	
	public DataBoardVO dataBoardUpdateData(int no);
	
	public boolean dataBoardUpdate(DataBoardVO vo);
	
}
