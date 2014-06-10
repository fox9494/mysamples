package com.soarsky.octopus.mapping;

import java.util.Date;



/**
 * TUserPosition entity. @author MyEclipse Persistence Tools
 */

public class TUserPosition  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private String position;
     private Date  reportDate;


    // Constructors

    /** default constructor */
    public TUserPosition() {
    }

	/** minimal constructor */
    public TUserPosition(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TUserPosition(Long id, TUserClient TUserClient) {
        this.id = id;
        this.TUserClient = TUserClient;
    }

   
    // Property accessors


    public TUserClient getTUserClient() {
        return this.TUserClient;
    }
    
    public void setTUserClient(TUserClient TUserClient) {
        this.TUserClient = TUserClient;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
   








}