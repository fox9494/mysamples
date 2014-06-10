package com.soarsky.octopus.manager.service;

public interface TRightInfoService {
	
	
	/**
	 * 编辑角色权限
	 * 先删除后插入
	 * @param roleId
	 * @param models   模块id数组
	 */
	public void editRight(Long roleId,String[] models);

}
