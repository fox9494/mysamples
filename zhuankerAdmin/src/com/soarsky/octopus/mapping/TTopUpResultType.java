package com.soarsky.octopus.mapping;

public class TTopUpResultType implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer resultTypeId;//订单提交返回信息类型
	
	private String info;//类型对应详细信息

	public TTopUpResultType() {
		super();
	}
	
	public TTopUpResultType(Integer resultTypeId) {
		super();
		this.resultTypeId = resultTypeId;
	}

	public TTopUpResultType(Integer resultTypeId, String info) {
		super();
		this.resultTypeId = resultTypeId;
		this.info = info;
	}

	public Integer getResultTypeId() {
		return resultTypeId;
	}

	public void setResultTypeId(Integer resultTypeId) {
		this.resultTypeId = resultTypeId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
