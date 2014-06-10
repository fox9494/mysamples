package com.soarsky.octopus.channel.service.impl;


import java.util.List;
import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.channel.dao.TChannelIndustryDAO;
import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.utils.PageBean;

public class TChannelIndustryServiceImpl implements TChannelIndustryService {
        
	private TChannelIndustryDAO tChannelIndustryDAO;
	
	/**
	 * 添加行业
	 * @author lw
	 * @param  channelIndustry 行业对象
    */
	public void addChannelIndustry(TChannelIndustry channelIndustry) {
		
		tChannelIndustryDAO.save(channelIndustry);
	}
    
	/**
	 * 删除行业
	 * @author lw
	 * @param  channelIndustry 行业对象
	*/
	public void deleteChannelIndustry(TChannelIndustry channelIndustry) {
		
		TChannelIndustry oldChannelIndustry=initChannelIndustry(channelIndustry);
		
		oldChannelIndustry.setIsRemove(ChannelContent.ROMOVE);
		
	}
	
    /**
     * 分页查询所有行业
     * @author lw
     * @param  maxresult 每页最大条数
     * @param  currentpage 当前页数
     * @param  channelIndustry 要查询的对象
     * @return
	*/
	public PageBean getChannelIndustryList(int maxresult, int currentpage,TChannelIndustry channelIndustry) {
		
		return tChannelIndustryDAO.findChannelIndustryList(maxresult,currentpage,channelIndustry);
	}
     
	/**
	 * 修改行业对象
	 * @author lw
	 * @param  channelIndustry 要修改的行业对象
	*/
	public void updateChannelIndustry(TChannelIndustry channelIndustry) {
		
		tChannelIndustryDAO.update(channelIndustry);
	}
	
	/**
	 * 初始化要查询的行业对象
	 * @author lw
	 * @param channelIndustry 行业对象
	 * @return
	*/
	public TChannelIndustry initChannelIndustry(TChannelIndustry channelIndustry) {
		
		return tChannelIndustryDAO.getById(TChannelIndustry.class,channelIndustry.getId());
	}
    	
	/**
	 * 查询所有的行业对象
	 * @author lw
	 * @return
	 */
	public List<TChannelIndustry> findAllChannelIndustry() {
		
		return tChannelIndustryDAO.queryAllChannelIndustry();
	}
	
	/**
	 * 根据行业名称查询行业
	 * @param channelIndustry 行业对象
	 * @return
	*/
	public Boolean findChannelIndustryByName(TChannelIndustry channelIndustry) {
		
		return tChannelIndustryDAO.findIndustryByName(channelIndustry);
	}

	public TChannelIndustryDAO gettChannelIndustryDAO() {
		return tChannelIndustryDAO;
	}

	public void settChannelIndustryDAO(TChannelIndustryDAO tChannelIndustryDAO) {
		this.tChannelIndustryDAO = tChannelIndustryDAO;
	}
	
	
}  
