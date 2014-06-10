package com.soarsky.octopus.clientuser.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.lang3.StringUtils;


import com.soarsky.octopus.clientuser.constant.ExchangeLogMsg;
import com.soarsky.octopus.clientuser.dao.TExchangeLogDAO;
import com.soarsky.octopus.clientuser.service.TExchangeLogService;
import com.soarsky.octopus.clientuser.vo.ExchangeMsg;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TExchangeLog;
import com.soarsky.octopus.mapping.TGoldChange;
import com.soarsky.octopus.mapping.TUserGoldCount;
import com.soarsky.octopus.utils.DateUtil;
import com.soarsky.octopus.utils.PageBean;


public class TExchangeLogServiceImpl implements TExchangeLogService {

	private TExchangeLogDAO tExchangeLogDAO;

	/**
	 * 日志兑换记录
	 * @author yl
	 */
	public PageBean findAllExchangeLog(int maxResult, int currentPage,long userId) {
		return tExchangeLogDAO.findAllExchangeLog(maxResult, currentPage,userId);
				
	}
	/**
	 * 用户结算
	 * @author yl
	 */
	public PageBean findAllPayMent(int maxResult, int currentPage) {	
		return tExchangeLogDAO.findAllPayMent(maxResult, currentPage);
	}
	/**
	 * 条件查询,用户结算
	 * @author yl
	 */
	public PageBean findPayMentByParams(int maxResult, int currentPage,
			String startYear, String endYear, TExchangeLog exLog) {
		Date start = null,end=null;		
		if(StringUtils.isNotEmpty(startYear)&&StringUtils.isNotEmpty(endYear)){
			try {
				start = DateUtil.getDateByString(startYear, JEEContant.PARRTEN);
				end = DateUtil.getDateByString(endYear, JEEContant.PARRTEN);
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			
		}
		return tExchangeLogDAO.findPayMentByParams(maxResult, currentPage, start, end, exLog);
	}
	/**
	 * 用户结算,审核(只有状态为申请的才能审核）
	 * @author yl
	 */
	public void savePayMentChecked(List<Long> idList) {				
				tExchangeLogDAO.savePayMentChecked(idList);
		
			
	}
	/**
	 * 用户结算，支付完成，只有状态为审核通过的才能进行支付
	 * 结算后，扣除兑换的金币
	 * @author yl
	 */
	public void savePayMentPayed(List<Long> idList) {
				List<ExchangeMsg> msgStr = getInfos(idList);												
				Map<Long,String> map = new HashMap<Long,String>();
				String date = DateUtil.getCurDateStr("yyyy-MM-dd");
				if(msgStr!=null){					
					for(ExchangeMsg list:msgStr){						
						StringBuffer sb = new StringBuffer();						
						sb.append(ExchangeLogMsg.BEGIN+date+ExchangeLogMsg.EXCHANGE+list.getDetails()+ExchangeLogMsg.OTHER);
						map.put(list.getId(), sb.toString());
					}						
				}
				tExchangeLogDAO.savePayMentPayed(map);				
	}
	/**
	 * 用户结算，取消兑换
	 * @author yl
	 */
	public void savePayMentUnChecked(List<Long> idList) {
		List<ExchangeMsg> msgStr = getInfos(idList);
		//取消兑换后，返回金币给用户
		backGoldtoUser(idList);
		Map<Long,String> map = new HashMap<Long,String>();	
		String date = DateUtil.getCurDateStr("yyyy-MM-dd");
		if(msgStr!=null){
			for(ExchangeMsg list:msgStr){
				StringBuffer sb = new StringBuffer();
				sb.append(ExchangeLogMsg.BEGIN+date+list.getDetails()+ExchangeLogMsg.REEOR+ExchangeLogMsg.REASON);
				map.put(list.getId(), sb.toString());
											
			}
			tExchangeLogDAO.savePayMentUnChecked(map);
		}
						
	}	
	/**
	 * 筛选符合条件的id集合
	 * @param idList 传入的id集合
	 * @param status 当前状态
	 * @author yl
	 * @return
	 */
	public List<Long> getAllId(String ids,int status) {		
		return tExchangeLogDAO.getAllId(getIdList(ids),status);
	}

	/**
	 * 数组转换成list，并返回 
	 * @author yl
	 */
	public List<Long> getIdList(String ids) {
		String[] idArray = ids.split(",");
		List<Long> idList  = new ArrayList<Long>();
		for(String id:idArray){
			idList.add(Long.valueOf(id));
		}
		return idList;
	}

	public TExchangeLogDAO gettExchangeLogDAO() {
		return tExchangeLogDAO;
	}
	public void settExchangeLogDAO(TExchangeLogDAO tExchangeLogDAO) {
		this.tExchangeLogDAO = tExchangeLogDAO;
	}
	/**
	 * 返回兑换的相关信息（礼品信息,礼品集合）
	 * @author yl
	 * @param idList
	 * @return
	 */
	public List<ExchangeMsg> getInfos(List<Long> idList) {
		
		List<ExchangeMsg> msgList = new ArrayList<ExchangeMsg>();
		List<TExchangeLog>	excLog = tExchangeLogDAO.getExchangeLog(idList);
		if(excLog!=null){
			for(TExchangeLog list:excLog){
				ExchangeMsg msg = new ExchangeMsg();
				msg.setDetails(list.getExchangeDetail());
				msg.setId(list.getId());
				msgList.add(msg);
			}			
		}
		return msgList;
	}
	/**
	 * 得到兑换的信息,扣除后的金币和用户id
	 * 用户和对应的金币
	 * @author yl
	 * @param idList
	 * @return
	 */
	public void backGoldtoUser(List<Long> idList){
		List<TGoldChange> list = new ArrayList<TGoldChange>();
		List<TExchangeLog> exchangeLogs = tExchangeLogDAO.getExchangeLog(idList);
		if(exchangeLogs!=null){
			for(TExchangeLog exlog:exchangeLogs){
				//用户的当前金币
				TUserGoldCount userGoldCount = tExchangeLogDAO.findByProperty(TUserGoldCount.class,"TUserClient", exlog.getTUserClient()).get(0);
				//返回扣除的金币
				userGoldCount.setCurrentGold(userGoldCount.getCurrentGold()+exlog.getGiftGold());	
				//保存用户金币变化日志
				TGoldChange goldChange = new TGoldChange();
				goldChange.setCurrentExchangeNum(exlog.getGiftGold());
				goldChange.setCurrentGold(userGoldCount.getCurrentGold());
				goldChange.setDealDate(new Date());
				goldChange.setOperateType(JEEContant.BACK_GOLD);
				goldChange.setTUserClient(exlog.getTUserClient());
				
				list.add(goldChange);
				//保证数据的及时行所以每次修改金币都保存
				tExchangeLogDAO.update(userGoldCount);
			}
			tExchangeLogDAO.batchAdd(list);
		}
		
	}
}
