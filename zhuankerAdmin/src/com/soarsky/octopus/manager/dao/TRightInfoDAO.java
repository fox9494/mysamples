package com.soarsky.octopus.manager.dao;

import java.util.HashMap;
import java.util.Map;

import com.soarsky.octopus.common.dao.BaseDAO;


public class TRightInfoDAO extends BaseDAO  {
	

	/**
	 * 根据角色删除
	 * @param roleId
	 */
	public void deleteByRole(Long roleId){
		String sql = "delete from t_right_info where role_id=:roleId";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		this.executeBySql(sql, params);
	}
	
	
	public void insertRight(Long roleId,Long modelId){
		
		String sql = "insert into t_right_info(role_id,model_id) values(:roleId,:modelId)";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		params.put("modelId", modelId);
		this.executeBySql(sql, params);
		
	}
	
	
	
}