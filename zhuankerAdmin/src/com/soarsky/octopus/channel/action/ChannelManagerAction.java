/**
 * <p>Title: ChannelManagerAction</p>
 * <p>Description: com.soarsky.octopus.channel.action</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: zhuanker</p>
 * @author   DavidT
 * @date      2013-3-20
 * @description 渠道管理页面Action
 */
package com.soarsky.octopus.channel.action;

import java.util.List;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.utils.PageBean;

public class ChannelManagerAction  extends PageAction {
	private static final long serialVersionUID = 5750493685176299440L;
	
	private TChannelService tChannelService;
	
	private List<TreeData> resultList;
	
	private Integer length; //当前Id下的子节点个数
	
	private Long channelId;
	
	private TChannel channel;
	
	private String leveCode;
	
	private TChannel channelX;
	
	private String currentCode;
	
	private Long superiorId;
	
	
	/**
	 * 显示渠道管理
	 * @author ldl
	 * 
	 */
	public String findTree(){
		
		Long managerId = (Long) this.getSession().get(JEEContant.SESSION_LOGIN_TOKENID);	
		resultList=this.tChannelService.findTree(managerId);
		return SUCCESS;
	}
	public String findByCode(){
		Long managerId = (Long) this.getSession().get(JEEContant.SESSION_LOGIN_TOKENID);	
		leveCode=this.tChannelService.findByManagerIdChannel(managerId).getLevelCode();
		return "findbycode";
		
	}
	
	/**
	 * 展示渠道的内容
	 * @param channelList
	 */
	public String findAllChannel(){
			pageBean=this.tChannelService.findAllChannel(channelId,pageBean.DEFAULTPAGESIZE,currentPage);
			return SUCCESS;
		
	}
	
	public String findAllChannel2(){
		pageBean=this.tChannelService.findAllChannel(channelId,pageBean.DEFAULTPAGESIZE,currentPage);
		return "channel";
		
	}
	
	
	


	
	public TChannelService gettChannelService() {
		return tChannelService;
	}

	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}

	public List<TreeData> getResultList() {
		return resultList;
	}

	public void setResultList(List<TreeData> resultList) {
		this.resultList = resultList;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public TChannel getChannel() {
		return channel;
	}

	public void setChannel(TChannel channel) {
		this.channel = channel;
	}

	public String getLeveCode() {
		return leveCode;
	}

	public void setLeveCode(String leveCode) {
		this.leveCode = leveCode;
	}

	public TChannel getChannelX() {
		return channelX;
	}

	public void setChannelX(TChannel channelX) {
		this.channelX = channelX;
	}
	public String getCurrentCode() {
		return currentCode;
	}
	public void setCurrentCode(String currentCode) {
		this.currentCode = currentCode;
	}
	public Long getSuperiorId() {
		return superiorId;
	}
	public void setSuperiorId(Long superiorId) {
		this.superiorId = superiorId;
	}
	
	
	
	
	

	
	
	
	
	

}
