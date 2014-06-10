package com.soarsky.octopus.clientuser.list;

public class User {
	private Long id;
	private String userName;
	
	private String nickName;
	private String leveCode;
	private String phone;
	private String email;
	private Long  total_gold;
	private Long current_gold;

	public User() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLeveCode() {
		return leveCode;
	}
	public void setLeveCode(String leveCode) {
		this.leveCode = leveCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTotal_gold() {
		return total_gold;
	}
	public void setTotal_gold(Long total_gold) {
		this.total_gold = total_gold;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User(Long id, String userName, String nickName, String leveCode,
			String phone, String email, Long total_gold) {
		super();
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
		this.leveCode = leveCode;
		this.phone = phone;
		this.email = email;
		this.total_gold = total_gold;
	}
	public Long getCurrent_gold() {
		return current_gold;
	}
	public void setCurrent_gold(Long current_gold) {
		this.current_gold = current_gold;
	}
}
