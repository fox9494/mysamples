package com.soarsky.octopus.payment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.soarsky.octopus.clientuser.dao.TUserTaskDAO;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TDemandPayment;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.payment.dao.TDemandPaymentDAO;
import com.soarsky.octopus.payment.service.TDemandPaymentService;
import com.soarsky.octopus.payment.vo.Company;
import com.soarsky.octopus.payment.vo.Task;
import com.soarsky.octopus.task.dao.TCompanyDAO;
import com.soarsky.octopus.task.dao.TTaskDAO;
import com.soarsky.octopus.utils.PageBean;

/**
 * 需求方结算相关数据的业务实现
 * 提供：分页查询已经与需求方完成的结算的的详细信息
 *     保存新添加的与需求方的完成结算的相关信息
 *     查询客户信息列表（简要信息只有id号和名字）
 *     根据指定客户company的id号查询该客户提供的所有任务
 * @author ouyang
 *
 */
public class TDemandPaymentServiceImpl implements TDemandPaymentService{
	
	private TDemandPaymentDAO demandPaymentDao;//对需求方相关数据增删改查的持久层对象
	private TCompanyDAO tCompanyDAO; //task任务模块已经实现好的对应用提供方信息进行增删改查等常用数据库操作的持久层对象
	private TTaskDAO tTaskDAO;//task任务模块已经实现好的对任务表等常用数据库操作的持久层对象
	private TUserTaskDAO tUserTaskDAO;//clientuser普通用户管理模块提供的对用户任务关系表等常用炒作的持久层对象
	
	/**
	 * 分页查询已经与需求方结算过的详细信息
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @return 处理分页数据显示的实体
	 */
	@Override
	public PageBean queryListPage(int pageSize, Integer currentPage) {
		return demandPaymentDao.queryForPage(pageSize, currentPage);
	}

	/**
	 * 带条件的分页查询已经与需求方结算过的详细信息(客户id号、任务id号)
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @param tDemandPayment 条件封装对象
	 * @return 处理分页数据显示的实体
	 */
	@Override
	public PageBean queryListPage(int pageSize, Integer currentPage,
			TDemandPayment tDemandPayment) {

		if(tDemandPayment != null) {
			//如果没有选择客户，则重新设定客户为空（因为有可能没有选择时客户值唯下拉列表默认只）
			if(tDemandPayment.getCompany() != null && tDemandPayment.getCompany().getId() !=null && tDemandPayment.getCompany().getId() == JEEContant.SELECT_DEFAULT_VALUE) {
				tDemandPayment.setCompany(null);
			}
			//如果没有选择任务，则重新设定任务为空（因为有可能没有选择时任务值唯下拉列表默认只）
			if(tDemandPayment.getTask() != null && tDemandPayment.getTask().getTaskid() != null && tDemandPayment.getTask().getTaskid() == JEEContant.SELECT_DEFAULT_VALUE) {
				tDemandPayment.setTask(null);
			}
			return demandPaymentDao.queryForPage(pageSize, currentPage, tDemandPayment);
		} else {
			return demandPaymentDao.queryForPage(pageSize, currentPage);
		}
	}

	/**
	 * 保存新添加的针对需求方的结算信息
	 * @param demandPayment 结算详细信息
	 * @return 错误详细信息
	 */
	@Override
	public String saveDemandPayment(TDemandPayment demandPayment) {
		
		//查询该渠道最后一次结算的结束日期
		Date payDate = (Date) demandPaymentDao.queryDateByTask(demandPayment.getTask().getTaskid());
		//如果本次结算的开始日期在上次结算的结束日期之前则提示错误，不予结算
		if(payDate != null && demandPayment.getStartDate().before(payDate)) {
			return "结算范围内，包含已结算数据";
		}
		demandPaymentDao.saveDemandPayment(demandPayment);
		return "成功添加结算";
	}
	
	/**
	 * 查询客户信息列表
	 * @return 客户信息列表
	 */
	@Override
	public List<Company> queryCustomerList() {
		List<TCompany> tCompanys = tCompanyDAO.queryAllCompany();//查询到的所有客户的详细信息
		
		//循环取出所有客户的详细信息中的id号和名字重新封装到companys（客户简要信息列表）
		List<Company> companys = new ArrayList<Company>();
		if(tCompanys != null && tCompanys.size() !=0) {
			for(TCompany tCompany:tCompanys) {
				Company company = new Company(tCompany.getId(), tCompany.getName());
				companys.add(company);
			}
		}
		return companys;
	}

	/**
	 * 根据任务id，开始时间startDate，结束时间endDate查询统计指定任务在startDate、endtDate之间的完成量，如果条件不足则无统计结果
	 * 如果开始时间没有输入默认为结束时间之前的完成的所有任务
	 * 如果结束时间没有输入默认为开始时间之后的所有
	 * @param tDemandPayment 条件封装对象(任务id、开始时间startDate、结束时间endDate)
	 * @return 判断统计条件是否充足，如果任务id号，开始时间，结束时间都存在则查询指定时间范围内的指定任务的完成数量否则返回null
	 */
	@Override
	public Long statistics(TDemandPayment demandPayment) {
		if(demandPayment !=null && demandPayment.getTask()!=null ) {
			return tUserTaskDAO.queryCount(demandPayment.getTask().getTaskid(),demandPayment.getStartDate(),demandPayment.getEndDate());
		}
		return null;
		
	}
	
