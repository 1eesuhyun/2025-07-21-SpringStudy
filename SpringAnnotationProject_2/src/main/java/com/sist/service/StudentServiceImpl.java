package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.StudentDAO;
import com.sist.vo.StudentVO;
@Service("service")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO sDao;

	@Override
	public void studentInsert(StudentVO vo) {
		// TODO Auto-generated method stub
		sDao.studentInsert(vo);
	}

	@Override
	public List<StudentVO> studentListData() {
		// TODO Auto-generated method stub
		return sDao.studentListData();
	}

	@Override
	public void studentUpdateData(StudentVO vo) {
		// TODO Auto-generated method stub
		sDao.studentUpdateData(vo);
	}

	@Override
	public StudentVO studentDetailData(int hakbun) {
		// TODO Auto-generated method stub
		return sDao.studentDetailData(hakbun);
	}

	@Override
	public void studentDeleteData(int hakbun) {
		// TODO Auto-generated method stub
		sDao.studentDeleteData(hakbun);
	}
	
	
	
}
