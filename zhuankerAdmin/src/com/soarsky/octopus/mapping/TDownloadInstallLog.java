package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TDownloadInstallLog entity. @author MyEclipse Persistence Tools
 */

public class TDownloadInstallLog  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private TApplication TApplication;
     private Integer type;
     private Date operateDate;


    // Constructors

    /** default constructor */
    public TDownloadInstallLog() {
    }

	/** minimal constructor */
    public TDownloadInstallLog(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TDownloadInstallLog(Long id, TUserClient TUserClient, TApplication TApplication, Integer type, Date operateDate) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.TApplication = TApplication;
        this.type = type;
        this.operateDate = operateDate;
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

    public TApplication getTApplication() {
        return this.TApplication;
    }
    
    public void setTApplication(TApplication TApplication) {
        this.TApplication = TApplication;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Date getOperateDate() {
        return this.operateDate;
    }
    
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }
   








}