package com.institute.meeting.adminuser.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.service.AdminRightService;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.service.ModelService;
import com.institute.meeting.common.action.BaseAction;
import com.institute.meeting.common.entity.TreeModel;

public class AdminRoleAddAction extends BaseAction {
	
	private static final long serialVersionUID = -1562408777273473400L;

	private AdminRoleService adminRoleService;
	
	private ModelService  modelService;
	
	private AdminRightService adminRightService;
	
	private TAdminRole role;
	
	private JSONArray treeJson;
	
	//权限模块字符串
	private String moduleIds;
	
	/**
	 * 初始化角色
	 * @return
	 */
	public String initAddRole(){
		List<TreeModel> treeList = modelService.findAllModelForTree();
		treeJson = JSONArray.fromObject(treeList);
		if (StringUtils.isBlank(moduleIds)){
			moduleIds="-1";
		}
		return INPUT;
	}
	
	public String addRole(){
		if (hasValidatorErrors()){
			List<TreeModel> treeList = modelService.findAllModelForTree();
			treeJson = JSONArray.fromObject(treeList);
			return INPUT;
		}
		adminRoleService.saveRoleAndRight(role, moduleIds);
		return SUCCESS;
	}
	
	public boolean hasValidatorErrors(){
		
		
		if (!adminRoleService.validateName(role.getRoleName())){
			this.addFieldError("role.hasExist", "该角色名已被使用");
		}
		
		if (StringUtils.isBlank(moduleIds)){
			this.addFieldError("role.tree", "请选择角色权限");
		}
		
		
		return this.hasFieldErrors();
	}
	
	/**
	 * 编辑角色
	 * @return
	 */

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public ModelService getModelService() {
		return modelService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	public TAdminRole getRole() {
		return role;
	}

	public void setRole(TAdminRole role) {
		
		this.role = role;
	}


	public AdminRightService getAdminRightService() {
		return adminRightService;
	}

	public void setAdminRightService(AdminRightService adminRightService) {
		this.adminRightService = adminRightService;
	}

	public JSONArray getTreeJson() {
		return treeJson;
	}

	public void setTreeJson(JSONArray treeJson) {
		this.treeJson = treeJson;
	}

	public String getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}


}
