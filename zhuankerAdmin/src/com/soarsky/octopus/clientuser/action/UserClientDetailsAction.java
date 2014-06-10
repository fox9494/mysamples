package com.soarsky.octopus.clientuser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.soarsky.octopus.clientuser.constant.Constellation;
import com.soarsky.octopus.clientuser.constant.ShengXiao;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.clientuser.service.TUserClientService;
import com.soarsky.octopus.clientuser.service.TUserGoldCountService;
import com.soarsky.octopus.clientuser.service.TUserHobbiesService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TProfessio;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserGoldCount;

public class UserClientDetailsAction extends BaseAction {

	private static final long serialVersionUID = -4500433811419238458L;

	private TUserClientService tUserClientService;

	private TUserClient userclient;

	private TUserClient parantuserclient;

	private TAreaService tAreaService;

	private TProfessio profession;

	private TArea city;// 市

	private TArea province;// 省
	
	private TUserGoldCountService tUserGoldCountService;
	
	private TUserHobbiesService tUserHobbiesService;

	private TUserGoldCount userGoldCount;
	// 根据用户id得到相应的爱好
	private List<THobbies> hobbiesList = new ArrayList<THobbies>();
	// 奴隶数
	private long childrenCount;
	//当前用户排名
	private long ranking;
	//用户生肖
	private String shengXiaoStr;
	//用户星座
	private String constellationStr;
	//当前用户级别
	private String level;
	

	/**
	 * 初始化客户详情信息
	 * 
	 * @author lw yl
	 * @return
	 */
	public String initUserDetails() {
		
		userclient = tUserClientService.initUserClient(userclient);
		//用户当前的级别
		level = getLevel(userclient);
		// 当前用户排名
		 ranking = tUserGoldCountService.findRankingByUserGold(userclient.getId());

		 if(userclient.getShengxiao()!=null){
				shengXiaoStr = getShengXiao(userclient.getShengxiao());
			}
		if(userclient.getConstellation()!=null){
			   constellationStr = getConstellation(Integer.parseInt(userclient.getConstellation()));
			}
		// 奴隶数
		childrenCount = tUserGoldCountService.findChildrenByUserId(userclient.getId());
		profession = userclient.gettProfessio();
		// 用户金币统计
		userGoldCount = tUserGoldCountService.findUserGoldCountByUserId(userclient.getId());				
		// 查询市
		city = userclient.gettArea();					
		//当前用户 爱好
		hobbiesList = tUserHobbiesService.findHobbiesByUserId(userclient.getId());	
						
		// 查询省
		if(city!=null){
			province = tAreaService.findAreaByClientId(city.getParentId());
		}
		

		/*if (userclient.getParentId() != null) {

			TUserClient newuserclient = new TUserClient();

			newuserclient.setId(userclient.getParentId());

			// 查询父MID
			parantuserclient = tUserClientService.initUserClient(newuserclient);


		}*/

		return "initsuccess";
	}

	//根据id返回相应的生肖
	private String getShengXiao(int value){
		if(value>=0&&value<12){
			return ShengXiao.shengXiao[value];
		}
		else{
			return null;
		}	
	}
	//根据id返回星座
	private String getConstellation(int value){
		if(value>=0&&value<12){
			return Constellation.constellation[value];
		}else{
			return null;
		}
		
	}
	//返回当前用户的级别
	private String getLevel(TUserClient userClient){
		String  code=null;
		Set<TUserGoldCount> gold = userClient.gettUserGoldCounts();
		for(TUserGoldCount set:gold){
			code=tUserClientService.getAllUserLevel(set.getTotal_gold());
		}
		return code;
	}
	public TUserGoldCount getUserGoldCount() {
		return userGoldCount;
	}

	public void setUserGoldCount(TUserGoldCount userGoldCount) {
		this.userGoldCount = userGoldCount;
	}

	public void settUserGoldCountService(
			TUserGoldCountService tUserGoldCountService) {
		this.tUserGoldCountService = tUserGoldCountService;
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

	public TUserClient getParantuserclient() {
		return parantuserclient;
	}

	public void setParantuserclient(TUserClient parantuserclient) {
		this.parantuserclient = parantuserclient;
	}

	public TProfessio getProfession() {
		return profession;
	}

	public void setProfession(TProfessio profession) {
		this.profession = profession;
	}

	public TArea getCity() {
		return city;
	}

	public void setCity(TArea city) {
		this.city = city;
	}

	public TArea getProvince() {
		return province;
	}

	public void setProvince(TArea province) {
		this.province = province;
	}

	public TAreaService gettAreaService() {
		return tAreaService;
	}

	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}

	public void settUserHobbiesService(TUserHobbiesService tUserHobbiesService) {
		this.tUserHobbiesService = tUserHobbiesService;
	}

	public List<THobbies> getHobbiesList() {
		return hobbiesList;
	}

	public void setHobbiesList(List<THobbies> hobbiesList) {
		this.hobbiesList = hobbiesList;
	}

	public long getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(long childrenCount) {
		this.childrenCount = childrenCount;
	}

	public long getRanking() {
		return ranking;
	}

	public void setRanking(long ranking) {
		this.ranking = ranking;
	}


	public String getShengXiaoStr() {
		return shengXiaoStr;
	}
	public void setShengXiaoStr(String shengXiaoStr) {
		this.shengXiaoStr = shengXiaoStr;
	}
	public String getConstellationStr() {
		return constellationStr;
	}
	public void setConstellationStr(String constellationStr) {
		this.constellationStr = constellationStr;
	}

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}


}
