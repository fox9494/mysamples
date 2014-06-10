package com.soarsky.octopus.payment.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TDemandPayment;
import com.soarsky.octopus.utils.PageBean;

/**
 * 处理需求方结算数据持久层对象
 * 主要负责处理需求方结算相关数据的增删改查等操作
 * @author ouyang
 *
 */
public class TDemandPaymentDAO extends BaseDAO {

	/**
	 * 分页查询已经与需求方结算过的详细信息
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @return 处理分页数据显示的实体
	 */
	public PageBean queryForPage(int pageSize, Integer currentPage) {
		return this.queryForPageByParams(pageSize, currentPage, this.getSession().createCriteria(TDemandPayment.class).addOrder(Order.desc("paymentDate")));
	}
	
	/**
	 * 分页查询已经与需求方结算过的详细信息
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @param tDemandPayment 条件封装对象
	 * @return 处理分页数据显示的实体
	 */
	public PageBean queryForPage(int pageSize, Integer currentPage, TDemandPayment tDemandPayment) {

		Criteria crit=this.getSession().createCriteria(TDemandPayment.class).addOrder(Order.desc("paymentDate"));
		if(tDemandPayment != null) {
			//构造条件，如果结算信息中客户id不为空就添加条件根据客户id查询(注意这里的id为Long型，所以要先判断是否为空，再判断是否为0)
			if(tDemandPayment.getCompany() != null && tDemandPayment.getCompany().getId() != null) {
				crit.createCriteria("company").add(Restrictions.eq("id", tDemandPayment.getCompany().getId()));
			}
			//构造条件，如果结算信息中任务id不为空就添加条件根据id查询(注意这里的id为Long型，所以要先判断是否为空，再判断是否为0)
			if(tDemandPayment.getTask() != null && tDemandPayment.getTask().getTaskid() != null) {
				crit.createCriteria("task").add(Restrictions.eq("taskid", tDemandPayment.getTask().getTaskid()));
			}
		}
		
		return this.queryForPageByParams(pageSize, currentPage, crit);
	}

	/**
	 * 根据demandPayment实体的详细信息，将对应数据保存到数据库对应表(T_DEMAND_PAYMENT)中
	 * @param demandPayment 需要保存到数据库的结算信息
	 */
	public void saveDemandPayment(TDemandPayment demandPayment) {
		this.save(demandPayment);
	}

	/**
	 * 根据任务idtaskId号查询该任务最后一次结算,结算到什么时间即是上次结算的结束时间，如果该任务没有进行过结算，则使用任务发起日期为结算开始日期
	 * @param taskId 任务id号
	 * @return 上次结算的结束时间作为本次结算的开始时间
	 */
	public Date queryDateByTask(Long taskId) {
		//查询T_Demand_Payment结算表中的数据返回任务id等于taskId的最后一次结算的结束时间
		String hql = " select max(endDate) from TDemandPayment where task.taskid=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(taskId);
		Date date =  (Date) this.queryUniqueResult(hql,params);
		return date;
	}

}
