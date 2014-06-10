package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.dao.TManagerInfoDAO;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.utils.MD5Util;

/**
 * 初始化用户密码
 * @author chenll
 *
 */
public class ManagerPassAction extends BaseAction {
	
	private TManagerInfoService  tManagerInfoService;
	
	private String  ids;//用户id集合
	
	private String id;//用户id
	
	private String password;
	
	private TManagerInfo manager;
	
	private int result;
	
	
	/**
	 * 初始化密码
	 * @return
	 */
	public String initPass() {
		tManagerInfoService.initPassword(ids);
		return SUCCESS;
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String changePass() {
		TManagerInfo user = tManagerInfoService.findManager(Long.valueOf(id));
		if (user.getPassword().equals(password)){//密码相同则不修改
			result = TManagerInfoDAO.SUCCESS;
		}else{
			String md5Pass = MD5Util.getMD5(password);
			result = tManagerInfoService.editPass(md5Pass, Long.valueOf(id));
		}
		return SUCCESS;
	}
	
	/**
	 * 修改密码初始化
	 */
	@Override
	public String input() {
		manager = tManagerInfoService.findManager(Long.valueOf(id));
		return super.input();
	}
	
	

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TManagerInfo getManager() {
		return manager;
	}

	public void setManager(TManagerInfo manager) {
		this.manager = manager;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	

}
