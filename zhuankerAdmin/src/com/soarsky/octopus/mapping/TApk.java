package com.soarsky.octopus.mapping;

import java.util.Date;


/**
 * TApk entity. @author MyEclipse Persistence Tools
 */

public class TApk  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TApplication TApplication;
     private Long apkSize;
     private String downloadUrl;
     private Date uploadDate;
     private Integer resolution_width;
     private Integer resolution_height;
     private Integer isDefault;


    // Constructors

    /** default constructor */
    public TApk() {
    }

	/** minimal constructor */
    public TApk(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TApk(Long id, TApplication TApplication, Long apkSize, String downloadUrl, Date uploadDate, Boolean isDefault) {
        this.id = id;
        this.TApplication = TApplication;
        this.apkSize = apkSize;
        this.downloadUrl = downloadUrl;
        this.uploadDate = uploadDate;
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


    public String getDownloadUrl() {
        return this.downloadUrl;
    }
    
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Date getUploadDate() {
        return this.uploadDate;
    }
    
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

	public Long getApkSize() {
		return apkSize;
	}

	public void setApkSize(Long apkSize) {
		this.apkSize = apkSize;
	}

	public Integer getResolution_width() {
		return resolution_width;
	}

	public void setResolution_width(Integer resolution_width) {
		this.resolution_width = resolution_width;
	}

	public Integer getResolution_height() {
		return resolution_height;
	}

	public void setResolution_height(Integer resolution_height) {
		this.resolution_height = resolution_height;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
}