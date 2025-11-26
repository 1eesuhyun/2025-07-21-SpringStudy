package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class FoodVO {
	private int fno,hit;
	private String name,type,phone,address,content,theme,parking,images,dbday;
	private Date regdate;
}
