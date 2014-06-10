package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TSystemFlow entity. @author MyEclipse Persistence Tools
 */

public class TSystemFlow  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TApplication TApplication;
     private TUserClient TUserClient;
     private Long downNum;
     private Long upNum;
     private Date reportDate;


    // Constructors

    /** default constructor */
    public TSystemFlow() {
    }

	/** minimal constructor */
    public TSystemFlow(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TSystemFlow(Long id, TApplication TApplication, TUserClient TUserClient, Long downNum, Long upNum, Date reportDate) {
        this.id = id;
        this.TApplication = TApplication;
        this.TUserClient = TUserClient;
        this.downNum = downNum;
        this.upNum = upNum;
        this.reportDate = reportDate;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TApplication getTApplication() {
        return this.TApplication;
    }
    
    public void setTApplication(TApplication TApplication) {
        this.TApplication = TApplication;
    }

    public TUserClient getTUserClient() {
        return this.TUserClient;
    }
    
    public void setTUserClient(TUserClient TUserClient) {
        this.TUserClient = TUserClient;
    }

    public Long getDownNum() {
        return this.downNum;
    }
    
    public void setDownNum(Long downNum) {
        this.downNum = downNum;
    }

    public Long getUpNum() {
        return this.upNum;
    }
    
    public void setUpNum(Long upNum) {
        this.upNum = upNum;
    }

    public Date getReportDate() {
        return this.reportDate;
    }
    
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
   








}