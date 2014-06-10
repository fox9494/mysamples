/**
 * 
 */
package com.soarsky.octopus.reports.vo;

/**
 * 
 * 赚客用户统计查询使用VO
 * @author zengganghong
 * @date 2013-5-10
 */
public class UserReportVo 
{
	/**
	 * 统计类型名称:总量统计、按渠道、按区域、按赚客级别
	 */
	private String statName;
	
	/**
	 * 注册用户统计数量
	 */
	private Integer registerUser_Count;
	
	/**
	 * 活跃用户统计数量：最近一个月登陆的用户
	 */
	private Integer activeUser_Count;

	/**
	 * @return the statName
	 */
	public String getStatName() {
		return statName;
	}

	/**
	 * @param statName the statName to set
	 */
	public void setStatName(String statName) {
		this.statName = statName;
	}

	/**
	 * @return the registerUser_Count
	 */
	public Integer getRegisterUser_Count() {
		return registerUser_Count;
	}

	/**
	 * @param registerUser_Count the registerUser_Count to set
	 */
	public void setRegisterUser_Count(Integer registerUser_Count) {
		this.registerUser_Count = registerUser_Count;
	}

	/**
	 * @return the activeUser_Count
	 */
	public Integer getActiveUser_Count() {
		return activeUser_Count;
	}

	/**
	 * @param activeUser_Count the activeUser_Count to set
	 */
	public void setActiveUser_Count(Integer activeUser_Count) {
		this.activeUser_Count = activeUser_Count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("statName:"+statName);
		sbf.append(",registerUser_Count:"+registerUser_Count);
		sbf.append(",activeUser_Count:"+activeUser_Count);
		return sbf.toString();
	}

}
