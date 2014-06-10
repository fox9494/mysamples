package com.soarsky.octopus.manager.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.service.TModelInfoService;
import com.soarsky.octopus.manager.service.TRightInfoService;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.manager.vo.TransModelBean;
import com.soarsky.octopus.mapping.TModelInfo;
import com.soarsky.octopus.mapping.TRightInfo;
import com.soarsky.octopus.mapping.TRoleInfo;

public class RightEditAction extends BaseAction {
	
	private TModelInfoService tModelInfoService;
	
	private TRoleInfoService tRoleInfoService;
	
	private TRightInfoService tRightInfoService;
	
	private Long id;
	
	private TRoleInfo  role;
	
	private List<TransModelBean>  modelList;
	
	private String[] model;
	
	

	/**
	 * 初始化角色权限
	 * @return
	 */
	public String input(){
		role = tRoleInfoService.findRole(id);
		modelList = tModelInfoService.queryThirdLevelMenu();  
		return INPUT;
	}
	
	public String edit(){
		tRightInfoService.editRight(role.getId(), model);
		return SUCCESS;
	
	}
	
	/**
	 * 查询角色权限
	 * @return
	 */
	public String queryRight(){
		role = tRoleInfoService.findRole(id);
		modelList = tModelInfoService.queryThirdLevelMenu();  
		return "query";
	}
	
	

	public TModelInfoService gettModelInfoService() {
		return tModelInfoService;
	}

	public void settModelInfoService(TModelInfoService tModelInfoService) {
		this.tModelInfoService = tModelInfoService;
	}

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TRoleInfo getRole() {
		return role;
	}


	public void setRole(TRoleInfo role) {
		this.role = role;
	}


	public List<TransModelBean> getModelList() {
		return modelList;
	}


	public void setModelList(List<TransModelBean> modelList) {
		this.modelList = modelList;
	}





	public String[] getModel() {
		return model;
	}





	public void setModel(String[] model) {
		this.model = model;
	}

	public TRightInfoService gettRightInfoService() {
		return tRightInfoService;
	}

	public void settRightInfoService(TRightInfoService tRightInfoService) {
		this.tRightInfoService = tRightInfoService;
	}


}
