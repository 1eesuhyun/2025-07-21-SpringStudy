package com.sist.service;

import java.util.*;
import com.sist.vo.*;
/*
 * 	Ŭ���̾�Ʈ == Service == DAO == ����Ŭ
 *                         |
 *                        ����
 */
public interface FoodService {
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	public FoodVO foodCookieData(int fno);
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(String address);
	public List<FoodVO> foodTypeData(Map map);
	public int foodTypeTotalPage(String type);
	
	
}
