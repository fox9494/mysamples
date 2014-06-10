package com.soarsky.octopus.clientuser.service.impl;

import java.util.Date;

import com.soarsky.octopus.clientuser.dao.TSuggectionDAO;
import com.soarsky.octopus.clientuser.service.TSuggectionService;
import com.soarsky.octopus.mapping.TSuggection;
import com.soarsky.octopus.utils.PageBean;

public class TSuggectionServiceImpl implements TSuggectionService {
	
	private TSuggectionDAO tSuggectionDAO;
	
	/**
	 * 分页查询所有反馈信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentpage 当前页数
	 * @return
	*/
	public PageBean getSuggectionList(int maxresult, int currentpage) {
		
		return tSuggectionDAO.findAllSuggection(maxresult,currentpage);
	}
    
	
	/**
	 * 根据条件查找反馈信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentpage 当前页数
	 * @param  suggection  反馈信息对象
	 * @return
	*/
	public PageBean getSuggectionByConditions(int maxresult, int currentpage,TSuggection suggection,Date startDate,Date endDate) {
		
		return tSuggectionDAO.findSuggectionsByConditon(maxresult,currentpage,suggection,startDate,endDate);
	}



	public TSuggectionDAO gettSuggectionDAO() {
		return tSuggectionDAO;
	}

	public void settSuggectionDAO(TSuggectionDAO tSuggectionDAO) {
		this.tSuggectionDAO = tSuggectionDAO;
	}

}
