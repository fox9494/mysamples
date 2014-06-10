
package com.soarsky.octopus.clientuser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TGoldChange;
import com.soarsky.octopus.utils.PageBean;

public class TUserTaskDAO extends BaseDAO {
	/**
	 * 分页显示用户任务详情
	 * @author yl
	 * @param maxResult
	 *            最大记录数
	 * @param currentPage
	 *            当前页数
	 * @param userId
	 *            当前用户id
	 * @return
	 */
	public PageBean findAllUserTask(int maxResult, int currentPage, long userId) {
		//只能显示用户做的任务所得的金币
		String sql = "select * from t_gold_change where tuser_task_id in (select id from t_user_task  where user_id=:id) and operate_type=:type ";
		Map params = new HashMap();
		params.put("id", userId);
		params.put("type", JEEContant.TASK_ADD);
		
		return this.queryForPageByParams(maxResult, currentPage, sql, params, TGoldChange.class);
	}

	/**
	 * 根据任务id号，时间范围查找指定时间内的指定任务完成总数
	 * @param taskId 
	 * @param startDate
	 * @param endtDate
	 * @return 匹配条件的时间期间完成的任务总数
	 */
	public Long queryCount(Long taskId, Date startDate, Date endtDate) {
		//根据任务id号，时间范围查找指定时间内的指定任务完成总数
		//"select count(1) from t_user_task where task_id=? and finish_date >= ? and finish_date < ? and is_finished=?"; 
		String countHql = " select count(*) from TUserTask where TTask.taskid=? and is_finished=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(taskId);
		params.add(JEEContant.FINISHED);
		//如果开始时间没有输入默认为查询结束时间之前的完成的所有任务
		if(startDate != null) {
			countHql = countHql + " and finishDate>=? ";
			params.add(startDate);
		}
		//如果结束时间没有输入默认为查询开始时间之后的完成的所有任务
		if(endtDate != null) {
			countHql = countHql + " and finishDate<? ";
			params.add(endtDate);
		}
		return (Long)this.queryUniqueResult(countHql,params);
	}

	/**
	 * 根据channelId、任务完成时间范围查询统计指定渠道下的所有用户在时间范围内的任务总数及获得金币总数
	 * @param channelId
	 * @param startDate
	 * @param endtDate
	 * @return 
	 */
	public Map<String, Object> queryStatistics(String levelCode, Date startDate, Date endDate) {

		//String hql = "select new Map(count(*) as taskStatistics,sum(goldNum) as coinStatistics) from TUserTask where TUserClient.leveCode like ? and isFinished=? ";
		String hql = "select new Map(count(*) as taskStatistics, sum(goldNum) as coinStatistics) from TUserTask where TUserClient.leveCode like ? and isFinished=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(levelCode);
		params.add(JEEContant.FINISHED);
		//如果开始时间没有输入默认为查询结束时间之前的完成的所有任务
		if(startDate != null) {
			hql = hql + " and finishDate>=? ";
			params.add(startDate);
		}
		//如果结束时间没有输入默认为查询开始时间之后的完成的所有任务
		if(endDate != null) {
			hql = hql + " and finishDate<? ";
			params.add(endDate);
		}
		
		return (Map<String, Object>) this.queryUniqueResult(hql, params);
		
	}

}