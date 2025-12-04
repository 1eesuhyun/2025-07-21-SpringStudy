package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService mservice;
	
	@PostMapping("member/join_vue_ok.do")
	public ResponseEntity<Map> member_join_ok(@RequestBody MemberVO vo)
	{
		Map map=new HashMap();
		try
		{
			mservice.memberInsert(vo);
			map.put("msg", "yes");
		}catch(Exception ex)
		{
			map.put("msg", "no");
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
