package com.soarsky.octopus.mapping;

import java.util.Date;


/**
 * TVersion entity. @author MyEclipse Persistence Tools
 */

public class TVersion  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String version;
     private String description;
     private Integer forceUpdate;
     private String apkUrl;
     private Date uploadDate;


    // Constructors

    /** default constructor */
    public TVersion() {
    }

	/** minimal constructor */
   

    public String getVersion() {
        return this.version;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getForceUpdate() {
        return this.forceUpdate;
    }
    
    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getApkUrl() {
        return this.apkUrl;
    }
    
    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public Date getUploadDate() {
        return this.uploadDate;
    }
    
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
   








}