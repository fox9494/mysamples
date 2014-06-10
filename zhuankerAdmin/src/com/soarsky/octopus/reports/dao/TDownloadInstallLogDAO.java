package com.soarsky.octopus.reports.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TDownloadInstallLog;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.reports.vo.StatisticsReport;
import com.soarsky.octopus.task.vo.TDownloadInstallLogVo;
import com.soarsky.octopus.utils.PageBean;

public class TDownloadInstallLogDAO extends BaseDAO {
	
	/**
	 * 根据companyId、appId查询统计指定应用的下载or安装量，查询结果分页显示（appId为null查询指定客户发布的所有应用，companyId为空时，查询所有客户发布的应用）
	 * @param pageSize 
	 * @param currentPage
	 * @param appId
	 * @param type 指明查询的是下载量还是安装量--下载0，安装1
	 * @return PageBean:list装的是StatisticsReport
	 */
	public PageBean appInstallsStatistics(int pageSize, Integer page,
			Long companyId, Long appId, int type) { 
		//构造查询统计下载量or安装量的原生sql
		StringBuilder sql = new StringBuilder();
		sql.append(" select ta.companyid,tc.name,ta.appid,ta.appname,count(td.app_id) ");
		sql.append(" from (select * from t_download_install_log where type="+type+") td ");
		sql.append(" right join t_application ta on td.app_id=ta.appid ");
		sql.append(" left join t_company tc on ta.companyid = tc.id ");
		sql.append(" where tc.isremove=" + JEEContant.NOTROMOVE);
		if(companyId != null) {
			sql.append(" and ta.companyid = " + companyId);
		}
		if(appId != null) {
			sql.append(" and ta.appid = " + appId);
		}
		sql.append(" group by td.app_id,ta.appid,ta.appname,ta.companyid,tc.name order by ta.companyid,ta.appid ");
		
		return this.queryForPageByParams(pageSize, page, sql.toString(), null);
	}
	
	/**
	 * 分页显示
	 * 
	 * @param maxresult
	 *            最大记录数
	 * @param currentpage
	 *            当前页数
	 * @return
	 */
	public PageBean findAllDownloadLog(int maxresult, int currentpage) {
		Criteria crit = this.getSession().createCriteria(TDownloadInstallLog.class);
				
		return this.queryForPageByParams(maxresult, currentpage, crit);

	}

	/**
	 * 根据条件进行分页查询
	 * 
	 * @param maxresult
	 *            最大记录数
	 * @param currentpage
	 *            当前页数
	 * @param userName
	 *            用户名称
	 * @param appName
	 *            应用名称
	 * @return
	 */
	public PageBean findAllDowloadLogConditions(int maxresult, int currentpage,TUserClient user, TApplication  app) {
			
		Criteria crit = this.getSession().createCriteria(TDownloadInstallLog.class);
				
		if (user!=null&&user.getId()!=0) {
			
			crit.createCriteria("TUserClient").add(Restrictions.eq("id", user.getId()));
					
		}
		if (StringUtils.isNotEmpty(app.getAppName())) {
			
			crit.createCriteria("TApplication").add(Restrictions.like("appName", "%" + app.getAppName() + "%"));
					
		}
		return this.queryForPageByParams(maxresult, currentpage, crit);

	}

	/**
	 * 用户详情，下载量统计（根据当前用户对应的应用）
	 * @author yl
	 * @param maxresult
	 * @param currentpage
	 * @param userId
	 *            当前用户的id
	 * @return
	 */
	public PageBean findDownloadByUserId(int maxresult, int currentpage,
			long userId) {
		/*String sql = "select * from t_task where appId in(select app_id from t_download_install_log where user_id=:id) and finish_condition=0";
		Map params = new HashMap();
		params.put("id", userId);	*/
		Criteria crit = this.getSession().createCriteria(TDownloadInstallLog.class).add(Restrictions.eq("type", JEEContant.DOWNLOAD)).createCriteria("TUserClient").add(Restrictions.eq("id", userId));
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}

	/**
	 * 用户详情，安装量
	 * @author yl
	 * @param maxresult
	 * @param currentpage
	 * @param userId
	 * @return
	 */
	public PageBean findInstallReportByUserId(int maxresult, int currentpage,
			long userId) {
		/*String sql = "select * from t_task where appId in(select app_id from t_download_install_log where user_id=:id) and finish_condition=1";
		Map params = new HashMap();
		params.put("id", userId);*/
		Criteria crit = this.getSession().createCriteria(TDownloadInstallLog.class).add(Restrictions.eq("type", JEEContant.INSTALL)).createCriteria("TUserClient").add(Restrictions.eq("id", userId));
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}
    
	/**
	 * 根据应用对下载量以及安装量进行统计
	 * @author lw
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	public PageBean findReportByApplication(int maxresult, int currentpage,TApplication app,Integer type) {	
		
		Criteria crit=this.getSession().createCriteria(TDownloadInstallLog.class).add(Restrictions.eq("type",type)).addOrder(Order.desc("operateDate"))
			              .createCriteria("TApplication").add(Restrictions.eq("appid", app.getAppid()));

		return this.queryForPageByParams(maxresult, currentpage, crit);
	}
	/**
	 * 根据应用对下载量以及安装量进行统计
	 * @author lw
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageBean findReportByApplicationJson(int maxresult, int currentpage,TApplication app,Integer type) {
		
		List tDownloadInstallLogs=new ArrayList();
		
		Criteria crit=this.getSession().createCriteria(TDownloadInstallLog.class).add(Restrictions.eq("type",type)).addOrder(Order.desc("operateDate"))
			              .createCriteria("TApplication").add(Restrictions.eq("appid", app.getAppid()));
		PageBean pageBean=this.queryForPageByParams(maxresult, currentpage, crit);
		
		Iterator<TDownloadInstallLog>list=pageBean.getList().iterator();
		while(list.hasNext()){
			TDownloadInstallLogVo tDownInstallVo=new TDownloadInstallLogVo();
			TDownloadInstallLog tDownInstall=list.next();
			
			if(StringUtils.isNotBlank(tDownInstall.getTUserClient().getNickName())){
			    tDownInstallVo.setNickName(tDownInstall.getTUserClient().getNickName());
			}
			if(StringUtils.isNotBlank(tDownInstall.getTUserClient().getUserName())){
			    tDownInstallVo.setUserName(tDownInstall.getTUserClient().getUserName());
			}
			if(tDownInstall.getOperateDate()!=null){			
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String date=format.format(tDownInstall.getOperateDate());
				tDownInstallVo.setOperateDate(date);
			}
			tDownloadInstallLogs.add(tDownInstallVo);
		}
		pageBean.setList(tDownloadInstallLogs);
		
		return pageBean;
	}
	/**
	 * 返回所有的客户
	 * @return
	 */
	 public List<TUserClient> findAllClient(){
		 Criteria	crit =  this.getSession().createCriteria(TUserClient.class);
		 List<TUserClient> userList = crit.list();	
		 return userList;
	 }

}