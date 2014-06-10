package com.soarsky.octopus.config.service;

import java.util.List;

import com.soarsky.octopus.mapping.TConfig;

public interface TConfigService {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<TConfig>  getAllConfig();
	
	/**
	 * 根据模块code查询
	 * @param code
	 * @return
	 */
	public List<TConfig> getConfigByCode(String code);
	
	/**
	 * 根据模块编码和key获取值
	 * @param code
	 * @param key
	 * @return
	 */
	public List<TConfig> getConfigByCodeKey(String code,String key);

}
