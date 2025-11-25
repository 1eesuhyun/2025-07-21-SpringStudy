package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.service.EmpService;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Component("mc") // map.put("mc",new MainClass()) => Object getBean("mc") 쓰면 new MainClass()가 리턴
public class MainClass {
	@Autowired
	private EmpService service;
	public static void main(String[] args) {
		// 사용자정의 클래스, 라이브러리 클래스를 관리하는 클래스 => 컨테이너(Container)
		// 등록된 모든 클래스를 Map에 저장
		// 패키지 단위 / 한개 클래스
		              // => <bean>
		// => 사용자 정의 클래스
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		MainClass mc=app.getBean("mc",MainClass.class);
		List<EmpVO> elist=mc.service.empListdata();
		List<DeptVO> dlist=mc.service.deptListData();
		//EmpVO vo=mc.service.empDetailData(7788);
		
		System.out.println("======= 부서 정보");
		for(DeptVO dvo:dlist)
		{
			System.out.println(dvo.getDeptno()+" "+dvo.getDname()+" "+dvo.getLoc());
		}
		System.out.println("=========== 사원 정보");
		for(EmpVO evo:elist)
		{
			System.out.println(evo.getEname()+" "+evo.getJob()+" "+evo.getDbday()+" "+evo.getSal()+" "+evo.getEmpno());
		}
		Scanner scan=new Scanner(System.in);
		System.out.print("사번 입력:");
		int empno=scan.nextInt();
		EmpVO vo=mc.service.empDetailData(empno);
		System.out.println("사번:"+vo.getEmpno());
		System.out.println("이름:"+vo.getEname());
		System.out.println("직위:"+vo.getJob());
		System.out.println("부서명:"+vo.getDvo().getDname());
		System.out.println("근무지:"+vo.getDvo().getLoc());
	}
}
