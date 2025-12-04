package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mdao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		String enPwd=encoder.encode(vo.getUserpwd());
		vo.setUserpwd(enPwd);
		mdao.memberInsert(vo);
	}
}
