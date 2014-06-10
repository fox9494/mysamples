package com.soarsky.octopus.payment.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.soarsky.octopus.mapping.TChannelPayment;
import com.soarsky.octopus.payment.vo.Channel;
import com.soarsky.octopus.utils.PageBean;

/**
 * 处理渠道结算相关的业务逻辑接口
 * @author ouyang
 *
 */
public interface TChannelPaymentService {

	/**
	 * 分页查询已经与渠道方已经结算过的详细信息
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @return 处理分页数据显示的实体
	 */
	public PageBean queryListPage(int dEFAULTPAGESIZE, Integer currentPage, Long channelId, Date startDate, Date endDate);

	/**
	 * 查询渠道简要信息列表跑
	 * @return 渠道简要信息列表跑
	 */
	public List<Channel> queryChannelList();

	/**
	 * 根据渠道id查询该渠道最后一次结算的结束时间
	 * @param channelId 渠道id
	 * @return 该渠道最后一次结算的结束日期
	 */
	public Date queryLastDate(Long channelId);

	/**
	 * 根据channelId、startDate、endtDate统计指定渠道在startDate、endtDate之间的完成所有任务数、所赚取金币数、等价金额
	 * @param channelId
	 * @param startDate
	 * @param endtDate
	 * @return 所有任务数taskStatistics、所赚取金币数coinStatistics、等价金额paymentMoney
	 */
	public Map<String, Object> statistics(Long channelId, Date startDate,
			Date endtDate);

	/**
	 * /保存新添加的渠道结算相关数据
	 * @param channelPayment 需要保存到数据库的结算相关数据
	 */
	public void saveChannelPayment(TChannelPayment channelPayment);

}
