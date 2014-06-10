package com.soarsky.octopus.clientuser.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soarsky.octopus.clientuser.constant.TAreaErrorMsg;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TArea;

public class TAreaEditAction extends BaseAction {
	
	private Long id;
	
	private String statename;
	
	private TAreaService tAreaService;
	
	private Map<String,Object> resultMap;
	
	/**
	 * 编辑区域
	 * @return
	 */
	public 	String editArea(){
		
		//对statename进行转码
		try {
			 statename=java.net.URLDecoder.decode(statename,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		this.tAreaService.editArea(id, statename);
		
		return SUCCESS;
	}
	
	/**
	 * 判断区域名是否重复
	 * @return
	 */
	public String judgeName(){
		resultMap=new HashMap<String,Object>();
		try {
			statename=java.net.URLDecoder.decode(statename,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		List<TArea> tAreaList=this.tAreaService.findLevelArea(id);
		if(tAreaList.size()!=JEEContant.NOTROMOVE){
		for(TArea tarea :tAreaList){
			//存在相同的区域名
			if(tarea.getStatename().equals(statename)){
				resultMap.put("judgeName", TAreaErrorMsg.EXISTNAME);
				break ;
			}
			else
			{
				resultMap.put("judgeName", TAreaErrorMsg.NOTEXISTNAME);
				
			}
		  }
		}
		else{
			
			resultMap.put("judgeName", TAreaErrorMsg.NOTEXISTNAME);
		}
	
		    return "judgeName";
		
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatename() {
		return statename;
	}
	
	public void setStatename(String statename) {
		this.statename = statename;
	}
	
	public TAreaService gettAreaService() {
		return tAreaService;
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
	
	
	
	
	
	
	
	
	
	

}
