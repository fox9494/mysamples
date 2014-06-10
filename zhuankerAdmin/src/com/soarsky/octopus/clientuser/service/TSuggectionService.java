package com.soarsky.octopus.clientuser.service;

import java.util.Date;

import com.soarsky.octopus.mapping.TSuggection;
import com.soarsky.octopus.utils.PageBean;

public interface TSuggectionService {
     
	public PageBean getSuggectionList(int maxresult,int currentpage);
	
	public PageBean getSuggectionByConditions(int maxresult,int currentpage,TSuggection suggection,Date startDate,Date endDate);
	
}
