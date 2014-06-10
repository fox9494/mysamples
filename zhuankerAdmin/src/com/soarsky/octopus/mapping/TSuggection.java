package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TSuggection entity. @author MyEclipse Persistence Tools
 */

public class TSuggection  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private String suggection;
     private Date replayDate;
     private String mobile;
     private String email;


    // Constructors

    public Date getReplayDate() {
		return replayDate;
	}

	public void setReplayDate(Date replayDate) {
		this.replayDate = replayDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/** default constructor */
    public TSuggection() {
    }

	/** minimal constructor */
    public TSuggection(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TSuggection(Long id, TUserClient TUserClient, String suggection, String email,String mobile,Date replayDate) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.suggection = suggection;
        this.email = email;
        this.mobile = mobile;
        this.replayDate = replayDate;
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

    public String getSuggection() {
        return this.suggection;
    }
    
    public void setSuggection(String suggection) {
        this.suggection = suggection;
    }
}