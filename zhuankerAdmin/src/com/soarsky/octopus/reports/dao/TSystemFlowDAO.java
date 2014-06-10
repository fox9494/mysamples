package com.soarsky.octopus.reports.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TSystemFlow;
import com.soarsky.octopus.task.vo.TSystemFlowVo;
import com.soarsky.octopus.utils.PageBean;

public class TSystemFlowDAO extends BaseDAO {
	/**
	 * 分页查询使用统计量
	 * 
	 * @param maxresult
	 *            最大记录数
	 * @param currentpage
	 *            当前页数
	 * @return
	 */
	public PageBean findAllSystemFlow(int maxresult, int currentpage) {
		Criteria crit = this.getSession().createCriteria(TSystemFlow.class);
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param maxresult
	 *            最大记录数
	 * @param currentpage
	 *            当前页数
	 * @param appName
	 *            应用名称
	 * @param user
	 *            用户对象
	 * @return
	 */
	public PageBean findAllSystemFlowByConditions(int maxresult,int currentpage, String userName, String appName) {
			

		Criteria crit = this.getSession().createCriteria(TSystemFlow.class);

		if (StringUtils.isNotBlank(userName)) {
			crit.createCriteria("TUserClient").add(Restrictions.eq("userName", userName));
					
		}
		if (StringUtils.isNotBlank(appName)) {
			crit.createCriteria("TApplication").add(Restrictions.like("appName", "%" + appName + "%"));
					
		}

		return this.queryForPageByParams(maxresult, currentpage, crit);
	}

	/**
	 * 用户详情->使用量统计列表
	 * 
	 * @param maxResult
	 * @param currentPage
	 * @param userId
	 *            用户id
	 * @return
	 */
	public PageBean findAllSystemFlowById(int maxResult, int currentPage,
			long userId) {
		Criteria crit = this.getSession().createCriteria(TSystemFlow.class)
				.addOrder(Order.desc("reportDate"));
		if (!"".equals(userId)) {
			crit.createCriteria("TUserClient").add(
					Restrictions.eq("id", userId));

		}
		return this.queryForPageByParams(maxResult, currentPage, crit);
	}
    
	/**
	 * 根据应用查询流量信息
	 * @author lw
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	*/
	public PageBean findSysFlowByApp(int maxresult, int currentPage,TApplication app) {
		
		Criteria crit=this.getSession().createCriteria(TSystemFlow.class).addOrder(Order.desc("reportDate"))
				          .createCriteria("TApplication").add(Restrictions.eq("appid", app.getAppid()));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	/**
	 * 执行分页操作
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageBean findSysFlowByAppJson(int maxresult, Integer currentPage,TApplication app) {
		
		List tSystemFlows=new ArrayList();
		
		Criteria crit=this.getSession().createCriteria(TSystemFlow.class).addOrder(Order.desc("reportDate"))
		          .createCriteria("TApplication").add(Restrictions.eq("appid", app.getAppid()));
		PageBean pageBean=this.queryForPageByParams(maxresult, currentPage, crit);
		
		Iterator<TSystemFlow>list=pageBean.getList().iterator();
		while(list.hasNext()){
			TSystemFlowVo tSystemFlowVo=new TSystemFlowVo();
			TSystemFlow  tSystemFlow=list.next();
			
			if(StringUtils.isNotBlank(tSystemFlow.getTUserClient().getUserName())){
				tSystemFlowVo.setUserName(tSystemFlow.getTUserClient().getUserName());
			}
			if(tSystemFlow.getUpNum()!=null){
				tSystemFlowVo.setUpNum(tSystemFlow.getUpNum());
			}
			if(tSystemFlow.getDownNum()!=null){
				tSystemFlowVo.setDownNum(tSystemFlow.getDownNum());
			}
			if(tSystemFlow.getReportDate()!=null){			
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String date=format.format(tSystemFlow.getReportDate());
				tSystemFlowVo.setReportDate(date);
			}
			tSystemFlows.add(tSystemFlowVo);
		}
		pageBean.setList(tSystemFlows);
		
		return pageBean;
	}

	/**
	 * 根据客户id与应用id分页查询该应用使用量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return pageBean:list里装的Object[]
	 */
	public PageBean appFlowStatistics(int pageSize, Integer currentPage,
			Long companyId, Long appId) {
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select tc.id,tc.name,ta.appid,ta.appname,ts1.uns,ts1.dns ");	
		sqlSB.append(" from (");	
		sqlSB.append(" select ts.apk_id,sum(ts.dnm) dns,sum(ts.unm) uns");	
		sqlSB.append(" from (select use_id,apk_id,max(down_num) dnm,max(up_num) unm from t_system_flow group by use_id,apk_id) ts ");	 
		sqlSB.append(" group by ts.apk_id ");	
		sqlSB.append(" ) ts1 ");	
		sqlSB.append(" right join t_application ta on ts1.apk_id = ta.appid ");	
		sqlSB.append(" left join t_company tc on ta.companyid = tc.id ");	
		sqlSB.append(" where tc.isremove=" + JEEContant.NOTROMOVE + " ");
		if(companyId != null) {
			sqlSB.append(" and tc.id=" + companyId + " ");
		}
		if(appId != null) {
			sqlSB.append(" and ta.appid=" + appId + " ");
		}
		sqlSB.append(" order by tc.id,ta.appid ");
		String sql = sqlSB.toString();
		
		return this.queryForPageByParams(pageSize, currentPage, sql, null);
		
	}
	
	

}