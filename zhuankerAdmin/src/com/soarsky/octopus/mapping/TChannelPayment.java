package com.soarsky.octopus.mapping;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应数据库中需求方结算表（T_DEMAND_PAYMENT）的实体类
 * @author ouyang
 *
 */
public class TChannelPayment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long channelPaymentId;  //主键channelPaymentId		NUMBER(20)      
    private TChannel channel;       //渠道id		NUMBER(10)      
    private Date startDate;         //开始时间		DATE
    private Date endDate;           //结束时间		DATE    
    private Long taskStatistics;    //任务统计量	NUMBER(20)      
    private Long coinStatistics;    //金币统计量			NUMBER(20)      
    private Double paymentMoney;    //结算金额		NUMBER(14,2)    
    private Date paymentDate;       //结算时间   	DATE            
    
    /**
     * 空的构造方法
     */
	public TChannelPayment() {
	}
	
	/**
	 * 初始化channelPaymentId的构造方法
	 * @param channelPaymentId
	 */
	public TChannelPayment(Long channelPaymentId) {
		this.channelPaymentId = channelPaymentId;
	}

	/**
	 * 初始化所有属性的构造方法
	 * @param channelPaymentId 主键channelPaymentId	
	 * @param channel          渠道对象
	 * @param startDate        开始时间	
	 * @param endDate          结束时间	
	 * @param taskStatistics   任务统计量	
	 * @param coinStatistics   金币统计量	
	 * @param paymentMoney     结算金额	
	 * @param paymentDate      结算时间 
	 */
	public TChannelPayment(Long channelPaymentId, TChannel channel,
			Date startDate, Date endDate, Long taskStatistics,
			Long coinStatistics, Double paymentMoney, Date paymentDate) {
		super();
		this.channelPaymentId = channelPaymentId;
		this.channel = channel;
		this.startDate = startDate;
		this.endDate = endDate;
		this.taskStatistics = taskStatistics;
		this.coinStatistics = coinStatistics;
		this.paymentMoney = paymentMoney;
		this.paymentDate = paymentDate;
	}

	public Long getChannelPaymentId() {
		return channelPaymentId;
	}

	public void setChannelPaymentId(Long channelPaymentId) {
		this.channelPaymentId = channelPaymentId;
	}

	public TChannel getChannel() {
		return channel;
	}

	public void setChannel(TChannel channel) {
		this.channel = channel;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getTaskStatistics() {
		return taskStatistics;
	}

	public void setTaskStatistics(Long taskStatistics) {
		this.taskStatistics = taskStatistics;
	}

	public Long getCoinStatistics() {
		return coinStatistics;
	}

	public void setCoinStatistics(Long coinStatistics) {
		this.coinStatistics = coinStatistics;
	}

	public Double getPaymentMoney() {
		return paymentMoney;
	}

	public void setPaymentMoney(Double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
