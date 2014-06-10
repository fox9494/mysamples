package com.soarsky.octopus.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * TUserClient entity. @author MyEclipse Persistence Tools
 */

public class TUserClient  implements java.io.Serializable {


     // Fields    

     private Long id;
     private TArea tArea;
	 private Long parentId;
     private String userName;
     private String password;
     private String nickName;//昵称
     private String phone;
     private String constellation; //星座
     private String midcode;
     private String email;
     private Integer registerType;
     private Integer sex;
     private Integer shengxiao;
     private Date birthday;
     private Boolean iscompelete;
     private String token;
     private Date registerDate;
     private String apkUrl;
     private TChannel  channel;
     private Set tUserGoldCounts = new HashSet(0);
     private Set tSystemFlows = new HashSet(0);
     private Set tInstalledApks = new HashSet(0);
     private Set tExchangeLogs = new HashSet(0);
     private Set tDownloadInstallLogs = new HashSet(0);
     private Set tUserTasks = new HashSet(0);
     private Set tUserPositions = new HashSet(0);
     private Set tUserHobbieses = new HashSet(0);
     private Set tSuggections = new HashSet(0);
     private Set tGoldChanges = new HashSet(0);
     private Set tClientLoginLogs = new HashSet(0);
     private TProfessio tProfessio;
     private String leveCode;
     private Integer finishedTaskNum;
     private Integer age;
     private Long inviteCode;

    // Constructors
	public Integer getFinishedTaskNum() {
		return finishedTaskNum;
	}

	public void setFinishedTaskNum(Integer finishedTaskNum) {
		this.finishedTaskNum = finishedTaskNum;
	}

	/** default constructor */
    public TUserClient() {
    }

	/** minimal constructor */
    public TUserClient(Long id) {
        this.id = id;
    }
       
    public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/** full constructor */
	public TUserClient(Long id, TArea tArea, Long parentId, String userName,
			String password, String nickName, String phone,
			String constellation, String midcode, String email,
			Integer registerType, Integer sex, Integer shengxiao,
			Integer profession, Date birthday, Boolean iscompelete,
			String token, Date registerDate, Set tUserGoldCounts,
			Set tSystemFlows, Set tInstalledApks, Set tExchangeLogs,
			Set tDownloadInstallLogs, Set tUserTasks, Set tUserPositions,
			Set tUserHobbieses, Set tSuggections, Set tGoldChanges,
			Set tClientLoginLogs,TChannel channel) {
		super();
		this.id = id;
		this.tArea = tArea;
		this.parentId = parentId;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.phone = phone;
		this.constellation = constellation;
		this.midcode = midcode;
		this.email = email;
		this.registerType = registerType;
		this.sex = sex;
		this.shengxiao = shengxiao;
		this.birthday = birthday;
		this.iscompelete = iscompelete;
		this.token = token;
		this.registerDate = registerDate;
		this.tUserGoldCounts = tUserGoldCounts;
		this.tSystemFlows = tSystemFlows;
		this.tInstalledApks = tInstalledApks;
		this.tExchangeLogs = tExchangeLogs;
		this.tDownloadInstallLogs = tDownloadInstallLogs;
		this.tUserTasks = tUserTasks;
		this.tUserPositions = tUserPositions;
		this.tUserHobbieses = tUserHobbieses;
		this.tSuggections = tSuggections;
		this.tGoldChanges = tGoldChanges;
		this.tClientLoginLogs = tClientLoginLogs;
		this.channel = channel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getMidcode() {
		return midcode;
	}

	public void setMidcode(String midcode) {
		this.midcode = midcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public Integer getShengxiao() {
		return shengxiao;
	}

	public void setShengxiao(Integer shengxiao) {
		this.shengxiao = shengxiao;
	}

	@JSON(format="yyyy-MM-dd")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getIscompelete() {
		return iscompelete;
	}

	public void setIscompelete(Boolean iscompelete) {
		this.iscompelete = iscompelete;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Set gettUserGoldCounts() {
		return tUserGoldCounts;
	}

	public void settUserGoldCounts(Set tUserGoldCounts) {
		this.tUserGoldCounts = tUserGoldCounts;
	}

	public Set gettSystemFlows() {
		return tSystemFlows;
	}

	public void settSystemFlows(Set tSystemFlows) {
		this.tSystemFlows = tSystemFlows;
	}

	public Set gettInstalledApks() {
		return tInstalledApks;
	}

	public void settInstalledApks(Set tInstalledApks) {
		this.tInstalledApks = tInstalledApks;
	}

	public Set gettExchangeLogs() {
		return tExchangeLogs;
	}

	public void settExchangeLogs(Set tExchangeLogs) {
		this.tExchangeLogs = tExchangeLogs;
	}

	public Set gettDownloadInstallLogs() {
		return tDownloadInstallLogs;
	}

	public void settDownloadInstallLogs(Set tDownloadInstallLogs) {
		this.tDownloadInstallLogs = tDownloadInstallLogs;
	}

	public Set gettUserTasks() {
		return tUserTasks;
	}

	public void settUserTasks(Set tUserTasks) {
		this.tUserTasks = tUserTasks;
	}

	public Set gettUserPositions() {
		return tUserPositions;
	}

	public void settUserPositions(Set tUserPositions) {
		this.tUserPositions = tUserPositions;
	}

	public Set gettUserHobbieses() {
		return tUserHobbieses;
	}

	public void settUserHobbieses(Set tUserHobbieses) {
		this.tUserHobbieses = tUserHobbieses;
	}

	public Set gettSuggections() {
		return tSuggections;
	}

	public void settSuggections(Set tSuggections) {
		this.tSuggections = tSuggections;
	}

	public Set gettGoldChanges() {
		return tGoldChanges;
	}

	public void settGoldChanges(Set tGoldChanges) {
		this.tGoldChanges = tGoldChanges;
	}

	public Set gettClientLoginLogs() {
		return tClientLoginLogs;
	}

	public void settClientLoginLogs(Set tClientLoginLogs) {
		this.tClientLoginLogs = tClientLoginLogs;
	}

	public TArea gettArea() {
		return tArea;
	}

	public void settArea(TArea tArea) {
		this.tArea = tArea;
	}

	public TProfessio gettProfessio() {
		return tProfessio;
	}

	public void settProfessio(TProfessio tProfessio) {
		this.tProfessio = tProfessio;
	}

	public String getApkUrl() {
		return apkUrl;
	}

	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}

	public TChannel getChannel() {
		return channel;
	}

	public void setChannel(TChannel channel) {
		this.channel = channel;
	}

	public String getLeveCode() {
		return leveCode;
	}

	public void setLeveCode(String leveCode) {
		this.leveCode = leveCode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(Long inviteCode) {
		this.inviteCode = inviteCode;
	}

	
}