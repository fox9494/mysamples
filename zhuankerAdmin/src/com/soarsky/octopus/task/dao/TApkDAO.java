package com.soarsky.octopus.task.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TApk;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.utils.PageBean;

public class TApkDAO extends BaseDAO  {

	/**
	 * 根据应用删除APK
	 * @author lw
	 * @param  application  应用对象
	*/
	@SuppressWarnings("unchecked")
	public void deleteApk(TApplication application) {
		
		Criteria crit=this.getSession().createCriteria(TApk.class).createCriteria("TApplication").add(Restrictions.eq("appid", application.getAppid()));
		
		Iterator<TApk>apks=crit.list().iterator();
		
		while(apks.hasNext()){
			
			this.delete(apks.next());
		}
	}
	
	/**
	 * 查询所有特定分辨率的APK
	 * @author lw
	 * @param  maxsize  每页最大条数
	 * @param  currentPage  当前页数
	 * @return
	*/
	public PageBean findAllSpecialApk(int maxsize, int currentPage,TApplication app) {
		
		Criteria crit=this.getSession().createCriteria(TApk.class).add(Restrictions.eq("isDefault", JEEContant.SPECIALRESOLUTIONAPK)).createCriteria("TApplication").add(Restrictions.eq("appid", app.getAppid()));
		
		return this.queryForPageByParams(maxsize, currentPage, crit);
	}
	
	/**
	 * 根据应用查询该应用下的常用APK
	 * @author lw
	 * @param  application  应用对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public TApk findCommonApk(TApplication app) {
		
		Criteria crit=this.getSession().createCriteria(TApk.class).add(Restrictions.eq("isDefault", JEEContant.COMMONRESOLUTIONAPK)).createCriteria("TApplication").add(Restrictions.eq("appid", app.getAppid()));
		
		List<TApk>apks=crit.list();
		
		if(apks.size()>0){
			
			while(apks.iterator().hasNext()){
				
				return  apks.iterator().next();
			}
		}
		return null;
	}
}