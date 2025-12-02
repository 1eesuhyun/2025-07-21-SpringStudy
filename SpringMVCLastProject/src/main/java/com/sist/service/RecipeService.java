package com.sist.service;

import java.util.*;
import com.sist.vo.*;

public interface RecipeService {
	public List<RecipeVO> recipeListData(int start,int end);
	
	public int recipeCount();
	
}
