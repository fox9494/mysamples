package com.institute.meeting.adminuser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;

import com.institute.meeting.adminuser.entity.TAdminRight;
import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.adminuser.service.AdminRightService;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.service.ModelService;
import com.institute.meeting.common.action.BaseAction;
import com.institute.meeting.common.entity.TreeModel;

public class AdminRoleAddAction extends BaseAction {
	
	private static final long serialVersionUID = -1562408777273473400L;

	private AdminRoleService adminRoleService;
	
	private List<TModel>   modelList;
	
	private ModelService  modelService;
	
	private AdminRightService adminRightService;
	
	private Integer roleId;
	
	private TAdminRole role;
	
	private String[] model;
	
	private JSONArray treeJson;
	
	/**
	 * 初始化角色
	 * @return
	 */
	public String initAddRole(){
		List<TreeModel> treeList = modelService.findAllModelForTree();
		treeJson = JSONArray.fromObject(treeList);
		return INPUT;
	}
	
	/**
	 * 编辑角色
	 * @return
	 */
	public String editRole(){
		List<TAdminRight> rightList = new ArrayList<TAdminRight>();
		Map<Integer, TModel> map = modelService.queryAllForMap();
		for (int i = 0; i < model.length; i++) {
			String[] composeId = model[i].split("-");
			String modelId = composeId[0];
			String rightId = "";
			if (composeId.length>1){
				rightId = composeId[1];
			}
			
			TAdminRight right = new TAdminRight();
			right.setRightId(StringUtils.isBlank(rightId)?null:Integer.valueOf(rightId));
			right.setRole(role);
			right.setModel(map.get(Integer.valueOf(modelId)));
			
			//根据modelId查询二级导航菜单，将其设置成具有权限，此项目只有1级权限设置，故需将根据1级权限将二级菜单权限全部设上
			Set<TModel> childSet = map.get(Integer.valueOf(modelId)).getModelSet();
			if (childSet!=null){
				for (TModel model : childSet) {
					TAdminRight childRight = new TAdminRight();
					childRight.setRole(role);
					childRight.setModel(model);
					rightList.add(childRight);
				}
			}
			
			rightList.add(right);
			
		}
		
		adminRightService.updateRight(role.getRoleId(), rightList);		
		
		return SUCCESS;
	}

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public List<TModel> getModelList() {
		return modelList;
	}

	public void setModelList(List<TModel> modelList) {
		this.modelList = modelList;
	}

	public ModelService getModelService() {
		return modelService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public TAdminRole getRole() {
		return role;
	}

	public void setRole(TAdminRole role) {
		
		this.role = role;
	}

	public String[] getModel() {
		return model;
	}

	public void setModel(String[] model) {
		this.model = model;
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


}
