package com.soarsky.octopus.clientuser.action;

import java.util.List;
import java.util.Map;

import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.action.BaseAction;

public class TAreaListAction extends BaseAction {
	
	private static final long serialVersionUID = -9001092295762086081L;
	
	private TAreaService tAreaService;
	
	private Map<String,Object> resultMap;
	
	private String res;
	
	private List<TreeData> resultList;
	
	private List<TreeData>areaList;
	
	private Long parentId;
	
	/**
	 * 根据parentId查询的区域集合
	 * 
	 */
	
	public String areaList(){
		
	    resultList=tAreaService.findArea(); 
	    
		return SUCCESS;
	}
	
	/**
     * 初始化用户注册管理区域
     * @author lw
     * @return
    */
    public String initUserArea(){
    	
    	areaList=tAreaService.initArea();
    	
    	return "initsuccess";
    }
    
    /**
	 * 根据parentId查找区域
	 * @author lw
	 * @return
    */
    public String getAreaById(){
    	
    	areaList=tAreaService.findAreaById(parentId);
    	
        return "findsuccess";   	
    }
    
	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public String getRes() {
		return res;
	}
	

	public void setRes(String res) {
		this.res = res;
	}



	public List<TreeData> getResultList() {
		return resultList;
	}



	public void setResultList(List<TreeData> resultList) {
		this.resultList = resultList;
	}
	

	public List<TreeData> getAreaList() {
		return areaList;
	}
	

	public void setAreaList(List<TreeData> areaList) {
		this.areaList = areaList;
	}
	

	public Long getParentId() {
		return parentId;
	}
	

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
}
