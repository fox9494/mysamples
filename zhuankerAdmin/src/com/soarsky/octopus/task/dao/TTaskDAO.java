package com.soarsky.octopus.task.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.enums.EnumConstant;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.utils.PageBean;

public class TTaskDAO extends BaseDAO  {

	/**
	 * 分页查询所有任务信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentPage  当前页数
	 * @return
	*/
	public PageBean findAllTask(int maxresult, int currentPage) {
	
		Criteria crit=this.getSession().createCriteria(TTask.class).add(Restrictions.eq("isRemove",TaskContent.NOTROMOVE)).addOrder(Order.desc("createDate"));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
    
	/**
	 * 分页查询所有任务信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentPage  当前页数
	 * @param  task 任务对象
	 * @return
	*/
	public PageBean findAllTaskByConditions(int maxresult, int currentPage,TTask task) {
		
		Criteria crit=this.getSession().createCriteria(TTask.class).add(Restrictions.eq("isRemove",TaskContent.NOTROMOVE)).addOrder(Order.desc("createDate"));
		
		if(StringUtils.isNotEmpty(task.getName())){
			
			crit.add(Restrictions.like("name","%"+task.getName()+"%"));
			
		}
		if(task.getCreateDate()!=null&&task.getEndDate()==null){
			
			crit.add(Restrictions.ge("endDate", task.getCreateDate()));
			
		}
		if(task.getEndDate()!=null&&task.getCreateDate()==null){
			
			crit.add(Restrictions.ge("endDate", task.getEndDate()));
			
		}
		if(task.getCreateDate()!=null&&task.getEndDate()!=null){
			
			crit.add(Restrictions.between("endDate", task.getCreateDate(), task.getEndDate()));
			
		}
        if(StringUtils.isNotEmpty(task.getCompanyId().getName())){
			
			crit.createCriteria("companyId").add(Restrictions.like("name", "%"+task.getCompanyId().getName()+"%"));
			
		}
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	/**
	 * 分页查询所有未审核的任务对象列表
	 * @author lw
	 * @param  maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean findAllWaitingTask(int maxresult, int currentPage) {
		
		Criteria crit=this.getSession().createCriteria(TTask.class)
				                       .add(Restrictions.and(Restrictions.eq("isRemove", JEEContant.NOTROMOVE), Restrictions.eq("state", JEEContant.WAITING)))
				                       .add(Restrictions.isNotNull("app"));
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
    
	/**
	 *删除任务信息
	 *@author lw
	 *@param  info 要删除的任务id集合
	 */
	public void deleteTask(String info) {
		
		String sql = "update t_task set isremove="+JEEContant.ROMOVE+" where taskid in ("+info+")";
		
		this.executeBySql(sql, null);
	}
	
	/**
	 * 审核任务
	 * @author lw
	 * @param info 要进行审核的任务ID
	*/
	public void approveTask(String info) {
		
		String sql = "update t_task set state="+JEEContant.APPROVED+" where taskid in ("+info+")";
		
		this.executeBySql(sql, null);
	}
	
	/**
	 * 根据任务名查找任务
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public Boolean findTaskByName(TTask task) {
		
		Criteria crit=this.getSession().createCriteria(TTask.class).add(Restrictions.eq("name", task.getName())).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).addOrder(Order.desc("createDate"));
		
		Iterator<TTask>tasks=crit.list().iterator();
		while(tasks.hasNext()){
			return true;
		}
		
		return false;
	}
    
	/**
	 * 修改任务信息
	 * @author lw
	 * @param  task  要修改的任务对象  
	*/
	public void updateTask(TTask task) {
		String hql = "update TTask t set t.app.appid=:appid,t.name=:name,t.companyId.id=:companyid,t.orderId=:orderId,t.totalNumber=:totalNumber,t.goldNum=:goldNum,t.finishCondition=:finishCondition,t.completeDescription=:completeDescription,t.needTop=:needTop,t.endDate=:endDate,t.description=:description where t.taskid=:taskid";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("name", task.getName());
		if(task.getApp()!=null){
		  paramMap.put("appid", task.getApp().getAppid());
		}else{
		  paramMap.put("appid", null);
		}
		paramMap.put("companyid", task.getCompanyId().getId());
		paramMap.put("orderId", task.getOrderId());
		paramMap.put("totalNumber", task.getTotalNumber());
		paramMap.put("goldNum",task.getGoldNum());
		paramMap.put("finishCondition",task.getFinishCondition());
		paramMap.put("completeDescription",task.getCompleteDescription());
		paramMap.put("needTop",task.getNeedTop());
		paramMap.put("endDate",task.getEndDate());
		paramMap.put("description",task.getDescription());
		paramMap.put("taskid",task.getTaskid());
		this.executeByHql(hql, paramMap);
	}
	
	/**
	 * 根据任务所属公司的相关信息查询该公司发布的所有任务
	 * @param tCompany
	 * @return
	 */
	public List<TTask> findAllTaskByTCompany(TCompany tCompany) {
		
		Criteria crit=this.getSession().createCriteria(TTask.class).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).add(Restrictions.eq("state", JEEContant.APPROVED));
		//如果tCompanyid号不是默认的则添加条件根据任务所属公司的id号查询
		if(tCompany!=null) {
			if(tCompany.getId() != null) {
				crit.createCriteria("companyId").add(Restrictions.eq("id", tCompany.getId()));
			}
			//如果tCompany名字号不是null的则添加条件根据任务所属公司的名字查询
			if(tCompany.getName() != null) {
				crit.createCriteria("companyId").add(Restrictions.eq("name", tCompany.getName()));
			}
		}
		
		return crit.list();
		
	}
	
	/**
	 * 更新过期的任务
	 */
	public void updateExpire(){
		String sql = "update t_task set expireState=:state where end_Date+1<=sysdate";
		this.getSession().createSQLQuery(sql).setInteger("state", Integer.valueOf(EnumConstant.EXPIRE.getCode())).executeUpdate();
		
	}
	
}