package com.sist.service;
import java.util.*;

import com.sist.vo.FoodVO;
public interface FoodService {
	public List<FoodVO> foodListData(int start,int end);
	
	public int foodTotalPage();
	
	public List<FoodVO> foodFindData(Map map);
	
	public int foodFindTotalPage(Map map);
	
}
