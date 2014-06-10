package com.soarsky.octopus.payment.service;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.mapping.TDemandPayment;
import com.soarsky.octopus.payment.vo.Company;
import com.soarsky.octopus.payment.vo.Task;
import com.soarsky.octopus.utils.PageBean;

/**
 * 处理需求方结算相关数据的业务接口
 * @author ouyang
 *
 */
public interface TDemandPaymentService {

	/**
	 * 分页查询已经与需求方结算过的详细信息
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @return 处理分页数据显示的实体
	 */
	public PageBean queryListPage(int pageSize, Integer currentPage);
	
	/**
	 * 带条件的分页查询已经与需求方结算过的详细信息(客户id号、任务id号)
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @param tDemandPayment 条件封装对象
	 * @return 处理分页数据显示的实体
	 */
	public PageBean queryListPage(int pageSize, Integer currentPage, TDemandPayment tDemandPayment);
	/**
	 * 保存新添加的针对需求方的结算信息
	 * @param demandPayment 结算详细信息
	 * @return 
	 */
	public String saveDemandPayment(TDemandPayment demandPayment);

	/**
	 * 查询客户信息列表
	 * @return 客户信息列表
	 */
	public List<Company> queryCustomerList();

	/**
	 * 根据指定客户company的id号查询该客户提供的所有任务
	 * @param id 条件客户id号
	 * @return 
	 */
	public List<Task> queryTaskList(Long id);

	/**
	 * 根据任务id，开始时间startDate，结束时间endDate查询统计指定任务在startDate、endtDate之间的完成量，如果条件不足则无统计结果
	 * 如果开始时间没有输入默认为结束时间之前的完成的所有任务
	 * 如果结束时间没有输入默认为开始时间之后的所有
	 * @param tDemandPayment 条件封装对象(任务id、开始时间startDate、结束时间endDate)
	 * @return 判断统计条件是否充足，如果任务id号，开始时间，结束时间都存在则查询指定时间范围内的指定任务的完成数量否则返回null
	 */
	public Long statistics(TDemandPayment demandPayment);

	/**
	 * 根据任务idtaskId号查询该任务最后一次结算,结算到什么时间即是上次结算的结束时间，如果该任务没有进行过结算，则使用任务发起日期为结算开始日期
	 * @param taskId 任务id号
	 * @return 上次结算的结束时间作为本次结算的开始时间
	 */
	public Date queryDateByTask(Long taskId);

	/**
	 * 根据任务id，开始时间startDate，结束时间endDate查询统计指定任务在startDate、endtDate之间的完成量，如果条件不足则无统计结果
	 * 如果开始时间没有输入默认为结束时间之前的完成的所有任务
	 * 如果结束时间没有输入默认为开始时间之后的所有
	 * @param taskId 任务id
	 * @param startDate 任务完成时间上限
	 * @param endtDate 任务完成时间下限
	 * @return 判断统计条件是否充足，如果任务id号，开始时间，结束时间都存在则查询指定时间范围内的指定任务的完成数量否则返回null
	 */
	public Long statistics(Long taskId, Date startDate, Date endtDate);

	/**
	 * 根据任务id号查询该任务金币数
	 * @param taskId
	 * @return 任务金币数
	 */
	public Long queryTaskGoleNum(Long taskId);

}
