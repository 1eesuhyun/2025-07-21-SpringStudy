package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class MyDAO {
	/*
	 *  1.AOP
	 *    Before
	 *    After
	 *    After-Throwing
	 *    After-Returning
	 *    Around
	 *    
	 *    public String display()
	 *    {
	 *    	String res""
	 *    	=> Before
	 *    	try
	 *    	{
	 *    		---------------- setAutoCommit(false) Around => 커밋을 동시에 할 수 있게
	 *    		 코딩
	 *    		---------------- commit()
	 *    	}catch(Exception ex)
	 *    	{
	 *    		=> After-Throwing	
	 *    	}
	 *    	finally
	 *    	{
	 *    		=> After
	 *    	}
	 *    	return res; => After-Returning
	 *    }
	 */
	/*
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	public void disConnection()
	{
		System.out.println("오라클 연결 해제");
	}
	*/
	public void select()
	{
		//getConnection();
		System.out.println("데이터 읽기");
		//disConnection();
	}
	public void insert()
	{
		//getConnection(); // before
		System.out.println("데이터 추가");
		//disConnection(); // after
	}
	public void update()
	{
		//getConnection();
		System.out.println("데이터 수정");
		//disConnection();
	}
	public void delete()
	{
		//getConnection();
		System.out.println("데이터 삭제");
		//disConnection();
	}
}
