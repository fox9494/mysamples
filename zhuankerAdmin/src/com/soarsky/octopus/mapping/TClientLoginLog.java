package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TClientLoginLog entity. @author MyEclipse Persistence Tools
 */

public class TClientLoginLog  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private Date loginDate;
     private Date logoutDate;


    // Constructors

    /** default constructor */
    public TClientLoginLog() {
    }

	/** minimal constructor */
    public TClientLoginLog(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TClientLoginLog(Long id, TUserClient TUserClient, Date loginDate, Date logoutDate) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TUserClient getTUserClient() {
        return this.TUserClient;
    }
    
    public void setTUserClient(TUserClient TUserClient) {
        this.TUserClient = TUserClient;
    }

    public Date getLoginDate() {
        return this.loginDate;
    }
    
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return this.logoutDate;
    }
    
    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }
   








}