	/**
	 * 根据任务id，开始时间startDate，结束时间endDate查询统计指定任务在startDate、endtDate之间的完成量，如果条件不足则无统计结果
	 * 如果开始时间没有输入默认为结束时间之前的完成的所有任务
	 * 如果结束时间没有输入默认为开始时间之后的所有
	 * @param taskId 任务id
	 * @param startDate 任务完成时间上限
	 * @param endtDate 任务完成时间下限
	 * @return 判断统计条件是否充足，如果任务id号，开始时间，结束时间都存在则查询指定时间范围内的指定任务的完成数量否则返回null
	 */
	@Override
	public Long statistics(Long taskId, Date startDate, Date endtDate) {
		
		return tUserTaskDAO.queryCount(taskId, startDate, endtDate);
		
	}

	/**
	 * 根据任务idtaskId号查询该任务最后一次结算,结算到什么时间即是上次结算的结束时间，如果该任务没有进行过结算，则使用任务发起日期为结算开始日期
	 * @param taskId 任务id号
	 * @return 上次结算的结束时间作为本次结算的开始时间
	 */
	@Override
	public Date queryDateByTask(Long taskId) {
		//查询T_Demand_Payment结算表中的数据返回任务id等于taskId的最后一次结算的结束时间
		Date date =  (Date) demandPaymentDao.queryDateByTask(taskId);
		//如果date为空，说明该任务没有进行过结算，则使用任务发起日期为结算开始日期
		if(date == null) {
			TTask task = tTaskDAO.getById(TTask.class, taskId);
			date = task.getCreateDate();
		}
		return date;
	}
	
	/**
	 * 根据客户信息客户的id号查询客户提供的任务列表
	 */
	@Override
	public List<Task> queryTaskList(Long companyId) {
		
		//根据客户信息客户的id号查询客户提供的任务列表
		TCompany tCompany = new TCompany(companyId);
		List<TTask> tTasks = tTaskDAO.findAllTaskByTCompany(tCompany);//根据任务提供公司查询到的所有客户的详细信息
		
		//循环取出该公司发布的所有任务的详细信息中的id号和名字重新封装到tasks（客户简要信息列表）
		List<Task> tasks = new ArrayList<Task>();
		for(TTask tTask:tTasks) {
			Task task = new Task(tTask.getTaskid(), tTask.getName());
			tasks.add(task);
		}
		return tasks;
		
	}
	
	/**
	 * 根据任务id号查询该任务金币数
	 * @param taskId
	 * @return 任务金币数
	 */
	@Override
	public Long queryTaskGoleNum(Long taskId) {
		
		TTask task = tTaskDAO.getById(TTask.class, taskId);
		return task.getGoldNum();
		
	}

	/**
	 * 获取处理需求方结算数据持久层对象
	 * @return处理需求方结算数据持久层对象
	 */
	public TDemandPaymentDAO getDemandPaymentDao() {
		return demandPaymentDao;
	}

	/**
	 * 设置处理需求方结算数据持久层对象
	 * @param demandPaymentDao处理需求方结算数据持久层对象
	 */
	public void setDemandPaymentDao(TDemandPaymentDAO demandPaymentDao) {
		this.demandPaymentDao = demandPaymentDao;
	}

	/**
	 *获取 对应用提供方信息进行增删改查等常用数据库操作的持久层对象 
	 * @return对应用提供方信息进行增删改查等常用数据库操作的持久层对象
	 */
	public TCompanyDAO gettCompanyDAO() {
		return tCompanyDAO;
	}

	/**
	 * 设定对应用提供方信息进行增删改查等常用数据库操作的持久层对象
	 * @param tCompanyDAO对应用提供方信息进行增删改查等常用数据库操作的持久层对象
	 */
	public void settCompanyDAO(TCompanyDAO tCompanyDAO) {
		this.tCompanyDAO = tCompanyDAO;
	}

	/**
	 * 获取task任务模块已经实现好的对任务表等常用数据库操作的持久层对象
	 * @return task任务模块已经实现好的对任务表等常用数据库操作的持久层对象
	 */
	public TTaskDAO gettTaskDAO() {
		return tTaskDAO;
	}

	/**
	 * 设定task任务模块已经实现好的对任务表等常用数据库操作的持久层对象
	 * @param tTaskDAO task任务模块已经实现好的对任务表等常用数据库操作的持久层对象
	 */
	public void settTaskDAO(TTaskDAO tTaskDAO) {
		this.tTaskDAO = tTaskDAO;
	}

	/**
	 * 获取tUserTaskDAO
	 * @return
	 */
	public TUserTaskDAO gettUserTaskDAO() {
		return tUserTaskDAO;
	}

	/**
	 * 设定tUserTaskDAO
	 * @param tUserTaskDAO
	 */
	public void settUserTaskDAO(TUserTaskDAO tUserTaskDAO) {
		this.tUserTaskDAO = tUserTaskDAO;
	}

}
