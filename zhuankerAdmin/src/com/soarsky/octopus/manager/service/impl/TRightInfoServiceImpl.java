package com.soarsky.octopus.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.soarsky.octopus.clientuser.vo.Attr;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.dao.TModelInfoDAO;
import com.soarsky.octopus.manager.dao.TRightInfoDAO;
import com.soarsky.octopus.manager.service.TRightInfoService;
import com.soarsky.octopus.mapping.TModelInfo;
import com.soarsky.octopus.mapping.TRightInfo;
import com.soarsky.octopus.mapping.TRoleInfo;

public class TRightInfoServiceImpl implements TRightInfoService {
	
	private TRightInfoDAO tRightInfoDAO;
	
	private TModelInfoDAO tModelInfoDAO;
	
	
	
	/**
	 * 编辑角色权限
	 * 先删除后插入
	 * @param roleId
	 * @param models   模块id数组
	 */
	public void editRight(Long roleId,String[] models){
		tRightInfoDAO.deleteByRole(roleId);
		if (models!=null){
			List<TRightInfo> list = new ArrayList<TRightInfo>();
			for (String modelId : models) {
				TRightInfo right = new TRightInfo();
				right.setTRoleInfo(new TRoleInfo(roleId));
				right.setTModelInfo(new TModelInfo(Long.valueOf(modelId)));
				
				//得到模块的所有父模块
				List<TModelInfo> parents = tModelInfoDAO.selectParentModelById(Long.valueOf(modelId));
				if (parents!=null){
					for (TModelInfo tModelInfo : parents) {
						TRightInfo right_p = new TRightInfo();
						right_p.setTRoleInfo(new TRoleInfo(roleId));
						right_p.setTModelInfo(new TModelInfo(Long.valueOf(tModelInfo.getId())));
						list.add(right_p);
					}
				}
				
				list.add(right);
			}
			tRightInfoDAO.batchAdd(list);
		}
	}
	

	public TRightInfoDAO gettRightInfoDAO() {
		return tRightInfoDAO;
	}

	public void settRightInfoDAO(TRightInfoDAO tRightInfoDAO) {
		this.tRightInfoDAO = tRightInfoDAO;
	}


	public TModelInfoDAO gettModelInfoDAO() {
		return tModelInfoDAO;
	}


	public void settModelInfoDAO(TModelInfoDAO tModelInfoDAO) {
		this.tModelInfoDAO = tModelInfoDAO;
	}

}
