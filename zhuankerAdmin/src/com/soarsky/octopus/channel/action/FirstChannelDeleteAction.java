package com.soarsky.octopus.channel.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.channel.vo.FlagMsg;
import com.soarsky.octopus.common.action.BaseAction;

public class FirstChannelDeleteAction extends BaseAction{

	
	private static final long serialVersionUID = -8861351681956919193L;
	
	private TChannelService tChannelService;
	//一级渠道的id
	private String ids;
	
	public Map<String,Object> map ;
	
	public FlagMsg msg;


	/**
	 * 删除一级渠道
	 * @return
	 */
	public String deleteChannel(){	
		//删除之前判断是否有子渠道
		tChannelService.deleteFirstChannel(ids);
		return SUCCESS;
	}
	
	public String isHaveChannel(){
		boolean flag = tChannelService.isHaveChannel(ids);
		msg = new FlagMsg();
		msg.setFlag(flag);		
		return "check";
	}
	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public FlagMsg getMsg() {
		return msg;
	}

	public void setMsg(FlagMsg msg) {
		this.msg = msg;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


}
