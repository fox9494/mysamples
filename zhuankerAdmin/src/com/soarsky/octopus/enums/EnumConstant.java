package com.soarsky.octopus.enums;



/**
 * 定义枚举状态常量
 * @author chenll
 *
 */
public enum EnumConstant {
	
	
	MENU("0","菜单模块"),
	NONEMENU("1","非菜单模块"),
	
	NORMAL("0","未过期"),
	EXPIRE("1","过期"),
	;
	
	private EnumConstant(String code,String name) {
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 状态值
	 */
	private String	code;
	/**
	 * 状态值对应的名称
	 */
	private String	name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
