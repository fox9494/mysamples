package com.soarsky.octopus.payment.vo;

/**
 * 用于后台服务器与页面通信时封装需求方（客户）简要信息：id和名字
 * @author ouyang
 *
 */
public class Company {
	
    private Long id;    //客户id号
    private String name;//客户名字
    
	public Company() {
		super();
	}
	/**
	 * 初始化客户id号和名字
	 * @param id
	 * @param name
	 */
	public Company(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 获取客户id号
	 * @return 客户id号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设定客户id号
	 * @param id 客户id号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取客户名字
	 * @return 客户名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设定客户名字
	 * @param name客户名字
	 */
	public void setName(String name) {
		this.name = name;
	}
    
}
