package com.soarsky.octopus.task.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TTask;

public class TApplicationDAO extends BaseDAO  {
    
	/**
	 * 根据任务对象查找应用对象
	 * @author lw
	 * @param 任务对象
	 * @return
	*/
	public TApplication findAppByTask(TTask task) {
		
		Criteria crit=this.getSession().createCriteria(TApplication.class).createCriteria("task").add(Restrictions.eq("taskid", task.getTaskid()));
			
		while(crit.list().iterator().hasNext()){
			
			return (TApplication)crit.list().iterator().next();
		}
		
		return null;
	}
	
	/**
	 * 修改应用
	 * @author lw
	 * @param  application 要添加的应用对象
	*/
	public void updateApplication(TApplication application) {
		String hql = "update TApplication t set t.appName=:appname,t.package_name=:package_name,t.version=:version,t.platform=:platform,t.versionrequire=:versionrequire,t.iconUrl=:iconUrl,t.initDownLoad=:initDownLoad,t.description=:description,t.rating=:rating,t.costType=:costType where t.appid=:id";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("appname", application.getAppName());
		paramMap.put("package_name", application.getPackage_name());
		paramMap.put("version", application.getVersion());
		paramMap.put("platform", application.getPlatform());
		paramMap.put("versionrequire", application.getVersionrequire());
		paramMap.put("initDownLoad", application.getInitDownLoad());
		paramMap.put("iconUrl",application.getIconUrl());
		paramMap.put("description",application.getDescription());
		paramMap.put("rating",application.getRating());
		paramMap.put("costType",application.getCostType());
		paramMap.put("id",application.getAppid());
		this.executeByHql(hql, paramMap);
	}

	/**
	 * 根据客户id号companyID查询该客户发布的所有应用（如果companyID为空或则下拉列表默认值则查询所有）
	 * @param companyID 客户id号
	 * @return List<TApplication>：该客户发布的所有应用集合
	 */
	public List<TApplication> queryAppsByCompany(Long companyID) {

		Criteria crit=this.getSession().createCriteria(TApplication.class);
		
		//如果tCompanyid号不是默认的则添加条件根据任务所属公司的id号查询
		if(companyID != null) {
			crit.createCriteria("company").add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).add(Restrictions.eq("id", companyID));
		} else {
			crit.createCriteria("company").add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE));
		}
		return crit.list();
		
	}
	
	
}