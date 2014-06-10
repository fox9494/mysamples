package com.soarsky.octopus.mapping;

public class TTopUpLog implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long topUpLogId;    //主键id
	private String partner;		//String(10) 代理商 ID N 
	private TTopUpResultType topUpResultType; 	//Integer 订单提交返回消息 类型N 
	private String outTradeId; 	//String(10) 代理商交易序号（唯一） N 
	private String state; 		//String (10) ok 交易成功 , doing 充值中 ,fail 失败, return 已 经退货 N 
	private String topUpAccount; 	//String(100) 充值的账号 N
	private Integer productId; 	//Integer 充值的产品序号 N 
	private Integer quantity; 	//Integer 数量 N 
	private Integer price; 		//Integer 实际扣款金额 单位分 N 
	private String productInfo;	//String 产品信息 Y
	
	public TTopUpLog() {
		super();
	}

	public TTopUpLog(String partner, TTopUpResultType topUpResultType,
			String outTradeId, String state, String topUpAccount,
			Integer productId, Integer quantity, Integer price,
			String productInfo) {
		super();
		this.partner = partner;
		this.topUpResultType = topUpResultType;
		this.outTradeId = outTradeId;
		this.state = state;
		this.topUpAccount = topUpAccount;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.productInfo = productInfo;
	}

	public TTopUpLog(Long topUpLogId, String partner,
			TTopUpResultType topUpResultType, String outTradeId, String state,
			String topUpAccount, Integer productId, Integer quantity,
			Integer price, String productInfo) {
		super();
		this.topUpLogId = topUpLogId;
		this.partner = partner;
		this.topUpResultType = topUpResultType;
		this.outTradeId = outTradeId;
		this.state = state;
		this.topUpAccount = topUpAccount;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.productInfo = productInfo;
	}

	public Long getTopUpLogId() {
		return topUpLogId;
	}

	public void setTopUpLogId(Long topUpLogId) {
		this.topUpLogId = topUpLogId;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public TTopUpResultType getTopUpResultType() {
		return topUpResultType;
	}

	public void setTopUpResultType(TTopUpResultType topUpResultType) {
		this.topUpResultType = topUpResultType;
	}

	public String getOutTradeId() {
		return outTradeId;
	}

	public void setOutTradeId(String outTradeId) {
		this.outTradeId = outTradeId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTopUpAccount() {
		return topUpAccount;
	}

	public void setTopUpAccount(String topUpAccount) {
		this.topUpAccount = topUpAccount;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

}
