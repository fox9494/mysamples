package com.soarsky.octopus.payment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.soarsky.octopus.channel.dao.TChannelDAO;
import com.soarsky.octopus.channel.service.TChannelInviteService;
import com.soarsky.octopus.clientuser.dao.TUserTaskDAO;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TChannelPayment;
import com.soarsky.octopus.payment.dao.TChannelPaymentDAO;
import com.soarsky.octopus.payment.service.TChannelPaymentService;
import com.soarsky.octopus.payment.vo.Channel;
import com.soarsky.octopus.utils.PageBean;

/**
 * 实现了渠道结算相关的业务逻辑接口的实体类
 * @author ouyang
 *
 */
public class TChannelPaymentServiceImpl implements TChannelPaymentService {
	
	private TChannelPaymentDAO channelPaymentDAO;//针对渠道结算表进行数据持久化操作的对象
	private TChannelDAO channelDAO;//针对渠道信息表进行数据持久化操作的对象
	private TUserTaskDAO userTaskDAO;//针对用户任务表进行数据持久操作的对象

	/**
	 * 分页查询已经与渠道方已经结算过的详细信息
	 * @param pageSize 每页显示记录数
	 * @param currentPage 当前页数
	 * @return 处理分页数据显示的实体
	 */
	@Override
	public PageBean queryListPage(int dEFAULTPAGESIZE, Integer currentPage, Long channelId, Date startDate, Date endDate) {
		
		return channelPaymentDAO.queryForPage(dEFAULTPAGESIZE, currentPage, channelId, startDate, endDate);
		
	}
	
	/**
	 * 查询渠道简要信息列表跑
	 * @return 渠道简要信息列表跑
	 */
	@Override
	public List<Channel> queryChannelList() {

		List<TChannel> tchannels = channelDAO.queryTChannelByParentId(JEEContant.ZERO_LEVEL_CHANNEL);
		List<Channel> channels = new ArrayList<Channel>();
		if(tchannels!=null && tchannels.size()!=0) {
			for(TChannel tChannel : tchannels) {
				Channel channel = new Channel(tChannel.getId(), tChannel.getChannelName());
				channels.add(channel);
			}
		}
		return  channels;
		
	}
	
	/**
	 * 根据渠道id查询该渠道最后一次结算的结束时间
	 * @param channelId 渠道id
	 * @return 该渠道最后一次结算的结束日期
	 */
	@Override
	public Date queryLastDate(Long channelId) {

		//根据渠道id查询渠道结算表中最后一次结算的endDate即查询渠道结算表中某渠道结算信息的最大的endDate
		Date date = channelPaymentDAO.queryMaxEndDate(channelId);
		return date;
	}
	
	/**
	 * 根据channelId、startDate、endtDate统计指定渠道在startDate、endtDate之间的完成所有任务数、所赚取金币数、等价金额
	 * @param channelId
	 * @param startDate
	 * @param endDate
	 * @return 所有任务数taskStatistics、所赚取金币数coinStatistics、等价金额paymentMoney
	 */
	@Override
	public Map<String, Object> statistics(Long channelId, Date startDate,
			Date endDate) {
		//"select count(*),sum(ut.gold_num) from t_user_task ut left join T_USER_CLIENT uc on ut.user_id = uc.id  where u.id like '200000001%'"
		
		TChannel channel = channelDAO.getById(TChannel.class,channelId);
		String levelCode = channel.getLevelCode() + "%";
		//该渠道结算等级
		Double paylevel = channel.getPaylevel();
		
		//查询某渠道下所有用户完成的任务总数、完成任务获得的金币总数（不包括完善个人资料所得金币）
		Map<String,Object> statisticsData =  userTaskDAO.queryStatistics(levelCode, startDate, endDate);
		Long coinStatistics = (Long) statisticsData.get("coinStatistics");
		//
		if(coinStatistics == null) {
			coinStatistics = 0L;
		}
		//查询当前渠道下在 startDate,endDate这段期间内有哪些用户完善个人资料得到了金币，对他们求和
		List<Object> params = new ArrayList<Object>();
		String hql = " select sum(currentExchangeNum) from TGoldChange where operateType=6 and TUserClient.leveCode like ? ";
		params.add(levelCode);
		if(startDate != null) {
			hql += " and dealDate>=? ";
			params.add(startDate);
		}
		if(endDate != null) {
			hql += " and dealDate<? ";
			params.add(endDate);
		}
		//完善资料获得的金币数
		Long perfectInforGold = (Long) channelPaymentDAO.queryUniqueResult(hql, params);
		if(perfectInforGold != null) {
			coinStatistics = coinStatistics+perfectInforGold;
		}
		statisticsData.put("coinStatistics", coinStatistics);
		
		//计算结算金额，结算金额 = 累计所赚金币数 * 渠道的结算等级 * 兑换比例
		Double paymentMoney = coinStatistics*paylevel*JEEContant.SHARE_RATIO;
		//查询渠道下所有用户完成任务获得金币总数
		statisticsData.put("paymentMoney", paymentMoney);
		return statisticsData;
		
	}

	/**
	 * /保存新添加的渠道结算相关数据
	 * @param channelPayment 需要保存到数据库的结算相关数据
	 */
	@Override
	public void saveChannelPayment(TChannelPayment channelPayment) {
		//保存渠道结算是数据
		channelPaymentDAO.save(channelPayment);
	}

	
	public TChannelPaymentDAO getChannelPaymentDAO() {
		return channelPaymentDAO;
	}

	public void setChannelPaymentDAO(TChannelPaymentDAO channelPaymentDAO) {
		this.channelPaymentDAO = channelPaymentDAO;
	}

	public TChannelDAO getChannelDAO() {
		return channelDAO;
	}

	public void setChannelDAO(TChannelDAO channelDAO) {
		this.channelDAO = channelDAO;
	}

	public TUserTaskDAO getUserTaskDAO() {
		return userTaskDAO;
	}

	public void setUserTaskDAO(TUserTaskDAO userTaskDAO) {
		this.userTaskDAO = userTaskDAO;
	}

}
