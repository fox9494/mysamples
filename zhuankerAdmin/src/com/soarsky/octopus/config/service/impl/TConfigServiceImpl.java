package com.soarsky.octopus.config.service.impl;

import java.util.List;

import com.soarsky.octopus.config.dao.TConfigDAO;
import com.soarsky.octopus.config.service.TConfigService;
import com.soarsky.octopus.mapping.TConfig;

public class TConfigServiceImpl implements TConfigService {
	
	
	private TConfigDAO  tConfigDAO;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<TConfig>  getAllConfig(){
		return tConfigDAO.findAll();
	}
	
	/**
	 * 根据模块code查询
	 * @param code
	 * @return
	 */
	public List<TConfig> getConfigByCode(String code){
		TConfig instance = new TConfig();
		instance.setModelCode(code);
		return tConfigDAO.findByExample(instance);
	}
	
	/**
	 * 根据模块编码和key获取值
	 * @param code
	 * @param key
	 * @return
	 */
	public List<TConfig> getConfigByCodeKey(String code,String key){
		TConfig instance = new TConfig();
		instance.setModelCode(code);
		instance.setKey(key);
		return tConfigDAO.findByExample(instance);
	}

	public TConfigDAO gettConfigDAO() {
		return tConfigDAO;
	}

	public void settConfigDAO(TConfigDAO tConfigDAO) {
		this.tConfigDAO = tConfigDAO;
	}

}
