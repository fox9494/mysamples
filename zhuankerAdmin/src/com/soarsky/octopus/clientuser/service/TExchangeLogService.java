package com.soarsky.octopus.clientuser.service;


import java.util.List;

import com.soarsky.octopus.clientuser.vo.ExchangeMsg;
import com.soarsky.octopus.mapping.TExchangeLog;
import com.soarsky.octopus.utils.PageBean;

public interface TExchangeLogService {
	/**
	 * 分页显示兑换记录列表
	 * @param maxResult 最大记录数
	 * @param currentPage 当前页数
	 * @param usreId 当前用户id
	 * @return
	 */
	public PageBean findAllExchangeLog(int maxResult, int currentPage,long userId);
	/**
	 * 用户结算
	 * @param maxResult
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllPayMent(int maxResult,int currentPage);	
	/**
	 * 条件查询用户结算
	 * @param maxResult
	 * @param currentPage 
	 * @param startYear 开始日期
	 * @param endYear 结算日期
	 * @param status 状态
	 * @param account 账号
	 * @return
	 */
	public PageBean findPayMentByParams(int maxResult,int currentPage,String startYear,String endYear,TExchangeLog exLog);
	/**
	 * 用户结算审核
	 * @param id
	 * @return
	 */
	public void savePayMentChecked(List<Long> idList);
	/**
	 * 支付完成
	 * @param id
	 */
	public void savePayMentPayed(List<Long> idList);
	/**
	 * 取消兑换
	 * @param ids
	 */
	public void savePayMentUnChecked(List<Long> idList);
	/**
	 * 筛选符合条件的id集合
	 * @param idList 传入的id集合
	 * @param status 当前状态
	 * @return
	 */
	public List<Long> getAllId(String ids,int status);
	/**
	 *数组转换成list，并返回
	 */
	public List<Long> getIdList(String ids) ;
	/**
	 * 返回兑换的相关信息（礼品信息）
	 * @param idList
	 * @return
	 */
	public List<ExchangeMsg> getInfos(List<Long> idList);
}
