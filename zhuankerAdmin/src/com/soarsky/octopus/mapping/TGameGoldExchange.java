package com.soarsky.octopus.mapping;

import java.util.Date;

public class TGameGoldExchange {
    private Long id;//业务流水号
    private TUserClient TUserClient;//用户
    private Long gold;//本次操作金币
    private String description;//业务描述
    private Date operateDate;
    private String operateType;
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public Long getId() {
		return id;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public TUserClient getTUserClient() {
		return TUserClient;
	}
	public void setTUserClient(TUserClient userClient) {
		TUserClient = userClient;
	}
	public Long getGold() {
		return gold;
	}
	public void setGold(Long gold) {
		this.gold = gold;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
