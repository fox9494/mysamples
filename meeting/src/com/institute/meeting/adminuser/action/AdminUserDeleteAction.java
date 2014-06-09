package com.institute.meeting.adminuser.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.adminuser.service.AdminUserService;
import com.institute.meeting.common.action.BaseAction;

public class AdminUserDeleteAction extends BaseAction {
	
	private int userId;
	
	private AdminUserService adminUserService;
	
	private Map<String, Object> map;
	
	public String deleteAdminUser(){
		String username=(String)ServletActionContext.getRequest().getSession().getAttribute("username");
	    TAdminusers user=adminUserService.findByAdminUser(userId);
	    if(username.equals(user.getUserAccount())){
	    	map = new HashMap<String,Object>();
	    	map.put("flag",false);
	    	map.put("msg","此用户处于登录状态，不能删除");
	    }else{
	       map = new HashMap<String,Object>();
	       this.adminUserService.deleteAdminUser(userId);
	       map.put("flag",true);
	       map.put("msg","删除成功");
	    }
	    return SUCCESS;
	}
	public void validateDeleteAdminUser(){
		
	    
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
