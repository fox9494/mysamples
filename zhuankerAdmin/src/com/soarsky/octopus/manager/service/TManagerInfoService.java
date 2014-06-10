package com.soarsky.octopus.manager.service;

import java.util.List;
import java.util.Set;

import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TModelInfo;
import com.soarsky.octopus.utils.PageBean;

public interface TManagerInfoService {
	
	/**
	 * 用户登录验证
	 * @param userName  用户名
	 * @param password  MD5加密的密码
	 * @return
	 */
	public TManagerInfo login(String userName, String password);
	
	
	
	/**
	 * 得到用户的导航菜单
	 * @param uid
	 * @return
	 */
	public List<TModelInfo> getAdminUserMenus(Long uid);
	
	
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public PageBean queryListPage(int pageSize,int currentPage);
	
	/**
	 * 保存
	 * @param manager
	 */
	public void save(TManagerInfo manager);
	
	
	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public TManagerInfo findManager(Long id);
	
	
	/**
	 * 修改
	 * @param manager
	 */
	public void editManager(TManagerInfo manager);
	
	
	/**
	 * 执行逻辑删除
	 * @param ids
	 */
	public void deleteManagers(String ids);
	
	/**
	 * 验证用户是否具有该权限
	 * @param uid  用户ID
	 * @param code  权限码
	 * @return
	 */
	public boolean validateRight(Long uid,String code);
	
	
	/**
	 * 验证用户是否具有该url权限
	 * @param uid  用户ID
	 * @param url  请求地址
	 * @return
	 */
	public boolean validateRightByUrl(Long uid,String url);
	
	
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	public void initPassword(String ids);
	
	/**
	 * 修改密码
	 * @param manager
	 */
	public int editPass(String password,Long id);
	
	/**
	 * 判断是否有重复的用户名
	 */
	public boolean judgeUserName(String userName);
	
	/**
	 * 判断用户下是否有渠道存在
	 */
	public boolean judgeMgrChannel(String ids);

}
