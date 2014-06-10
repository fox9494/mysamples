package com.soarsky.octopus.clientuser.action;

import java.util.ArrayList;
import java.util.List;

import com.soarsky.octopus.clientuser.service.TUserClientService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.utils.PageBean;

public class UserClientListAction extends PageAction {

	private static final long serialVersionUID = -7846613105195585526L;
    
	private TUserClientService tUserClientService;
    
	private TUserClient  userclient;
	
	private List<THobbies> hobbies;
	
	private Long province;
	
	private TArea area;
	
	private Integer startage;
	
	private List<Long> hobbiesids=new ArrayList<Long>();
	
	private Integer endage;
	/**
	 * 分页查询所有用户
	 * @author lw
	 * @return
	*/
	public String searchList(){
		
		pageBean=tUserClientService.getUserClientList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
	
	/**
	 *根据条件查询用户
	 *@author lw
	 *@return 
	*/
	public String findUserByConditions(){
	    if(hobbies!=null){
			for(THobbies hobbie:hobbies){
				hobbiesids.add(hobbie.getHobbiesid());
			}
	    }
		userclient.settArea(area);
		
		pageBean=tUserClientService.getUserClientByConditions(PageBean.DEFAULTPAGESIZE, currentPage,userclient,hobbies,startage,endage);
		
		return "findbyconditions";
	}
	
	public TUserClientService gettUserClientService() {
		return tUserClientService;
	}

	public void settUserClientService(TUserClientService tUserClientService) {
		this.tUserClientService = tUserClientService;
	}

	public TUserClient getUserclient() {
		return userclient;
	}

	public void setUserclient(TUserClient userclient) {
		this.userclient = userclient;
	}

	public TArea getArea() {
		return area;
	}

	public void setArea(TArea area) {
		this.area = area;
	}

	public Integer getStartage() {
		return startage;
	}

	public void setStartage(Integer startage) {
		this.startage = startage;
	}

	public Integer getEndage() {
		return endage;
	}

	public void setEndage(Integer endage) {
		this.endage = endage;
	}

	public List<THobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<THobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public List<Long> getHobbiesids() {
		return hobbiesids;
	}

	public void setHobbiesids(List<Long> hobbiesids) {
		this.hobbiesids = hobbiesids;
	}
}
