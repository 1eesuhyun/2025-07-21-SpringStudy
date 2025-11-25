package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.service.MusicService;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		Scanner scan=new Scanner(System.in);
		System.out.print("검색 할 노래 선택(1.제목,2.가수,3.앨범):");
		String column="";
		int cate=scan.nextInt();
        String[] strColumn= {"","title","singer","album"};
		System.out.print("검색어 입력:"); 
		String ss=scan.next();
		Map map=new HashMap();
		map.put("column", strColumn[cate]);
		map.put("ss", ss);
		
		MusicService ms=(MusicService)app.getBean("musicServiceImpl");
		int count=ms.MusicFindCount(map);
		List<MusicVO> list=ms.MusicFindData(map);
		System.out.println("검색 결과:"+count+"건");
		for(MusicVO vo:list)
		{
			System.out.println(vo.getNo()+" "+vo.getTitle()+" "+vo.getSinger()+" "+vo.getAlbum());
		}
	}
}
