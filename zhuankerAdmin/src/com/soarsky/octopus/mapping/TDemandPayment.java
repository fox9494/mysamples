package com.soarsky.octopus.mapping;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应数据库中需求方结算表（T_DEMAND_PAYMENT）的实体类
 * @author ouyang
 *
 */
public class TDemandPayment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;                 //主键id		NUMBER(20)      
    private TCompany company;       //客户id		NUMBER(10)      
    private TTask task;             //任务id		NUMBER(20)      
    private Date startDate;         //开始时间		DATE
    private Date endDate;           //结束时间		DATE            
    private Long statisticsAmount;  //统计量		NUMBER(20)      
    private Long approvedAmount;    //认可量		NUMBER(20)      
    private Double paymentMoney;    //结算金额		NUMBER(14,2)    
    private Date paymentDate;       //结算时间   	DATE            
    
    /**
     * 空的构造方法
     */
	public TDemandPayment() {
		super();
	}
	
	/**
	 * 初始化id的构造方法
	 * @param id
	 */
	public TDemandPayment(Long id) {
		super();
		this.id = id;
	}

	/**
	 * 初始化所有属性的构造方法
	 * @param id                主键id	
	 * @param TCompany          客户id	
	 * @param TTask             任务id	
	 * @param startDate        开始时间	
	 * @param endDate          结束时间	
	 * @param statisticsAmount 统计量	
	 * @param approvedAmount   认可量	
	 * @param paymentMoney     结算金额	
	 * @param paymentDate      结算时间 
	 */
	public TDemandPayment(Long id, TCompany company, TTask task,
			Date startDate, Date endDate, Long statisticsAmount,
			Long approvedAmount, Double paymentMoney, Date paymentDate) {
		super();
		this.id = id;
		this.company = company;
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statisticsAmount = statisticsAmount;
		this.approvedAmount = approvedAmount;
		this.paymentMoney = paymentMoney;
		this.paymentDate = paymentDate;
	}

	/**
	 * 初始化company、task属性的构造方法
	 * @param company
	 * @param task
	 */
	public TDemandPayment(TCompany company, TTask task) {
		super();
		this.company = company;
		this.task = task;
	}

	/**
	 * 获取需求方结算实体的id号
	 * @return 需求方结算实体的id号
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置需求方结算实体的id号
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	

	/**
	 * 获取需求方结算实体的需求客户
	 * @return 需求方结算实体需求客户
	 */
	public TCompany getCompany() {
		return company;
	}
	
	/**
	 * 设置需求方结算实体的需求客户
	 * @param TCompany 需求客户
	 */
	public void setCompany(TCompany company) {
		this.company = company;
	}

	/**
	 * 获取需求方结算实体的任务
	 * @return 需求方结算实体的任务
	 */
	public TTask getTask() {
		return task;
	}

	/**
	 * 设置需求方结算实体的任务
	 * @param iTTask 任务
	 */
	public void setTask(TTask task) {
		this.task = task;
	}

	/**
	 * 获取需求方结算的开始时间
	 * @return 需求方结算实体的开始时间
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 设置需求方结算实体的开始时间
	 * @param startDate 开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 获取需求方结算实体的结束时间
	 * @return 需求方结算实体的结束时间
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 设置需求方结算实体的结束时间
	 * @param endDate 结束时间
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 获取需求方结算实体的统计量
	 * @return 需求方结算实体的统计量
	 */
	public Long getStatisticsAmount() {
		return statisticsAmount;
	}

	/**
	 * 设置需求方结算实体的统计量
	 * @param statisticsAmount 统计量
	 */
	public void setStatisticsAmount(Long statisticsAmount) {
		this.statisticsAmount = statisticsAmount;
	}

	/**
	 * 获取需求方结算实体的许可量
	 * @return 需求方结算实体的许可量
	 */
	public Long getApprovedAmount() {
		return approvedAmount;
	}

	/**
	 * 设置需求方结算实体的许可量
	 * @param approvedAmount 许可量
	 */
	public void setApprovedAmount(Long approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	/**
	 * 获取需求方结算实体的结算金额
	 * @return 需求方结算实体的结算金额
	 */
	public Double getPaymentMoney() {
		return paymentMoney;
	}
	
	/**
	 * 设置需求方结算实体的结算金额
	 * @param paymentMoney 结算金额
	 */
	public void setPaymentMoney(Double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	/**
	 * 获取需求方结算实体的结算日期
	 * @return 需求方结算实体的结算日期
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * 设置需求方结算实体的结算日期
	 * @param paymentDate 结算日期
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
