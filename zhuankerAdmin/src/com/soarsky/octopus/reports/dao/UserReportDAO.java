package com.soarsky.octopus.reports.dao;

import java.math.BigDecimal;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.reports.vo.UserReportVo;
import com.soarsky.octopus.utils.PageBean;

/**
 * 
 * 赚客用户统计
 * @author zengganghong
 * @date 2013-5-10
 */
public class UserReportDAO extends BaseDAO 
{
	
	/**
	 * 总注册用户SQL
	 */
	private String SQL_COUNTALL_REGISTER_USER = "SELECT count(*) register_user FROM T_USER_CLIENT";
	
	/**
	 * 总活跃用户SQL
	 */
	private String SQL_COUNTALL_ACTIVE_USER = "select COUNT(DISTINCT(tcl.USER_ID)) active_user from T_CLIENT_LOGIN_LOG tcl " 
                                              +"WHERE TCL.LOGIN_DATE>=add_months(sysdate,-1)";
	
	/**
	 * 渠道用户统计SQL
	 */
	private String SQL_CHANNEL_COUNT_USER  = "SELECT tc.CHANNEL_NAME statName,"+
											"NVL((SELECT sum(countUser) FROM v_channel_active_user "+
											"where LEVEL_CODE like TC.LEVEL_CODE||'%'),0) as activeUser_Count,"+
											"NVL((SELECT sum(countUser) FROM v_channel_register_user "+
											"where LEVEL_CODE like TC.LEVEL_CODE||'%'),0) as registerUser_Count "+
											"FROM T_CHANNEL tc WHERE tc.PARENTID=1 and tc.ISREMOVE=0 order by registerUser_Count DESC,activeUser_Count DESC";
	
	/**
	 * 区域统计用户SQL
	 */
	private String SQL_AREA_COUNT_USER = " select aru.statename as statName,aau.user_count as activeUser_Count,aru.user_count as registerUser_Count from "+
										 " (select aru1.*,(select count(DISTINCT aru2.userid) from v_area_register_user aru2 start with aru2.id = aru1.id CONNECT BY PRIOR aru2.id = aru2.parent_id ) as user_count "+
										 " from v_area_register_user aru1 where aru1.parent_id = 1 ) aru"+
										 " inner join "+
										 " (select aau1.*,(select count(DISTINCT aau2.userid) from v_area_active_user aau2 start with aau2.id = aau1.id CONNECT BY PRIOR aau2.id = aau2.parent_id ) as user_count "+
										 " from v_area_active_user aau1 where aau1.parent_id = 1) aau"+
									     " on aru.id=aau.id order by registerUser_Count DESC,activeUser_Count DESC";
	
	/**
	 * 赚客级别统计用户SQL
	 */
	private String SQL_LEVEL_COUNT_USER = "SELECT m.name statName,m.active_user activeUser_Count,n.register_user registerUser_Count from "+
										"  (SELECT b.id id,b.name name,count(a.user_id) active_user from T_USER_LEVEL b "+
										"  left join ( "+
										"    SELECT tc.USER_ID,(SELECT max(id) FROM T_USER_LEVEL "+
										"    WHERE GOLD_NUM<=TC.TOTAL_GOLD) as level_id "+
										"    FROM v_userLevel_active_user tc) a on a.level_id=b.id GROUP BY b.id,b.NAME ) m "+
										" left join " +
										"  (SELECT b.id id,b.name name,count(a.user_id) register_user from T_USER_LEVEL b " +
										"  left join (SELECT tc.USER_ID,(SELECT max(id) FROM T_USER_LEVEL " +
										"    WHERE GOLD_NUM<=TC.TOTAL_GOLD) as level_id " +
										"    FROM T_USER_GOLD_COUNT tc) a on a.level_id=b.id GROUP BY b.id,b.NAME) n "+
										" on m.id=n.id order by m.id";
	
	/**
	 * 按一级渠道统计注册用户和活跃用户
	 * @param pageSize 
	 * @param currentPage
	 * @return PageBean:list装的是UserReportVo
	 */
	public PageBean channelUserStatistics(int pageSize, Integer page) 
	{ 
		PageBean pageBean = queryForPageByParams(pageSize, page, SQL_CHANNEL_COUNT_USER, null);
		
		
		return pageBean;
	}
	
	/**
	 * 按区域统计注册用户和活跃用户
	 * @param pageSize 
	 * @param currentPage
	 * @return PageBean:list装的是UserReportVo
	 */
	public PageBean areaUserStatistics(int pageSize, Integer page) 
	{ 
		PageBean pageBean = queryForPageByParams(pageSize, page, SQL_AREA_COUNT_USER, null);
		return pageBean;
	}
	
	/**
	 * 按赚客级别统计注册用户和活跃用户
	 * @param pageSize 
	 * @param currentPage
	 * @return PageBean:list装的是UserReportVo
	 */
	public PageBean levelUserStatistics(int pageSize, Integer page) 
	{ 
		PageBean pageBean = queryForPageByParams(pageSize, page, SQL_LEVEL_COUNT_USER, null);
		return pageBean;
	}
	
	/**
	 * 统计总用户和总活跃用户
	 * @param pageSize 
	 * @param currentPage
	 * @return PageBean:list装的是UserReportVo
	 */
	public UserReportVo allUserStatistics( ) 
	{ 
		UserReportVo reportVo = new UserReportVo();
		//查询总注册用户
		Integer register_count = ((BigDecimal) getSession().createSQLQuery(SQL_COUNTALL_REGISTER_USER).uniqueResult()).intValue();
		//查询总活跃用户
		Integer active_count =   ((BigDecimal) getSession().createSQLQuery(SQL_COUNTALL_ACTIVE_USER).uniqueResult()).intValue();
		reportVo.setStatName("countAllUser");
		reportVo.setActiveUser_Count(active_count);
		reportVo.setRegisterUser_Count(register_count);
		return reportVo;
	}

}