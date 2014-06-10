package com.soarsky.octopus.reports.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TInstalledApk;
import com.soarsky.octopus.utils.PageBean;

public class TInstalledApkDAO extends BaseDAO {
	/**
	 * 用户详情，非平台安装应用（根据用户id显示相应的应用）
	 * 
	 * @param maxresult
	 * @param currentpage
	 * @param userId
	 * @return
	 */
	public PageBean findInstalledByUserId(int maxresult, int currentpage,
			long userId) {
		Criteria crit = this.getSession().createCriteria(TInstalledApk.class).addOrder(Order.desc("reportDate"));				
		if (!"".equals(userId)) {
			crit.createCriteria("TUserClient").add(Restrictions.eq("id", userId));					
		}

		return this.queryForPageByParams(maxresult, currentpage, crit);
	}

	/**
	 * 根据应用名字进行统计查询（模糊查询），查询该应用有多少用户安装，查询结果分页显示
	 * @param pageSize
	 * @param currentPage
	 * @param appName 查询条件，应用名字
	 * @return PageBean list封装的是Object[]
	 */
	public PageBean statisticsQueryByAppName(int pageSize, Integer currentPage, String appName) {

		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select ti1.apk_name,count(*) ");
		sqlSB.append(" from (select distinct ti.apk_name,ti.user_id from t_installed_apk ti where ti.apk_name like '%");
		sqlSB.append(appName + "%' ) ti1 ");
		sqlSB.append(" group by ti1.apk_name ");
		sqlSB.append(" order by ti1.apk_name ");
		
		return this.queryForPageByParams(pageSize, currentPage, sqlSB.toString(), null);
	}
}