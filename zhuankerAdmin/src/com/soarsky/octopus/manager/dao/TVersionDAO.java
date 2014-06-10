package com.soarsky.octopus.manager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TVersion;
import com.soarsky.octopus.utils.PageBean;

public class TVersionDAO extends BaseDAO  {
	
	
	/**
	 * 分页查询所有版本
	 * @param maxresult
	 * @param currentPage
	 * @param tversion
	 * @return
	 */
	public PageBean findAllVersion(int maxresult,int currentPage,TVersion tversion){
		Criteria crit=this.getSession().createCriteria(TVersion.class);
		return  this.queryForPageByParams(maxresult, currentPage, crit);
		
	}
	
	/**
	 * 查询最新版本
	 * @return
	 */
	public TVersion queryMaxVersion(){
		TVersion version = null;
		String hql = "from TVersion as version where version.id = (select max(id) from TVersion)";
		List versions = this.getSession().createQuery(hql).list();
		if (versions!=null && !versions.isEmpty()){
			version = (TVersion) versions.get(0); 
		}
		return version;
	}
	
	/**
	 * 判断版本是否已经存在
	 */
	public boolean judgeVersionName(String versionName){
		
		List<TVersion> versionList=this.getSession().createCriteria(TVersion.class).add(Restrictions.eq("version", versionName)).list();
		if(versionList.size()>0){
			return true;
		}
		return false;
	}
	
}