package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TInstalledApk entity. @author MyEclipse Persistence Tools
 */

public class TInstalledApk  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private String packageName;
     private String apkName;
     private Date reportDate;
     
     private String version;


    // Constructors

    /** default constructor */
    public TInstalledApk() {
    }

	/** minimal constructor */
    public TInstalledApk(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TInstalledApk(Long id, TUserClient TUserClient, String packageName, String apkName, Date reportDate) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.packageName = packageName;
        this.apkName = apkName;
        this.reportDate = reportDate;
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

    public String getPackageName() {
        return this.packageName;
    }
    
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApkName() {
        return this.apkName;
    }
    
    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public Date getReportDate() {
        return this.reportDate;
    }
    
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
   








}