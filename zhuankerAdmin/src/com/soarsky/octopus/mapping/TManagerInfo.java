package com.soarsky.octopus.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TManagerInfo entity. @author MyEclipse Persistence Tools
 */

public class TManagerInfo  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TRoleInfo TRoleInfo;
     private String userName;
     private String password;
     private String realName;
     private Date createDate;
     private Set TChannels = new HashSet(0);
     
     private Integer isRemove;


    // Constructors

    /** default constructor */
    public TManagerInfo() {
    }

	/** minimal constructor */
    public TManagerInfo(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TManagerInfo(Long id, TRoleInfo TRoleInfo, String userName, String password, String realName, Date createDate, Set TChannels) {
        this.id = id;
        this.TRoleInfo = TRoleInfo;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.createDate = createDate;
        this.TChannels = TChannels;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TRoleInfo getTRoleInfo() {
        return this.TRoleInfo;
    }
    
    public void setTRoleInfo(TRoleInfo TRoleInfo) {
        this.TRoleInfo = TRoleInfo;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set getTChannels() {
        return this.TChannels;
    }
    
    public void setTChannels(Set TChannels) {
        this.TChannels = TChannels;
    }

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
   








}